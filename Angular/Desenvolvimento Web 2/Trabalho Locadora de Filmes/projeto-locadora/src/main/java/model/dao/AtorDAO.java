package model.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.NoArgsConstructor;
import model.domain.*;
import util.ConexaoHibernate;

@NoArgsConstructor
public class AtorDAO extends GenericDAO{
	@SuppressWarnings("unchecked")
	public List<Ator> listarTodos(){
		Transaction transaction = null;
		List<Ator> atores = null;
        try {
        	Session session = ConexaoHibernate.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the client object
            atores = (List<Ator>) session.createCriteria(Ator.class).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return atores;
    }

}
