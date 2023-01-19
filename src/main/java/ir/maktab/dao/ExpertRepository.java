package ir.maktab.dao;

import ir.maktab.data.enums.ExpertRegistrationStatus;
import ir.maktab.data.model.Customer;
import ir.maktab.data.model.Expert;
import ir.maktab.data.model.Service;
import ir.maktab.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ExpertRepository extends AbstractRepository<Expert> {
    private static ExpertRepository expertRepository;

    private ExpertRepository() {
    }

    public static ExpertRepository getInstance() {
        if (expertRepository == null)
            return new ExpertRepository();
        return expertRepository;
    }

    public Expert findByUsername(String username) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Expert where username=:username and isDeleted=false";
        TypedQuery<Expert> query = entityManager.createQuery(hqlQuery, Expert.class);
        query.setParameter("username", username);
        try {
            Expert expert = query.getSingleResult();
            entityManager.getTransaction().commit();
            return expert;
        } catch (NoResultException e) {
            throw new NotFoundException("the user dose not exist");
        } finally {
            entityManager.close();
        }
    }

    public List<Expert> findAllWithNewExpertRegistrationStatus() {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Expert where expertRegistrationStatus=:expertRegistrationStatus";
        TypedQuery<Expert> query = entityManager.createQuery(hqlQuery, Expert.class);
        query.setParameter("expertRegistrationStatus", ExpertRegistrationStatus.NEW);
        List<Expert> customerList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return customerList;
    }

    public boolean isExist(String email) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Expert where email=:email and isDeleted=false ";
        TypedQuery<Expert> query = entityManager.createQuery(hqlQuery, Expert.class);
        query.setParameter("email", email);
        try {
            Expert expert = query.getSingleResult();
            entityManager.getTransaction().commit();
            return true;
        } catch (NoResultException e) {
            return false;
        } finally {
            entityManager.close();
        }
    }
}
