package com.projetoAcademia.DAO;

import com.projetoAcademia.com.projetoAcadenia.Entidade.Pagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class PagamentoDAO extends DAO {

    public void save(Pagamento pg) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(pg);
            transaction.commit();
        } catch (
                PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o pagamento.", pe);
        } finally {
            em.close();
        }


    }
}