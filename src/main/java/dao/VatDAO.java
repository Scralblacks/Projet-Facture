package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import object.Vat;
import util.PersistantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VatDAO implements CrudDAO<Vat>{
    public List<Vat> findAll() {
        List<Vat> listResult = new ArrayList<>();
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Vat> query = em.createQuery("SELECT v FROM Vat v", Vat.class);
            listResult = query.getResultList();
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return listResult;
    }

    @Override
    public Optional<Vat> findById(Long id) {
        Optional<Vat> result;
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            result = Optional.of(em.find(Vat.class, id));
            et.commit();
            return result;
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.find(Vat.class, id));
            et.commit();
            return true;
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public Vat update(Vat element) {
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(element);
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return element;
    }

    @Override
    public Vat create(Vat element) {
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(element);
            et.commit();
        } catch (Exception e){
            e.getMessage();
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return element;
    }
}
