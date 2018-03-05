package ru.appavlov.iwanttoeat.service.impl.food;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.food.FoodName;
import ru.appavlov.iwanttoeat.repository.food.FoodNameRepository;
import ru.appavlov.iwanttoeat.service.dao.food.FoodNameDAO;

import java.util.List;

@Service
@Transactional
public class FoodNameService implements FoodNameDAO {

    @Autowired
    private FoodNameRepository repository;


    @Override
    public List<FoodName> getAll() {
        return null;
    }

    @Override
    public List<FoodName> search(String... searchString) {
        return null;
    }

    @Override
    public FoodName get(long id) {
        return null;
    }

    @Override
    public FoodName save(FoodName obj) {
        return null;
    }

    @Override
    public void delete(FoodName object) {

    }

    @Override
    public List<FoodName> getAll(Sort sort) {
        return null;
    }

    @Override
    public Page<FoodName> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return null;
    }

    @Override
    public Page<FoodName> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
