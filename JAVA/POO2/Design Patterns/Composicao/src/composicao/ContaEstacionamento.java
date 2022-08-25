/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

/**
 *
 * @author thaly
 */
public class ContaEstacionamento {
    private String carro;
    private Integer tempo;
    private CalculoValor calculo = new CalculoHora(); // valor default

    public void printaConta()
    {
        if(tempo < 12)
        {
            this.setCalculo(new CalculoHora());
        }
        else if(tempo < 24)
        {
            this.setCalculo(new CalculoDiaria());
        }
        else
        {
            this.setCalculo(new CalculoMes());
        };
        calculo.calcular();
    }

    public ContaEstacionamento(String carro, Integer tempo) {
        this.carro = carro;
        this.tempo = tempo;
    }
    
    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public CalculoValor getCalculo() {
        return calculo;
    }

    public void setCalculo(CalculoValor calculo) {
        this.calculo = calculo;
    }
}
