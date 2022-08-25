package ex02;


public class Funcionario {
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }
    
    public void aumentarSalario(double aumento)
    {
        salario = (salario) + (salario * (aumento/100));
    }

    public int getID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
    
}
