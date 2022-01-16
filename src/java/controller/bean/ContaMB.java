package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import model.dao.ContaDAO;
import model.entity.Conta;
import utils.Mensagens;

@Named(value = "contaMB")
@RequestScoped
public class ContaMB {
  
    @Inject
    private ContaDAO contaDAO;
    
    private Integer id;
    private Double saldo;
    private String tipoConta;
    private String instituiçãoFinanceira;
    private List<Conta> todasContas;
    private Integer contaT;
    private Double quantiaT;
    
    public ContaMB() {
    }

    public String salvarConta(){
        
        if (saldo < 0 || tipoConta == null || instituiçãoFinanceira.length() < 1) {
            Mensagens.exibeMensagem(FacesMessage.SEVERITY_ERROR, "Preenchimento incompleto!", "Verifique se todos os campos estão devidamente preenchidos");
            if(id != null)
                return "contas?faces-redirect=true";
            else {
                return "cadastroContas?faces-redirect=true";
            }
        }
        
        Conta c = new Conta();
        
        if(getId()!= null){
            c = contaDAO.getById(id);
        }
        
        c.setSaldo(saldo);
        c.setTipoConta(tipoConta);
        c.setInstituiçãoFinanceira(instituiçãoFinanceira);
        
        contaDAO.salvar(c);
        
        return "contas?faces-redirect=true";
    }
    
    public void editarConta(Conta conta){
        
        saldo = conta.getSaldo();
        instituiçãoFinanceira = conta.getInstituiçãoFinanceira();
        tipoConta = conta.getTipoConta();
        id = conta.getId();
        
    }
    
    public void iniciarTransferencia(Conta conta){
        
        saldo = conta.getSaldo();
        instituiçãoFinanceira = conta.getInstituiçãoFinanceira();
        tipoConta = conta.getTipoConta();
        id = conta.getId();
        
    }
   
    public void confirmarTransferencia(){
        Conta c = new Conta();
        
        c = contaDAO.getById(id);
        
        c.setSaldo(saldo - getQuantiaT());
       
        contaDAO.salvar(c);
        
        Conta r = new Conta();
        
        r = contaDAO.getById(contaT);
        
        r.setSaldo(r.getSaldo() + getQuantiaT());
       
        contaDAO.salvar(r);
        
    }

    public String removerConta(Conta conta){
        
        id = conta.getId();
        Conta c = contaDAO.getById(id);
        contaDAO.remover(c);
        
        return "contas?faces-redirect=true";
    }
    
    public Double getSaldoTotal(){ 
        todasContas = contaDAO.recuperarTodosRegistros("conta.findAll");
        double total = 0;
        for (Conta  conta: todasContas ){
            total = total+ conta.getSaldo();
        }
        return total;
    }
    
    public List<Conta> getTodasContas(){ 
        return contaDAO.recuperarTodosRegistros("conta.findAll");
    }
    
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getInstituiçãoFinanceira() {
        return instituiçãoFinanceira;
    }

    public void setInstituiçãoFinanceira(String instituiçãoFinanceira) {
        this.instituiçãoFinanceira = instituiçãoFinanceira;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Double getQuantiaT() {
        return quantiaT;
    }

    public void setQuantiaT(Double quantiaT) {
        this.quantiaT = quantiaT;
    }

    public Integer getContaT() {
        return contaT;
    }

    public void setContaT(Integer contaT) {
        this.contaT = contaT;
    }
    
}
