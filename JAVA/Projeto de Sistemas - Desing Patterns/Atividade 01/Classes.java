public class Cliente {
    private Long id;
    private String nome;
    private String endereco;
    private int qtdLivrosEmprestados;
    private SexoEnum sexoEnum;
}
public class Autor{
    private Long id;
    private String nome;
    private String telefone;
    private SexoEnum sexoEnum;
}
public class Obra{
    private Long id;
    private String titulo;
    private Autor autor;
    private int qtdEmEstoque;
    private GeneroEnum generoEnum;
    
    public void movimentarEstoque();
}
public class Livro extends Obra{
    private Long id;
    private Double precoDeVenda;
    private String tipoDeAcabamento;
    private boolean disponivel;
}
public class Emprestimo{
    private Long id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    
    private Cliente cliente;
    private Livro livro;
    
    public void realizarEmprestimo();
}
public Enum SexoEnum
{
    FEMININO("F", "Feminino"), 
    MASCULINO("M", "Masculino")
    
    private char final codigo;
    private String final sexo;
    
    public SexoEnum(int codigo, String sexo)
    {
        this.codigo = codigo;
        this.sexo = sexo;
    }
}

public Enum GeneroEnum
{
    AVENTURA("A", "Aventura"), 
    COMEDIA("C", "Comedia")
    
    private char final codigo;
    private String final categoria;
    
    public GeneroEnum(int codigo, String categoria)
    {
        this.codigo = codigo;
        this.categoria = categoria;
    }
}
