package fr.test.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

    private static final String PERSISTENCE_UNIT_NAME = "WebStore";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
