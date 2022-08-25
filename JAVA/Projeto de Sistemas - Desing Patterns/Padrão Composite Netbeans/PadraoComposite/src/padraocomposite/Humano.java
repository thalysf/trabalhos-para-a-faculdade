package padraocomposite;

public abstract class Humano {
    private String nome;
    private Integer idade;
    private SexoEnum sexo;

    public Humano(String nome, Integer idade, SexoEnum sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }
   
    public void exibirInfoHumano()
    {
        System.out.println(String.format("%s - %d anos %s", this.nome, this.idade, this.sexo.getLabel()));
    }
    public abstract void addFilho(Humano humano);
}
