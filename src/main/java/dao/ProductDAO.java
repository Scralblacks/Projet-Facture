package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import object.Product;
import util.PersistantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO implements CrudDAO<Product> {
    public List<Product> findAll() {
        List<Product> listResult = new ArrayList<>();
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
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
    public Optional<Product> findById(Long id) {
        Optional<Product> result;
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            result = Optional.of(em.find(Product.class, id));
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

    public List<Product> findByName(String name) {
        List<Product> result = null;
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name = ?1", Product.class);
            result = query.setParameter(1, name).getResultList();
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.find(Product.class, id));
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
    public Product update(Product element) {
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
    public Product create(Product element) {
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(element);
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
