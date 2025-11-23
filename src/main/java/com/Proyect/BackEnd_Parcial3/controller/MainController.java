package com.Proyect.BackEnd_Parcial3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.Proyect.BackEnd_Parcial3.model.*;
import com.Proyect.BackEnd_Parcial3.repositories.*;

@RestController

public class MainController {

    @Autowired private ProductRepository productRepository;
    @Autowired private EmployeeRepository employeeRepository;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // GET Products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> products = new ArrayList<Product>();

            productRepository.findAll().forEach(products::add);

            if (products.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST Product
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            productRepository.save(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // GET Requests

    // POST Request


    // GET Employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            List<Employee> employees = new ArrayList<Employee>();

            employeeRepository.findAll().forEach(employees::add);

            if (employees.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
