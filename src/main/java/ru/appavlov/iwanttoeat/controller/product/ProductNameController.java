package ru.appavlov.iwanttoeat.controller.product;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.product.ProductName;
import ru.appavlov.iwanttoeat.service.dao.product.ProductNameDAO;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/product/name")
public class ProductNameController {

    @Autowired
    private ProductNameDAO service;

    @GetMapping
    public ProductName get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @GetMapping(value = "/search")
    public List<ProductName> search(@RequestParam("nameRu") String nameRu) {
        return service.search(nameRu);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody ProductName productName) {
        service.save(productName);
        return true;
    }
}


