/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.PacienteDaoUtil;
import dominio.Paciente;
import dominio.TipoVacina;
import dominio.Vacina;
import gertarefas.FuncoesUteis;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jean_
 */
public class PacienteDAO {

    public PacienteDAO() {

    }

    public Long inserir(Paciente pac) throws ClassNotFoundException, SQLException {
        // Inserir todos os dados de um Paciente no banco de dados       
        // Observe que o parâmetro é um objeto do tipo Paciente, 
        //   portanto você deverá ler de um Frame os dados, criar um objeto 
        //   do tipo Paciente e passar como parâmetro para essa função
        //
        // Se for COVID 1ª dose, inserir também a data agendada da segunda dose
        // Se não existir a data da Segunda Dose, então inserir null
        //
        // precisaDose2 -> recebe 0 (zero) quando NÃO precisar da segunda dose e
        //                 recebe 1 quando ainda precisar tomar a segunda dose
        String sql = "INSERT INTO Paciente(nomePaciente, cpf, dtDose1, dtDose2, precisaDose2, idVacina) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = ConexaoPostgreSQL.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        int i = 1;
        pst.setString(i++, pac.getNomePaciente());
        pst.setString(i++, pac.getCpf());
        pst.setDate(i++, FuncoesUteis.utilDateToSqlDate(pac.getDtDose1()));
        if (pac.getDtDose2() != null) {
            pst.setDate(i++, FuncoesUteis.utilDateToSqlDate(pac.getDtDose2()));
        } else {
            pst.setDate(i++, null);
        }
        pst.setInt(i++, pac.getPrecisaDose2());
        pst.setLong(i++, pac.getVacina().getIdVacina());

        pst.execute();

        ResultSet res = pst.getGeneratedKeys();
        Long id = 0L;
        if (res.next()) {
            id = res.getLong(1);
            pac.setIdPaciente(id);
        }
        return id;
    }

    public Long alterar(Long id, Date dose2) throws ParseException, ClassNotFoundException, SQLException {
        // Alterar a data da segunda dose do paciente identificado pelo parâmetro ID
        // Alterar também o campo precisaDose2 para 0 (zero)
        String dataDose2Banco = FuncoesUteis.dateToStr(dose2);
        // Verifico se o Paciente está associado a uma vacina que possua segunda dose
        Paciente paciente = pesquisarPorID(id);
        if (paciente.getPrecisaDose2() != null) {
            if (paciente.getPrecisaDose2() == 1) {
                String sql = "UPDATE Paciente set dtDose2 = ?, precisaDose2 = 0 where idPaciente = " + id;
                PreparedStatement pst = ConexaoPostgreSQL.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int i = 1;
                pst.setDate(i, FuncoesUteis.utilDateToSqlDate(dose2));
                pst.execute();

                ResultSet res = pst.getGeneratedKeys();

                Long idEncontrado = 0L;
                if (res.next()) {
                    idEncontrado = res.getLong(1);
                }

                return idEncontrado;
            }
        }
        return -1L;
    }

    public Paciente pesquisarPorID(Long id) throws ClassNotFoundException, SQLException {
        // Pesquisar no banco e retorna um objeto do tipo Paciente
        //    de acordo com o id do paciente
        String sql = "SELECT * FROM Paciente p, Vacina v, TipoVacina t WHERE p.idPaciente = " + id + " and p.idVacina = v.idVacina and v.idTipoVacina = t.idTipoVacina";
        Statement statement = ConexaoPostgreSQL.obterConexao().createStatement();
        ResultSet result = statement.executeQuery(sql);
        Paciente paciente = new Paciente();
        Vacina vacina = new Vacina();
        TipoVacina tipoVacina = new TipoVacina();
        if (result.next()) {
            PacienteDaoUtil.preencherCamposPaciente(paciente, vacina, tipoVacina, result);
        }

        return paciente;
    }

    public List<Paciente> pesquisarSegundaDose() throws ClassNotFoundException, SQLException {
        // Pesquisar no banco e retornar, através de um List,
        //   todos os pacientes que precisam da segunda dose,
        //   ou seja, cujo campo precisaDose2 é igual a 1
        Statement statement = ConexaoPostgreSQL.obterConexao().createStatement();
        String sql = "Select * FROM Paciente p , Vacina v, TipoVacina t WHERE p.idVacina = v.idVacina "
                + "AND v.idTipoVacina = t.idTipoVacina AND p.precisaDose2 = 1";
        ResultSet result = statement.executeQuery(sql);

        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente;
        Vacina vacina;
        TipoVacina tipoVacina;
        while (result.next()) {
            paciente = new Paciente();
            vacina = new Vacina();
            tipoVacina = new TipoVacina();
            PacienteDaoUtil.preencherCamposPaciente(paciente, vacina, tipoVacina, result);

            // Inserindo o Paciente na lista de Pacientes
            pacientes.add(paciente);
        }
        return pacientes;
    }

    public List<Paciente> pesquisarPorVacina(Vacina vacina) throws ClassNotFoundException, SQLException {
        // Pesquisar no banco e retornar, através de um List,
        //   todos os pacientes que tomaram a vacina passanda pelo parâmetro.
        Statement statement = ConexaoPostgreSQL.obterConexao().createStatement();
        String sql = "Select * FROM Paciente p , Vacina v, TipoVacina t WHERE p.idVacina = v.idVacina "
                + "AND v.idTipoVacina = t.idTipoVacina AND v.nomeVacina = '" + vacina.getNomeVacina() + "' ORDER BY t.descricao ASC";
        ResultSet result = statement.executeQuery(sql);

        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente;
        TipoVacina tipoVacina;
        while (result.next()) {
            paciente = new Paciente();
            vacina = new Vacina();
            tipoVacina = new TipoVacina();
            PacienteDaoUtil.preencherCamposPaciente(paciente, vacina, tipoVacina, result);

            // Inserindo o Paciente na lista de Pacientes
            pacientes.add(paciente);
        }
        return pacientes;
    }

    public List<Paciente> listar() throws ClassNotFoundException, SQLException {
        // Pesquisar no banco e retornar, através de um List,
        // todos os pacientes
        Statement statement = ConexaoPostgreSQL.obterConexao().createStatement();
        String sql = "Select * FROM Paciente p , Vacina v, TipoVacina t WHERE p.idVacina = v.idVacina "
                + "AND v.idTipoVacina = t.idTipoVacina ORDER BY p.idPaciente DESC";

        ResultSet result = statement.executeQuery(sql);

        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente;
        Vacina vacina;
        TipoVacina tipoVacina;
        while (result.next()) {
            paciente = new Paciente();
            vacina = new Vacina();
            tipoVacina = new TipoVacina();
            PacienteDaoUtil.preencherCamposPaciente(paciente, vacina, tipoVacina, result);

            // Inserindo o Paciente na lista de Pacientes
            pacientes.add(paciente);
        }
        return pacientes;
    }
}
