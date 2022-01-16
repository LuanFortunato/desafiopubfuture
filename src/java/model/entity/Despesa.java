package model.entity;

import java.io.Serializable;
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
@Table(name = "despesa")
@NamedQueries({
    @NamedQuery(name = "despesa.findAll", query = "SELECT d FROM Despesa d")
})
public class Despesa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private Double valor;
    
    @Column
    private String dataPagamento;
    
    @Column
    private String dataPagamentoEsperado;
    
    @Column
    private String tipoDespesa;
    
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
    
    
    
}
