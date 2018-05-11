package ru.appavlov.iwanttoeat.service.impl.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.food.FoodProducts;
import ru.appavlov.iwanttoeat.repository.food.FoodProductsRepository;
import ru.appavlov.iwanttoeat.service.dao.food.FoodProductsDAO;

import java.util.List;

@Service
@Transactional
public class FoodProductsService implements FoodProductsDAO {

    private final FoodProductsRepository repository;

    @Autowired
    public FoodProductsService(FoodProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FoodProducts> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FoodProducts> search(String... searchString) {
        return null;
    }

    @Override
    public FoodProducts get(long id) {
        return repository.findOne(id);
    }

    @Override
    public FoodProducts save(FoodProducts obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(FoodProducts object) {
        repository.delete(object);
    }

    @Override
    public List<FoodProducts> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<FoodProducts> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<FoodProducts> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}


