/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.TipoVacina;
import dominio.Vacina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean_
 */

public class VacinaDAO {
    
    public VacinaDAO() {
        
    }
    public List<Vacina> pesquisarPorVacina(int tipo) throws ClassNotFoundException, SQLException{
        Statement statement = ConexaoPostgreSQL.obterConexao().createStatement();   
        String sql = "SELECT * FROM Vacina vac, TipoVacina tipo WHERE vac.idTipoVacina = tipo.idTipoVacina AND vac.idTipoVacina = " + tipo; 
        
        ResultSet result = statement.executeQuery(sql);
        
        List<Vacina> vacinas = new ArrayList<>();
        Vacina vacina;
        TipoVacina tipoVacina;
        while(result.next())
        {
            tipoVacina = new TipoVacina(result.getLong("idTipoVacina"), result.getString("descricao"));
            vacina = new Vacina(result.getLong("idVacina"), result.getString("nomeVacina"),
                                result.getInt("qtdeDoses"), tipoVacina);
            vacinas.add(vacina);
        }
        return vacinas;
        // Pesquisar no banco e retornar, através de um List,
        //   todas as vacinas do tipo especificado pelo parâmetro.
        // 1 -> COVID
        // 2 -> Outras
    }
}

