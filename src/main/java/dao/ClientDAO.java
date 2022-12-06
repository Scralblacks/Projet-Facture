package dao;

import object.Client;

import java.util.List;
import java.util.Optional;

public class ClientDAO implements CrudDAO<Client>{
    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Client update(Client element) {
        return null;
    }

    @Override
    public Client create(Client element) {
        return null;
    }
}
