package ru.appavlov.iwanttoeat.service.impl.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
          return repository.findById(id).get();
    }

    @Override
    public Food getRandomFoodWhereTypeId(long typeId) {
        List<Food> byFoodType = repository.findByFoodTypeId(typeId);

        int a = 0; // Начальное значение диапазона - "от"
        int b = byFoodType.size(); // Конечное значение диапазона - "до"

        int randomNumber = a + (int) (Math.random() * b);

        return byFoodType.get(randomNumber);
    }

    @Override
    public Food getRandomFoodWhereSubTypeId(long typeId) {
        List<Food> byFoodType = repository.findByFoodSubTypeId(typeId);

        int a = 0; // Начальное значение диапазона - "от"
        int b = byFoodType.size(); // Конечное значение диапазона - "до"

        int randomNumber = a + (int) (Math.random() * b);

        return byFoodType.get(randomNumber);
    }


    @Override
    public Food save(Food obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Food object) {
        repository.delete(object);
    }

    @Override
    public List<Food> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Food> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<Food> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
