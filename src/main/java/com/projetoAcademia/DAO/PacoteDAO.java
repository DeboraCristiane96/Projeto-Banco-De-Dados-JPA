package com.projetoAcademia.DAO;

import com.projetoAcademia.com.projetoAcadenia.Entidade.Pacote;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class PacoteDAO extends DAO {

    public void save(Pacote pacote) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(pacote);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o pacote.", pe);
        } finally {
            em.close();
        }
    }

}
