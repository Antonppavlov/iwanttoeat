package ru.appavlov.iwanttoeat.service.impl.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.product.ProductData;
import ru.appavlov.iwanttoeat.repository.product.ProductDataRepository;
import ru.appavlov.iwanttoeat.service.dao.product.ProductDataDAO;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductDataService implements ProductDataDAO {

    @Autowired
    private ProductDataRepository repository;

    @Override
    public List<ProductData> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductData> search(String... searchString) {
        return null;
    }

    @Override
    public ProductData get(long id) {
        return repository.findById(id).get();
    }

    @Override
    public ProductData save(ProductData obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(ProductData object) {
        repository.delete(object);
    }

    @Override
    public List<ProductData> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<ProductData> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<ProductData> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
