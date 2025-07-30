package com.commercial_manager.controllers;

import com.commercial_manager.models.entity.Supplier;
import com.commercial_manager.models.repository.ISupplierRepository;
import com.commercial_manager.service.ISupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SupplierController {
    @Autowired
    private ISupplierRepository SupplierService;
    @Autowired
    ISupplierService SupplierUC;

    @GetMapping("/list")
    public List<Supplier> index() {
        return SupplierService.findAll();
    }

    @GetMapping("/show/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Supplier show(@PathVariable Long id) {
        Supplier response = null;
        response = SupplierUC.findById(id);
        return response;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@Valid @RequestBody Supplier proveedor) {

        Map<String, Object> response = (Map<String, Object>) SupplierUC.save(proveedor);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@Valid @RequestBody Supplier proveedor) {
        Map<String, Object> response = new HashMap<>();
        response = SupplierUC.update(proveedor);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        SupplierService.delete(id);
    }

}
