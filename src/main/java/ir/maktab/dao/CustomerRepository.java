package ir.maktab.dao;

import ir.maktab.data.model.Customer;
import ir.maktab.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepository extends AbstractRepository<Customer> {
    private static CustomerRepository customerRepository;

    private CustomerRepository() {
    }

    public static CustomerRepository getInstance() {
        if (customerRepository == null)
            return new CustomerRepository();
        return customerRepository;
    }

    public Customer findByUsername(String username) {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Customer where username=:username";
        TypedQuery<Customer> query = entityManager.createQuery(hqlQuery, Customer.class);
        query.setParameter("username", username);
        try {
            Customer customer = query.getSingleResult();
            entityManager.getTransaction().commit();
            return customer;
        } catch (NoResultException e) {
            throw new NotFoundException("the user dose not exist");
        } finally {
            entityManager.close();
        }
    }

    public List<Customer> findAllCustomer() {
        EntityManager entityManager = EntityManagerFactoryProducer.emf.createEntityManager();
        entityManager.getTransaction().begin();
        String hqlQuery = "from Customer";
        TypedQuery<Customer> query = entityManager.createQuery(hqlQuery, Customer.class);
        List<Customer> customerList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return customerList;
    }
}
