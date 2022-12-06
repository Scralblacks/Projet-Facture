package dao;

import object.Products;

import java.util.List;
import java.util.Optional;

public class ProductsDAO implements CrudDAO<Products> {
    @Override
    public List<Products> findAll() {
        return null;
    }

    @Override
    public Optional<Products> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Products update(Products element) {
        return null;
    }

    @Override
    public Products create(Products element) {
        return null;
    }
}
