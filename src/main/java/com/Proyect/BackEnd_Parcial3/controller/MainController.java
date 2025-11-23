package com.Proyect.BackEnd_Parcial3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyect.BackEnd_Parcial3.repositories.EmployeeRepository;

@RestController

public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // GET Products

    // POST Product


    // GET Requests

    // POST Request


    // GET Employees
    @GetMapping("/employees")
    public String getEmployees() {
        return employeeRepository.findAll().toString();
    }

    // POST Employee
    
}
