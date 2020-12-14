package Entidades;

import java.util.Date;

public class Contrato {
    private final Date data;
    private final Double valorPorHora;
    private final Integer horas;

    public Contrato(Date data, Double valorPorHora, Integer horas) {
        this.data = data;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public Date getData() {
        return data;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }
    public Double valorContrato()
    {
        return (Double) (this.getHoras() * this.getValorPorHora());
    }
    
}
