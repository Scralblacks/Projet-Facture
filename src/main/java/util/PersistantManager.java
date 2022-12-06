package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistantManager {

    private static EntityManagerFactory FACTORY_INSTANCE;

    private PersistantManager(){

    }

    public static EntityManagerFactory getFactoryInstance(){
        if (FACTORY_INSTANCE == null || !FACTORY_INSTANCE.isOpen() ) {
            FACTORY_INSTANCE = Persistence.createEntityManagerFactory("MyPU");
        }
        return FACTORY_INSTANCE;
    }

    public static void closePersistant() {
        try {
            FACTORY_INSTANCE.close();
        } catch (Exception e) {
            System.err.println("Fermeture de la connexion impossible");
        }
    }
}

