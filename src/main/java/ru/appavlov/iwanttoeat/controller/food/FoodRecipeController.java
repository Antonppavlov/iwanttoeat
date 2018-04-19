package ru.appavlov.iwanttoeat.controller.food;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.food.FoodRecipe;
import ru.appavlov.iwanttoeat.service.dao.food.FoodRecipeDAO;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/food/recipe")
public class FoodRecipeController {

    @Autowired
    private FoodRecipeDAO service;

    @GetMapping
    public FoodRecipe get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @GetMapping(value = "/search")
    public List<FoodRecipe> search(@RequestParam("descriptionRu") String descriptionRu) {
        return service.search(descriptionRu);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody FoodRecipe foodRecipe) {
        service.save(foodRecipe);
        return true;
    }
}

