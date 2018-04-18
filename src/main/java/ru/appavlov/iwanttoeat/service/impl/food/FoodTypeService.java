package ru.appavlov.iwanttoeat.service.impl.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.food.FoodType;
import ru.appavlov.iwanttoeat.repository.food.FoodTypeRepository;
import ru.appavlov.iwanttoeat.service.dao.food.FoodTypeDAO;

import java.util.List;

@Service
@Transactional
public class FoodTypeService implements FoodTypeDAO {

    @Autowired
    private FoodTypeRepository repository;

    @Override
    public List<FoodType> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FoodType> search(String... searchString) {
        return null;
    }

    @Override
    public FoodType get(long id) {
        return repository.findOne(id);
    }

    @Override
    public FoodType save(FoodType obj) {
        return null;
    }

    @Override
    public void delete(FoodType object) {
    }

    @Override
    public List<FoodType> getAll(Sort sort) {
        return null;
    }

    @Override
    public Page<FoodType> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return null;
    }

    @Override
    public Page<FoodType> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}

