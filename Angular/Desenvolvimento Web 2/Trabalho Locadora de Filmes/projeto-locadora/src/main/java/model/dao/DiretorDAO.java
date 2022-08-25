package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.NoArgsConstructor;
import model.domain.*;
import util.ConexaoHibernate;

@NoArgsConstructor
public class DiretorDAO extends GenericDAO{
	@SuppressWarnings("unchecked")
	public List<Diretor> listarTodos(){
		Transaction transaction = null;
		List<Diretor> diretores = null;
        try {
        	Session session = ConexaoHibernate.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the client object
            diretores = (List<Diretor>) session.createCriteria(Diretor.class).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return diretores;
    }
}
