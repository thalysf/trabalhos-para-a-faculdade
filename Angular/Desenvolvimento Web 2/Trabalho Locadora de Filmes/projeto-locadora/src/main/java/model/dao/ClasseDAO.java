package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.NoArgsConstructor;
import model.domain.*;
import util.ConexaoHibernate;

@NoArgsConstructor
public class ClasseDAO extends GenericDAO{
	@SuppressWarnings("unchecked")
	public List<Classe> listarTodos(){
		Transaction transaction = null;
		List<Classe> classes = null;
        try {
        	Session session = ConexaoHibernate.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the client object
            classes = (List<Classe>) session.createCriteria(Classe.class).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return classes;
    }
}
