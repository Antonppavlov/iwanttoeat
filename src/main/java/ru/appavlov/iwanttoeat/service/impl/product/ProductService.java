package ru.appavlov.iwanttoeat.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.product.Product;
import ru.appavlov.iwanttoeat.repository.product.ProductRepository;
import ru.appavlov.iwanttoeat.service.dao.product.ProductDAO;

import java.util.List;

@Service
@Transactional
public class ProductService implements ProductDAO {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> search(String... searchString) {
        return null;
    }

    @Override
    public Product get(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public List<Product> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Product> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<Product> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}


