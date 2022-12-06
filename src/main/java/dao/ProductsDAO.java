package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import object.Products;
import util.PersistantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsDAO implements CrudDAO<Products> {
    public List<Products> findAll() {
        List<Products> listResult = new ArrayList<>();
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Products> query = em.createQuery("SELECT p FROM Products p", Products.class);
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
    public Optional<Products> findById(Long id) {
        Optional<Products> result;
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            result = Optional.of(em.find(Products.class, id));
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
            em.remove(em.find(Products.class, id));
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
    public Products update(Products element) {
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
    public Products create(Products element) {
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
