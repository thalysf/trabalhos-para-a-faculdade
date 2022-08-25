package dao;
import java.sql.*;

public class ConexaoPostgreSQL {
     private static Connection conexao;
    
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        String servidor = "localhost:5432";
        String nomeBanco = "vacinacao";
        String url = "jdbc:postgresql://"+ servidor + "/" + nomeBanco;
        String usuario = "postgres";
        String senha = "123";
        
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;
    } 
}
