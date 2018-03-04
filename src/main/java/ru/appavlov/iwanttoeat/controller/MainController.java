package ru.appavlov.iwanttoeat.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect() {
        return "Hello friend, do you want to eat?";
    }
}


