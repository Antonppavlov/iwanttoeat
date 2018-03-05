package ru.appavlov.iwanttoeat.service.impl.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private FoodProductsRepository repository;

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
        return null;
    }

    @Override
    public FoodProducts save(FoodProducts obj) {
        return null;
    }

    @Override
    public void delete(FoodProducts object) {
    }

    @Override
    public List<FoodProducts> getAll(Sort sort) {
        return null;
    }

    @Override
    public Page<FoodProducts> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return null;
    }

    @Override
    public Page<FoodProducts> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}


