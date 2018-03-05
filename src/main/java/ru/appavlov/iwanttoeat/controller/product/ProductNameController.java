package ru.appavlov.iwanttoeat.controller.product;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.service.impl.product.ProductNameService;

@Log
@RestController
@RequestMapping(path = "/product/name")
public class ProductNameController {

    @Autowired
    private ProductNameService service;

}


