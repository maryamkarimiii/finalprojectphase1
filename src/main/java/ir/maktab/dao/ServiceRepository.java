package ir.maktab.dao;

import ir.maktab.data.model.Service;
import ir.maktab.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ServiceRepository extends AbstractRepository<Service> {
    private static ServiceRepository serviceRepository;

    private ServiceRepository() {
    }

    public static ServiceRepository getInstance() {
        if (serviceRepository == null)
            return new ServiceRepository();
        return serviceRepository;
    }

    public Service findServiceByName(String name) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Service where name=:name and isDeleted=false ";
        TypedQuery<Service> query = entityManager.createQuery(hqlQuery, Service.class);
        query.setParameter("name", name);
        try {
            Service service = query.getSingleResult();
            entityManager.getTransaction().commit();
            return service;
        } catch (NoResultException e) {
            throw new NotFoundException("the service dose not exist");
        } finally {
            entityManager.close();
        }
    }

    public List<Service> findAllEnableService() {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Service where isDeleted=false ";
        TypedQuery<Service> query = entityManager.createQuery(hqlQuery, Service.class);
        List<Service> serviceList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return serviceList;
    }

    public boolean isExist(String serviceName) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Service where name=:serviceName";
        TypedQuery<Service> query = entityManager.createQuery(hqlQuery, Service.class);
        query.setParameter("serviceName", serviceName);
        try {
            Service service = query.getSingleResult();
            entityManager.getTransaction().commit();
            return true;
        } catch (NoResultException e) {
            return false;
        } finally {
            entityManager.close();
        }
    }
}
