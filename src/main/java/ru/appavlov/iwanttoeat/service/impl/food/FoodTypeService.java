package ru.appavlov.iwanttoeat.service.impl.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0]);
    }

    @Override
    public FoodType get(long id) {
        return repository.findById(id).get();
    }

    @Override
    public FoodType save(FoodType obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(FoodType object) {
        repository.delete(object);
    }

    @Override
    public List<FoodType> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<FoodType> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<FoodType> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }
}

