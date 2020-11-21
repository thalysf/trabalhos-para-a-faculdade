package trabalhopoo1_2020_2;

public abstract class Carro {
    private String codigo;
    private String nome;
    private String cor;
    private String tipo;
    private Motor motor;
 
    public Carro(String codigo, String nome, String cor, String tipo, Motor motor) {
        this.codigo = codigo;
        this.nome = nome;
        this.cor = cor;
        this.tipo = tipo;
        this.motor = motor;
    }
    public abstract void construir(Estoque estoque) throws FaltouInsumoException;

    @Override
    public String toString() {
        return "Carro{" + "codigo=" + codigo + ", nome=" + nome + ", cor=" + cor + ", tipo=" + tipo + ", motor=" + motor + '}';
    }
  
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public Motor getMotor() {
        return motor;
    }
    
}
