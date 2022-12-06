package dao;

import object.Vat;

import java.util.List;
import java.util.Optional;

public class VatDAO implements CrudDAO<Vat>{
    @Override
    public List<Vat> findAll() {
        return null;
    }

    @Override
    public Optional<Vat> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Vat update(Vat element) {
        return null;
    }

    @Override
    public Vat create(Vat element) {
        return null;
    }
}
