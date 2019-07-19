package org.kodejava.example.jpa;

import org.kodejava.example.model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

public class ArtistDao {
    private EntityManager manager;

    public ArtistDao(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * Find Artist based on the entity Id.
     *
     * @param artistId the artist Id.
     * @return Artist.
     * @throws EntityNotFoundException when no artist is found.
     */
    public Artist findById(Long artistId) {
        Artist artist = manager.find(Artist.class, artistId);
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + artistId);
        }
        return artist;
    }

    /**
     * Create a new artist record in the database.
     *
     * @param artist Artist to be created.
     * @return the ID of saved Artist.
     */
    public void createArtist(Artist artist) {
        manager.getTransaction().begin();
        manager.persist(artist);
        manager.getTransaction().commit();
    }

    /**
     * Get Artists from database.
     *
     * @return a list of artist.
     */
    @SuppressWarnings("unchecked")
    public List getArtists() {
        Query query = manager.createQuery("select a from Artist a");
        return query.getResultList();
    }

    /**
     * Update Artist information.
     *
     * @param artist an Artist to be updated.
     */
    public void updateArtist(Artist artist) {
        manager.getTransaction().begin();
        manager.merge(artist);
        manager.getTransaction().commit();
    }

    /**
     * Delete artist by their Id.
     *
     * @param artistId the artist Id.
     */
    public void deleteArtistById(Long artistId) {
        Artist artist = manager.find(Artist.class, artistId);
        if (artist != null) {
            manager.getTransaction().begin();
            manager.remove(artist);
            manager.getTransaction().commit();
        }
    }

    /**
     * Delete artist entity.
     *
     * @param artist the object to be deleted.
     */
    public void deleteArtist(Artist artist) {
        manager.getTransaction().begin();
        manager.remove(artist);
        manager.getTransaction().commit();
    }
}


package org.kodejava.example.jpa;

import org.kodejava.example.model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EntityRemoveDemo {
    public static final String PERSISTENCE_UNIT_NAME = "music";

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();

        ArtistDao dao = new ArtistDao(manager);
        System.out.println("Before Delete:");
        printArtists(dao.getArtists());

        //
        // Remove artist with Id = 1.
        //
        dao.deleteArtistById(1L);

        //
        // Remove artist with Id = 2.
        //
        Artist artist = dao.findById(2L);
        dao.deleteArtist(artist);

        System.out.println("After Delete:");
        printArtists(dao.getArtists());
    }

    private static void printArtists(List artists) {
        for (Artist artist : artists) {
            System.out.println("Artist = " + artist);
        }
    }
}