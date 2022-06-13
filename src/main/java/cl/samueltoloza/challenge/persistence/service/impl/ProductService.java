package cl.samueltoloza.challenge.persistence.service.impl;

import cl.samueltoloza.challenge.persistence.dao.IProductDAO;
import cl.samueltoloza.challenge.persistence.model.Product;
import cl.samueltoloza.challenge.persistence.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO dao;


    @Override
    public Optional<Product> findBySku(String sku) {
        return dao.findById(sku);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) dao.findAll();
    }

    @Override
    public Page<Product> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);

    }

    @Override
    public Product create(Product entity) {
        return dao.save(entity);
    }

    @Override
    public Product update(Product entity) {
        return dao.save(entity);
    }

    @Override
    public void delete(Product entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteBySku(String sku) {
        dao.deleteById(sku);
    }
}
