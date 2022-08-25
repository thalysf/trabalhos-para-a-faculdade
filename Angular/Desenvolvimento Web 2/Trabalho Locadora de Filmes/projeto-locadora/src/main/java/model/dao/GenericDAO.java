package model.dao;

import org.hibernate.Session;
import lombok.NoArgsConstructor;
import util.ConexaoHibernate;

@NoArgsConstructor
public class GenericDAO {
	
    public void inserir(Object entidade) {
        Session sessao = null;
        try {

            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.save(entidade);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (Exception e) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
        }
    }
	
    public void excluir(Object entidade) {
        Session sessao = null;
        try {

            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.delete(entidade);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (Exception e) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
        }
    }
    public void alterar(Object entidade){
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.update(entidade);
            
            sessao.getTransaction().commit();
        } catch (Exception e) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {
        	sessao.close();
        }
    }
}
