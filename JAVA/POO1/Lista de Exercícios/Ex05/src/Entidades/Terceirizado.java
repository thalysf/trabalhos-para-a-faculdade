package Entidades;

public class Terceirizado extends Funcionario{
    private Double despesaAdicional;

    public Terceirizado(Double despesaAdicional, String nome, Integer horas, Double valorPorHora) {
        super(nome, horas, valorPorHora);
        this.despesaAdicional = despesaAdicional;
    }
    @Override
    public Double pagarFuncionario(){
        return super.pagarFuncionario() + (1.1 * despesaAdicional);
    }
}
