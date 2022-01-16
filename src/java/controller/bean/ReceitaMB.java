package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import utils.Mensagens;
import javax.inject.Inject;
import model.dao.ReceitaDAO;
import model.entity.Conta;
import model.entity.Receita;
@Named(value = "receitaMB")
@RequestScoped
public class ReceitaMB {

    @Inject
    private ReceitaDAO receitaDAO;
    
    private Integer id;
    private Double valor;
    private String dataRecebimento;
    private String dataRecebimentoEsperado;
    private String descrição;
    private String tipoReceita;
    private Conta conta;
    private List<Receita> receitaFilterList;
    private List<Receita> todasReceitas;
    
    public ReceitaMB() {
        conta = new Conta();
       
    }

    public String salvarReceita()
    {
        if (valor < 0 || descrição.length() < 1 || dataRecebimento.length() < 1 || dataRecebimentoEsperado.length() < 1 || tipoReceita.length() <= 2 || conta == null) {
            Mensagens.exibeMensagem(FacesMessage.SEVERITY_ERROR, "Preenchimento incompleto!", "Verifique se todos os campos estão devidamente preenchidos");
            if(id != null)
                return "receitas?faces-redirect=true";
            else {
                return "cadastroReceitas?faces-redirect=true";
            }
        }
        
        Receita r = new Receita();
        
        if(id != null){
            r = receitaDAO.getById(id);
        }
        
        r.setValor(valor);
        r.setDataRecebimento(dataRecebimento);
        r.setDataRecebimentoEsperado(dataRecebimentoEsperado);
        r.setDescrição(descrição);
        r.setTipoReceita(tipoReceita);
        r.setConta(conta);
        
        receitaDAO.salvar(r);
        
        return "receitas?faces-redirect=true";
    }
    
    public void editarReceita(Receita receita){
        
        valor = receita.getValor();
        dataRecebimento = receita.getDataRecebimento();
        dataRecebimentoEsperado = receita.getDataRecebimentoEsperado();
        descrição = receita.getDescrição();
        tipoReceita = receita.getTipoReceita();
        conta = receita.getConta();
        id = receita.getId();
        
    }
    
    public String removerReceita(Receita receita){
        
        id = receita.getId();
        Receita r = receitaDAO.getById(id);
        receitaDAO.remover(r);
        
        return "receitas?faces-redirect=true";
    }
    
    public Double getValorReceitas(){ 
        todasReceitas = receitaDAO.recuperarTodosRegistros("receita.findAll");
        double total = 0;
        for (Receita receita: todasReceitas ){
            total = total+ receita.getValor();
        }
        return total;
    }
    
    public Integer getTotalReceitas(){ 
        todasReceitas = receitaDAO.recuperarTodosRegistros("receita.findAll");
        int total = 0;
        for (Receita r: todasReceitas ){
            total = total+1;
        }
        return total;
    }
    
    public List<Receita> getTodasReceitas(){ 
        return receitaDAO.recuperarTodosRegistros("receita.findAll");
        
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(String dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
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

    public List<Receita> getReceitaFilterList() {
        return receitaFilterList;
    }

    public void setReceitaFilterList(List<Receita> receitaFilterList) {
        this.receitaFilterList = receitaFilterList;
    }
    
    
}
