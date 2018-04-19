package ru.appavlov.iwanttoeat.controller.product;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.product.ProductType;
import ru.appavlov.iwanttoeat.service.dao.product.ProductTypeDAO;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/product/type")
public class ProductTypeController {

    @Autowired
    private ProductTypeDAO service;

    @GetMapping
    public ProductType get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @GetMapping(value = "/search")
    public List<ProductType> search(@RequestParam("nameRu") String nameRu) {
        return service.search(nameRu);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody ProductType productType) {
        service.save(productType);
        return true;
    }
}


