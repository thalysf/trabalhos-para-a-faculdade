package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelas {
    private Date dataDeVencimento;
    private Double valor;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public Parcelas(Date dataDeVencimento, Double valor) {
        this.dataDeVencimento = dataDeVencimento;
        this.valor = valor;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return dateFormat.format(dataDeVencimento) + " - " + valor;
    }
    
}
