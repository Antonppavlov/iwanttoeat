package ru.appavlov.iwanttoeat.controller.product;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.product.Product;
import ru.appavlov.iwanttoeat.service.dao.product.ProductDAO;

@Log
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductDAO service;


    @GetMapping
    public Product get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));// сначала получаем автора по id, потом его удаляем
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody Product product) {
        service.save(product);
        return true;
    }
}


