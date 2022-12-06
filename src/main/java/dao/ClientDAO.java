package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import object.Client;
import util.PersistantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAO implements CrudDAO<Client>{
    public List<Client> findAll() {
        List<Client> listResult = new ArrayList<>();
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
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
    public Optional<Client> findById(Long id) {
        Optional<Client> result;
        EntityManagerFactory emf = PersistantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            result = Optional.of(em.find(Client.class, id));
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
            em.remove(em.find(Client.class, id));
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
    public Client update(Client element) {
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
    public Client create(Client element) {
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
