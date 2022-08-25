package exconecaopostgresql;



import java.sql.*;

public class ConexaoPotsgreSQL {
    private static Connection conexao;
    
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        String servidor = "localhost:5432";
        String nomeBanco = "tecstore";
        String url = "jdbc:postgresql://"+ servidor + "/" + nomeBanco;
        String usuario = "postgres";
        String senha = "123";
        
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem sucedida!");
            return conexao;
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    } 
    
}
