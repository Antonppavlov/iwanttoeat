package ru.appavlov.iwanttoeat.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.product.ProductType;
import ru.appavlov.iwanttoeat.repository.product.ProductTypeRepository;
import ru.appavlov.iwanttoeat.service.dao.product.ProductTypeDAO;

import java.util.List;

@Service
@Transactional
public class ProductTypeService implements ProductTypeDAO {

    @Autowired
    private ProductTypeRepository repository;

    @Override
    public List<ProductType> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductType> search(String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0]);
    }

    @Override
    public ProductType get(long id) {
        return repository.findById(id).get();
    }

    @Override
    public ProductType save(ProductType obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(ProductType object) {
        repository.delete(object);
    }

    @Override
    public List<ProductType> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<ProductType> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<ProductType> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }
}


