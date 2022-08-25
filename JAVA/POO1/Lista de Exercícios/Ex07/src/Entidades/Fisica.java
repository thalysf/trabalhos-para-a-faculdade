package Entidades;

public class Fisica extends Pessoa{
    private Double gastosComSaude;

    public Fisica(Double gastosComSaude, String nome, Double renda) {
        super(nome, renda);
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public Double pagarImposto() {
        double imposto;
        double desconto;
        if(getRenda() < 20000) imposto = 0.15;
        else imposto = 0.25;
        
        if(gastosComSaude > 0)
        {
            return ((getRenda() * imposto) - (0.5 * gastosComSaude));
        }
        return getRenda() * imposto;
    }
    
}
