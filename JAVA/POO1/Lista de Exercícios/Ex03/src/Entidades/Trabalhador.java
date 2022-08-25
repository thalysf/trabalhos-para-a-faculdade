package Entidades;
import Entidades.Enumeracao.NivelTrabalhador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Trabalhador {
    private String nome;
    private Departamento departamento;
    private NivelTrabalhador nivel;
    private Double salarioBase;
    private List<Contrato> contratos = new ArrayList<>();
    // Constructors
    public Trabalhador(String nome, Departamento departamento, NivelTrabalhador nivel, double salarioBase) {
        this.nome = nome;
        this.departamento = departamento;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
    }
    
    // Getters
    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }
    // Adicionando um contrato
    public void addContrato(Contrato contrato)
    {
        this.contratos.add(contrato);
    }
    // Removendo um contrato
    public void removerContrato(Contrato contrato)
    {
        this.contratos.remove(contrato);
    }
    // Salário do mês x
    public Double ganhoDoMes(Date data)
    {
        Double ganho = 0.0;
        for (Contrato contrato : contratos) {
            if(contrato.getData().getMonth() == data.getMonth() && contrato.getData().getYear() == data.getYear())
            {
                ganho += contrato.valorContrato();
            }
        }
        return ganho;
    }
    
    // ToString

    @Override
    public String toString() {
        return "Informações acerca do trabalhador " + nome + "\n" +
               "Departamento: " + departamento.getNomeDepart() + "\n" +
               "Nível: " + nivel + "\n" +
               "Salário Base: " + salarioBase + "\n" +
               "Total de contratos: " + contratos.size(); 
    }
    
}
