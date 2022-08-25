/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gertarefas;

import dao.ConexaoPostgreSQL;
import dao.PacienteDAO;
import dao.VacinaDAO;
import dominio.Paciente;
import dominio.Vacina;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author jean_
 */
public class GerenciadorDominio {
    // DAO's
    private VacinaDAO vacinaDAO;
    private PacienteDAO pacienteDAO;
    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
       ConexaoPostgreSQL.obterConexao();    
       this.vacinaDAO = new VacinaDAO();
       this.pacienteDAO = new PacienteDAO();
    }
    
    // VACINACAO 
    public List<Vacina> pesquisarPorVacina(int tipo) throws ClassNotFoundException, SQLException
    {
       return vacinaDAO.pesquisarPorVacina(tipo);
    }
    
    // PACIENTE
     public Long inserirPaciente(Paciente pac) throws ClassNotFoundException, SQLException{    
        return pacienteDAO.inserir(pac);
     }
     public Long alterarPaciente(Long id, Date dose2) throws ParseException, ClassNotFoundException, SQLException {
         return pacienteDAO.alterar(id, dose2);
     }
     public Paciente pesquisarPacientePorID(Long id) throws ClassNotFoundException, SQLException
     {
         return pacienteDAO.pesquisarPorID(id);
     }
     public List<Paciente> listarPacientes() throws ClassNotFoundException, SQLException {
         return pacienteDAO.listar();
     }
     public List<Paciente> pesquisarPorVacina(Vacina vacina) throws ClassNotFoundException, SQLException{
         return pacienteDAO.pesquisarPorVacina(vacina);
     }
     public List<Paciente> pesquisarSegundaDose()  throws ClassNotFoundException, SQLException{
         return pacienteDAO.pesquisarSegundaDose();
     }
}






