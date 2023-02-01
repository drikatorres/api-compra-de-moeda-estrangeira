package br.com.ada.compra.moeda.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Compra {
    @Id
    private String cpf;
    private Moeda moeda;
    private BigDecimal valor;
    private String agencia;

    public Compra(String cpf, Moeda moeda, BigDecimal valor, String agencia) {
        this.cpf = cpf;
        this.moeda = moeda;
        this.valor = valor;
        this.agencia = agencia;
    }

    public Compra() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
