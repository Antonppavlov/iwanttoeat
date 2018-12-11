package ru.appavlov.iwanttoeat.service.impl.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.appavlov.iwanttoeat.model.food.FoodRecipe;
import ru.appavlov.iwanttoeat.repository.food.FoodRecipeRepository;
import ru.appavlov.iwanttoeat.service.dao.food.FoodRecipeDAO;

import java.util.List;

@Service
@Transactional
public class FoodRecipeService implements FoodRecipeDAO {

    @Autowired
    private FoodRecipeRepository repository;

    @Override
    public List<FoodRecipe> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FoodRecipe> search(String... searchString) {
        return repository.findByDescriptionRuContainingIgnoreCaseOrderByDescriptionRu(searchString[0]);
    }

    @Override
    public FoodRecipe get(long id) {
        return repository.findById(id).get();
    }

    @Override
    public FoodRecipe save(FoodRecipe obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(FoodRecipe object) {
        repository.delete(object);
    }

    @Override
    public List<FoodRecipe> getAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<FoodRecipe> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return repository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<FoodRecipe> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return repository.findByDescriptionRuContainingIgnoreCaseOrderByDescriptionRu(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }
}

