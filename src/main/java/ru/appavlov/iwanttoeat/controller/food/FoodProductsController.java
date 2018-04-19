package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.food.FoodProducts;
import ru.appavlov.iwanttoeat.service.dao.food.FoodProductsDAO;

@Log
@RestController
@RequestMapping(path = "/food/products")
public class FoodProductsController {

    @Autowired
    private FoodProductsDAO service;

    @GetMapping
    public FoodProducts get(@RequestParam("id") long id) {
        return service.get(id);
    }


    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody FoodProducts foodProducts) {
        service.save(foodProducts);
        return true;
    }
}



