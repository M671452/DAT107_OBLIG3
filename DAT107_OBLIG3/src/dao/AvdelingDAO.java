package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import entities.Avdeling;

public class AvdelingDAO {
    private EntityManagerFactory entityManagerFactory;
    
    public AvdelingDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PU_NAME");
    }

    public Avdeling finnAvdelingMedId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Avdeling avdeling = null;
        try {
            avdeling = entityManager.find(Avdeling.class, id);
        } finally {
            entityManager.close();
        }
        return avdeling;
    }

    public List<Avdeling> hentAlleAvdelinger() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Avdeling> avdelinger = null;
        try {
            Query query = entityManager.createQuery("SELECT a FROM Avdeling a");
            avdelinger = query.getResultList();
        } finally {
            entityManager.close();
        }
        return avdelinger;
    }

    public void oppdaterAvdeling(Avdeling avdeling) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(avdeling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void leggTilAvdeling(Avdeling avdeling) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(avdeling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void slettAvdeling(int avdelingId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Avdeling avdeling = entityManager.find(Avdeling.class, avdelingId);
            if (avdeling != null) {
                entityManager.remove(avdeling);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
