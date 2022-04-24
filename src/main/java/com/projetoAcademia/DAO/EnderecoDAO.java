package com.projetoAcademia.DAO;

import com.projetoAcademia.com.projetoAcadenia.Entidade.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class EnderecoDAO extends DAO {
    public void save(Endereco end) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
        em.persist(end);
        transaction.commit();
    } catch (
    PersistenceException pe) {
        pe.printStackTrace();
        if (transaction.isActive()) {
            transaction.rollback();
        }
        throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o Endereço.", pe);
    } finally {
        em.close();
    }
}


}
