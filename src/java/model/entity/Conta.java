package model.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
@NamedQueries({
    @NamedQuery(name = "conta.findAll", query = "SELECT c FROM Conta c")
})
public class Conta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private Double saldo;
    
    @Column
    private String tipoConta;
    
    @Column
    private String instituiçãoFinanceira;
    
    @OneToMany (mappedBy = "conta", cascade = CascadeType.REMOVE)
    private Set<Receita> receita;
    
    @OneToMany(mappedBy = "conta", cascade = CascadeType.REMOVE)
    private Set<Despesa> despesa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Receita> getReceita() {
        return receita;
    }

    public void setReceita(Set<Receita> receita) {
        this.receita = receita;
    }

    public Set<Despesa> getDespesa() {
        return despesa;
    }

    public void setDespesa(Set<Despesa> despesa) {
        this.despesa = despesa;
    }
    
    @Override
    public String toString(){
        return id.toString();
    }
    
}
