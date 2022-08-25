package exconecaopostgresql;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {       
        //ConexaoPotsgreSQL.obterConexao();
        
        Map<String, Integer> itens = new HashMap<>();
        itens.put("Produto 01", 20);
        itens.put("Produto 02", 10);
        itens.put("Produto 03", 30);
        System.out.println("");
        itens.forEach((key, value) -> {
            System.out.println("ITEM: " + key + " KEY: " + value);
        });
        
        String test = "";
        int i = 0;
        test = (0 == 0? "":  "");
    }
    
}
