package com.projetoAcademia.DAO;

import com.projetoAcademia.com.projetoAcadenia.Entidade.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class TelefoneDAO  extends DAO {

    public void save(Telefone fone) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(fone);
            transaction.commit();
        } catch (
                PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o telefone.", pe);
        } finally {
            em.close();
        }
    }
}