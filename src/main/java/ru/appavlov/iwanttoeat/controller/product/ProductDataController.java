package ru.appavlov.iwanttoeat.controller.product;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.product.ProductData;
import ru.appavlov.iwanttoeat.service.dao.product.ProductDataDAO;

@Log
@RestController
@RequestMapping(path = "/product/data")
public class ProductDataController {

    @Autowired
    private ProductDataDAO service;

    @GetMapping
    public ProductData get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody ProductData productData) {
        service.save(productData);
        return true;
    }
}
