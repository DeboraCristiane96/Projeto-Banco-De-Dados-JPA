package com.projetoAcademia.DAO;

import com.projetoAcademia.com.projetoAcadenia.Entidade.Cliente;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO extends DAO {

    public void save(Cliente cliente) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(cliente);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o cliente.", pe);
        } finally {
            em.close();
        }
    }

    public Cliente update(Cliente cliente) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Cliente resultado = cliente;
        try {
            resultado = em.merge(cliente);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o cliente.", pe);
        } finally {
            em.close();
        }
        return resultado;
    }
    public void delete(Cliente cliente) throws PersistenciaDacException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            cliente = em.find(Cliente.class, cliente.getCpf());
            em.remove(cliente);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o cliente.", pe);
        } finally {
            em.close();
        }
    }
}


