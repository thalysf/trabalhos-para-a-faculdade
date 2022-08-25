/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import dominio.Paciente;
import dominio.TipoVacina;
import dominio.Vacina;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thalys
 */
public class PacienteDaoUtil {
    
    // Método em que utilizo em vários outros métodos da Classe PacienteDAO
    // Por esse motivo achei válido criar um Util pra evitar repetição de código
    public static Paciente preencherCamposPaciente(Paciente paciente, Vacina vacina, TipoVacina tipoVacina, ResultSet result) throws SQLException
    {
            // Paciente
            paciente.setIdPaciente(result.getLong("idPaciente"));
            paciente.setNomePaciente(result.getString("nomePaciente"));
            paciente.setCpf(result.getString("cpf"));
            paciente.setDtDose1(result.getDate("dtDose1"));
            paciente.setDtDose2(result.getDate("dtDose2"));
            paciente.setPrecisaDose2(result.getInt("precisaDose2"));
            
            // Vacina do Paciente
            
            vacina.setIdVacina(result.getLong("idVacina"));
            vacina.setNomeVacina(result.getString("nomeVacina"));
            vacina.setQtdeDoses(result.getInt("qtdeDoses"));
            
            // Tipo da vacina do Paciente
            tipoVacina.setIdTipoVacina(result.getLong("idTipoVacina"));
            tipoVacina.setDescricao(result.getString("descricao"));
            
            // Agrupando todas informações
            vacina.setTipoVacina(tipoVacina);
            paciente.setVacina(vacina);
            return paciente;
    }
}
