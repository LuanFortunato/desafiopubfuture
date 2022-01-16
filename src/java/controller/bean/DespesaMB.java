package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import model.dao.DespesaDAO;
import model.entity.Conta;
import model.entity.Despesa;
import utils.Mensagens;

@Named(value = "despesaMB")
@RequestScoped
public class DespesaMB {

    @Inject
    private DespesaDAO despesaDAO;
    
    private Integer id;
    private Double valor;
    private String dataPagamento;
    private String dataPagamentoEsperado;
    private String tipoDespesa;
    private Conta conta;
    private List<Despesa> despesaFilterList;
    private List<Despesa> todasDespesas;
    
    
    public DespesaMB() {
        conta = new Conta();
    }
    
    public String salvarDespesa()
    {
        if (valor < 0 || dataPagamento.length() < 1 || dataPagamentoEsperado.length() < 1 || tipoDespesa.length() <= 2 || conta == null) {
            Mensagens.exibeMensagem(FacesMessage.SEVERITY_ERROR, "Preenchimento incompleto!", "Verifique se todos os campos estão devidamente preenchidos");
            if(id != null)
                return "desepesas?faces-redirect=true";
            else {
                return "cadastroDespesas?faces-redirect=true";
            }
        }
        
        Despesa d = new Despesa();
        
        if(getId()!= null){
            d = despesaDAO.getById(getId());
        }
        
        d.setValor(valor);
        d.setDataPagamento(dataPagamento);
        d.setDataPagamentoEsperado(dataPagamentoEsperado);
        d.setTipoDespesa(tipoDespesa);
        d.setConta(conta);
        
        despesaDAO.salvar(d);
        
        return "despesas?faces-redirect=true";
        
    }
    public void editarDespesa(Despesa despesa){

        valor = despesa.getValor();
        dataPagamento = despesa.getDataPagamento();
        dataPagamentoEsperado = despesa.getDataPagamentoEsperado();
        tipoDespesa = despesa.getTipoDespesa();
        conta = despesa.getConta();
        id = despesa.getId();
        
    }
    
    public String removerDespesa(Despesa despesa){
        
        id = despesa.getId();
        Despesa d = despesaDAO.getById(id);
        despesaDAO.remover(d);
        
        return "despesas?faces-redirect=true";
    }
    
    public Double getValorDespesas(){ 
        todasDespesas = despesaDAO.recuperarTodosRegistros("despesa.findAll");
        double total = 0;
        for (Despesa despesa: todasDespesas ){
            total = total+ despesa.getValor();
        }
        return total;
    }
    
    public Integer getTotalDespesas(){ 
        todasDespesas = despesaDAO.recuperarTodosRegistros("despesa.findAll");
        int total = 0;
        for (Despesa d: todasDespesas ){
            total = total+1;
        }
        return total;
    }
    
    public List<Despesa> getTodasDespesas(){ 
        return despesaDAO.recuperarTodosRegistros("despesa.findAll");
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(String dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Despesa> getDespesaFilterList() {
        return despesaFilterList;
    }

    public void setDespesaFilterList(List<Despesa> despesaFilterList) {
        this.despesaFilterList = despesaFilterList;
    }
    
}
