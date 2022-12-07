package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import object.BillProduct;
import util.PersistantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillProductDAO implements CrudDAO<BillProduct>{
    public List<BillProduct> findAll() {
        List<BillProduct> listResult = new ArrayList<>();
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<BillProduct> query = em.createQuery("SELECT bp FROM BillProduct bp", BillProduct.class);
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
    public Optional<BillProduct> findById(Long id) {
        Optional<BillProduct> result;
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            result = Optional.of(em.find(BillProduct.class, id));
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
            em.remove(em.find(BillProduct.class, id));
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
    public BillProduct update(BillProduct element) {
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
    public BillProduct create(BillProduct element) {
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
