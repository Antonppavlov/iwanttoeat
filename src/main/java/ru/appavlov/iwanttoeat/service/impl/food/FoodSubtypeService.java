package ru.appavlov.iwanttoeat.service.impl.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.food.FoodSubtype;
import ru.appavlov.iwanttoeat.repository.food.FoodSubtypeRepository;
import ru.appavlov.iwanttoeat.service.dao.food.FoodSubtypeDAO;

import java.util.List;

@Service
@Transactional
public class FoodSubtypeService implements FoodSubtypeDAO {

    @Autowired
    private FoodSubtypeRepository repository;

    @Override
    public List<FoodSubtype> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FoodSubtype> search(String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0]);
    }

    @Override
    public FoodSubtype get(long id) {
        return repository.findById(id).get();
    }

    @Override
    public FoodSubtype save(FoodSubtype obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(FoodSubtype object) {
        repository.delete(object);
    }

    @Override
    public List<FoodSubtype> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<FoodSubtype> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<FoodSubtype> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return repository.findByNameRuContainingIgnoreCaseOrderByNameRu(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }
}

