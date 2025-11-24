package com.Proyect.BackEnd_Parcial3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.Proyect.BackEnd_Parcial3.model.*;
import com.Proyect.BackEnd_Parcial3.repositories.*;

@RestController

public class MainController {

    @Autowired private ProductRepository productRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private RequestRepository requestRepository;
    
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
    @GetMapping("/requests")
    public ResponseEntity<List<Request>> getRequests() {
        try {
            List<Request> requests = new ArrayList<Request>();

            requestRepository.findAll().forEach(requests::add);

            if (requests.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST Request
    @PostMapping("/requests")
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        try {
            requestRepository.save(request);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT, link Product to Request
    @PutMapping("/requests/{requestId}/products/{productId}")
    public ResponseEntity<Request> addProductToRequest(@PathVariable Long requestId, @PathVariable Long productId, @RequestBody String jsonString) {
        try {
            Request request = requestRepository.findById(requestId).get();
            Product product = productRepository.findById(productId).get();

            request.getProducts().add(product);
            product.getRequests().add(request);

            // applying cuantity
            JSONObject jsonObject = new JSONObject(jsonString);
            Integer cuantity = jsonObject.getInt("cuantity");
            request.getCuantity().put(productId, cuantity);

            requestRepository.save(request);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




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
