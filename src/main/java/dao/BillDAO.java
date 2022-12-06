package dao;

import object.Bill;

import java.util.List;
import java.util.Optional;

public class BillDAO implements CrudDAO<Bill>{
    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Bill update(Bill element) {
        return null;
    }

    @Override
    public Bill create(Bill element) {
        return null;
    }
}
