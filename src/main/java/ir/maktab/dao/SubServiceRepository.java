package ir.maktab.dao;

import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;
import ir.maktab.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class SubServiceRepository extends AbstractRepository<SubService> {
    private static SubServiceRepository subServiceRepository;

    private SubServiceRepository() {
    }

    public static SubServiceRepository getInstance() {
        if (subServiceRepository == null)
            return new SubServiceRepository();
        return subServiceRepository;
    }

    public List<SubService> findAllSubServiceByService(Service service) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from SubService where service=:service and isDeleted=false";
        TypedQuery<SubService> query = entityManager.createQuery(hqlQuery, SubService.class);
        query.setParameter("service", service);
        List<SubService> subServiceList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return subServiceList;
    }

    public List<SubService> findAllEnableSubService() {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from SubService where isDeleted=false";
        TypedQuery<SubService> query = entityManager.createQuery(hqlQuery, SubService.class);
        List<SubService> subServiceList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return subServiceList;
    }

    public SubService findSubServiceByName(String subServiceName) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from SubService where name=:subServiceName and isDeleted=false";
        TypedQuery<SubService> query = entityManager.createQuery(hqlQuery, SubService.class);
        query.setParameter("subServiceName", subServiceName);
        try {
            SubService subService = query.getSingleResult();
            entityManager.getTransaction().commit();
            return subService;
        } catch (NoResultException e) {
            throw new NotFoundException("the subService dose not exist");
        } finally {
            entityManager.close();
        }
    }

    public boolean isExist(String subServiceName) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from SubService where name=:subServiceName";
        TypedQuery<SubService> query = entityManager.createQuery(hqlQuery, SubService.class);
        query.setParameter("subServiceName", subServiceName);
        try {
            query.getSingleResult();
            entityManager.getTransaction().commit();
            return true;
        } catch (NoResultException e) {
            return false;
        } finally {
            entityManager.close();
        }
    }
}

