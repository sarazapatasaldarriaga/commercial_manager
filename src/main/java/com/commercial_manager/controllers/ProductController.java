package com.commercial_manager.controllers;

import com.commercial_manager.models.entity.Product;
import com.commercial_manager.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    IProductService productService;


    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> index() {
        return productService.findAll();
    }

    @GetMapping("/show/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product show(@PathVariable Long id) {
        Product response = null;
        response = productService.findById(id);
        return response;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@Valid @RequestBody Product product) {
        Map<String, Object> response = (Map<String, Object>) productService.save(product);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@Valid @RequestBody Product product) {
        Map<String, Object> response = new HashMap<>();
        response = productService.update(product);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        String response = productService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public long productCount() {
        return productService.countProducts();
    }
}
