package ru.appavlov.iwanttoeat.controller.product;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.model.product.ProductType;
import ru.appavlov.iwanttoeat.service.dao.product.ProductTypeDAO;

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
}


