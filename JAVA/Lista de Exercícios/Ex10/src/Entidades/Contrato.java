package Entidades;

import java.util.Date;
import java.util.LinkedList;

public class Contrato {
    private Integer numero;
    private Integer numParcelas;
    private Date data;
    private Double valorTotal;
    private LinkedList<Parcelas> parcelas;

    public Contrato(Integer numero, Integer numParcelas, Date data, Double valorTotal) {
        this.numero = numero;
        this.numParcelas = numParcelas;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LinkedList<Parcelas> getParcelas() {
        return parcelas;
    }

    public void setParcelas(LinkedList<Parcelas> parcelas) {
        this.parcelas = parcelas;
    }

    
    
}
