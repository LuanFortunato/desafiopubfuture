package controller.bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "trocaTelaB")
@Dependent
public class TrocaTelaB {

    public TrocaTelaB() {
    }
    
    public String getTelaInicial(){
        return "index?faces-redirect=true";
    }
    
    public String getReceitas(){
        return "receitas?faces-redirect=true";
    }
    
    public String getDespesas(){
        return "despesas?faces-redirect=true";
    }
    
    public String getContas(){
        return "contas?faces-redirect=true";
    }
    
    public String getCadastroReceitas(){
        return "cadastroReceitas?faces-redirect=true";
    }
    
    public String getCadastroDespesas(){
        return "cadastroDespesas?faces-redirect=true";
    }
    public String getCadastroContas(){
        return "cadastroContas?faces-redirect=true";
    }
    
}
