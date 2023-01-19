package ir.maktab.dao;

import ir.maktab.exception.DuplicationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public abstract class AbstractRepository<T> implements CrudeRepository<T> {
    @Override
    public void save(T t) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getSuppressed());
            System.out.println(e.getStackTrace());
            System.out.println(e.fillInStackTrace());
            System.out.println(e.getMessage());
            throw new DuplicationException("the entity is exist");
        } finally {
            entityManager.close();
        }
    }


    @Override
    public void update(T t) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void softDelete(T t) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
