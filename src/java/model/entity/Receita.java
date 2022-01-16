package model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
@NamedQueries({
    @NamedQuery(name = "receita.findAll", query = "SELECT r FROM Receita r")
})
public class Receita implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column        
    private Double valor;
    
    @Column
    private String dataRecebimento;
    
    @Column
    private String dataRecebimentoEsperado;
    
    @Column
    private String descrição;
    
    @Column
    private String tipoReceita;
    
    @ManyToOne
    @JoinColumn(name = "conta_id" , nullable = false) 
    private Conta conta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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
    
    
    
}
