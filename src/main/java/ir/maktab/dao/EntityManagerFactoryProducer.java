package ir.maktab.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
}

