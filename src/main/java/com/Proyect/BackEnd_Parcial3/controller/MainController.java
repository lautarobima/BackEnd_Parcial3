package com.Proyect.BackEnd_Parcial3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // GET Products

    // POST Product


    // GET Requests

    // POST Request


    // GET Employees

    // POST Employee
    
}
