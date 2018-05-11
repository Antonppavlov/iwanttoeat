package ru.appavlov.iwanttoeat.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.product.ProductName;
import ru.appavlov.iwanttoeat.repository.product.ProductNameRepository;
import ru.appavlov.iwanttoeat.service.dao.product.ProductNameDAO;

import java.util.List;

@Service
@Transactional
public class ProductNameService implements ProductNameDAO {

    @Autowired
    private ProductNameRepository repository;

    @Override
    public List<ProductName> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductName> search(String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0]);
    }

    @Override
    public ProductName get(long id) {
        return repository.findOne(id);
    }

    @Override
    public ProductName save(ProductName obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(ProductName object) {
        repository.delete(object);
    }

    @Override
    public List<ProductName> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<ProductName> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<ProductName> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }
}


