package Entidades;

public abstract class Pessoa {
    public String nome;
    public Double renda;

    public Pessoa(String nome, Double renda) {
        this.nome = nome;
        this.renda = renda;
    }
    public abstract Double pagarImposto();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }
}
