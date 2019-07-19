package org.kodejava.example.jpa;

import org.kodejava.example.model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetEntityIdDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();

        Artist artist = manager.find(Artist.class, 1L);
        if (artist != null) {
            Object identifier = 
                    factory.getPersistenceUnitUtil().getIdentifier(artist);
            
            System.out.println("Identifier = " + identifier);
        }
    }
}