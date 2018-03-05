package ru.appavlov.iwanttoeat.controller.product;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.service.impl.product.ProductTypeService;

@Log
@RestController
@RequestMapping(path = "/product/type")
public class ProductTypeController {

    @Autowired
    private ProductTypeService service;

}


