package ru.appavlov.iwanttoeat.service.impl.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.repository.food.FoodRepository;
import ru.appavlov.iwanttoeat.service.dao.food.FoodDAO;

import java.util.List;

@Service
@Transactional
public class FoodService implements FoodDAO {

    @Autowired
    private FoodRepository repository;

    @Override
    public List<Food> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Food> search(String... searchString) {
        return null;
    }

    @Override
    public Food get(long id) {
        return null;
    }

    @Override
    public Food save(Food obj) {
        return null;
    }

    @Override
    public void delete(Food object) {

    }

    @Override
    public List<Food> getAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Food> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return null;
    }

    @Override
    public Page<Food> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
