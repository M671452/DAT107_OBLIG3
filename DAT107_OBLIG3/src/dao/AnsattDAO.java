package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import entities.Ansatt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AnsattDAO {
    private EntityManagerFactory entityManagerFactory;
    
    public AnsattDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PU_NAME");
    }

    public Ansatt finnAnsattMedId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Ansatt ansatt = null;
        try {
            ansatt = entityManager.find(Ansatt.class, id);
        } finally {
            entityManager.close();
        }
        return ansatt;
    }

    public List<Ansatt> finnAnsattMedBrukernavn(String brukernavn) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Ansatt> ansatte = null;
        try {
            Query query = entityManager.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn");
            query.setParameter("brukernavn", brukernavn);
            ansatte = query.getResultList();
        } finally {
            entityManager.close();
        }
        return ansatte;
    }

    public List<Ansatt> hentAlleAnsatte() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Ansatt> ansatte = null;
        try {
            Query query = entityManager.createQuery("SELECT a FROM Ansatt a");
            ansatte = query.getResultList();
        } finally {
            entityManager.close();
        }
        return ansatte;
    }

    public void oppdaterStillingOgLonn(int ansattId, String stilling, BigDecimal lonn) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Ansatt ansatt = entityManager.find(Ansatt.class, ansattId);
            if (ansatt != null) {
                ansatt.setStilling(stilling);
                ansatt.setMaanedslonn(lonn);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void leggTilAnsatt(Ansatt ansatt) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ansatt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void oppdaterAnsatt(Ansatt ansatt) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(ansatt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void slettAnsatt(int ansattId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Ansatt ansatt = entityManager.find(Ansatt.class, ansattId);
            if (ansatt != null) {
                entityManager.remove(ansatt);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
