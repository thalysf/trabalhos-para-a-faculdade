package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.NoArgsConstructor;
import model.domain.Titulo;
import util.ConexaoHibernate;

@NoArgsConstructor
public class TituloDAO extends GenericDAO{
	@SuppressWarnings("unchecked")
	public List<Titulo> listarTodos(){
		Transaction transaction = null;
		List<Titulo> titulos = null;
        try {
        	Session session = ConexaoHibernate.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the client object
            titulos = (List<Titulo>) session.createCriteria(Titulo.class).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return titulos;
    }
}
