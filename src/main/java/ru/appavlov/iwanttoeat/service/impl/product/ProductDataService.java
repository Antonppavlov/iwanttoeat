package ru.appavlov.iwanttoeat.service.impl.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.product.ProductData;
import ru.appavlov.iwanttoeat.repository.product.ProductDataRepository;
import ru.appavlov.iwanttoeat.service.dao.product.ProductDataDAO;

import java.util.List;

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
        return null;
    }

    @Override
    public ProductData save(ProductData obj) {
        return null;
    }

    @Override
    public void delete(ProductData object) {
    }

    @Override
    public List<ProductData> getAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductData> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return null;
    }

    @Override
    public Page<ProductData> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
