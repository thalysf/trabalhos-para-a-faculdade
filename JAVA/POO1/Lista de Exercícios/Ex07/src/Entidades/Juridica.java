package Entidades;

public class Juridica extends Pessoa{
    private Integer numeroDeFuncionarios;

    public Juridica(Integer numeroDeFuncionarios, String nome, Double renda) {
        super(nome, renda);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }
    
    @Override
    public Double pagarImposto() {
        double imposto;
        if(numeroDeFuncionarios > 10) imposto = 0.14;
        else imposto = 0.16;
        
        return getRenda() * imposto;
    }
    
}
