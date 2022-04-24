
package com.projetoAcademia.DAO;
import com.projetoAcademia.com.projetoAcadenia.Entidade.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author debora
 */
public class FuncionarioDAO extends DAO {
    
     public void save(Funcionario funcionario) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(funcionario);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o funcionario.", pe);
        } finally {
            em.close();
        }
    }

    public Funcionario update(Funcionario funcionario) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Funcionario resultado = funcionario;
        try {
            resultado = em.merge(funcionario);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o funcionario.", pe);
        } finally {
            em.close();
        }
        return resultado;
    }
    public void delete(Funcionario funcionario) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            funcionario = em.find(Funcionario.class, funcionario.getCpf());
            em.remove(funcionario);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o funcionario.", pe);
        } finally {
            em.close();
        }
    }
}
