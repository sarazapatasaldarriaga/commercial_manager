package com.commercial_manager.controllers;

import com.commercial_manager.models.entity.Supplier;
import com.commercial_manager.service.ISupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    ISupplierService supplierService;

    @GetMapping("/list")
    public List<Supplier> index() {
        return supplierService.findAll();
    }

    @GetMapping("/show/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Supplier show(@PathVariable Long id) {
        Supplier response = null;
        response = supplierService.findById(id);
        return response;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@Valid @RequestBody Supplier supplier) {

        Map<String, Object> response = (Map<String, Object>) supplierService.save(supplier);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@Valid @RequestBody Supplier supplier) {
        Map<String, Object> response = new HashMap<>();
        response = supplierService.update(supplier);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        String response = supplierService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public long supplierCount() {
        return supplierService.countSupplier();
    }
}
