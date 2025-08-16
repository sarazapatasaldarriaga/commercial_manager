package com.commercial_manager.controllers;

import com.commercial_manager.models.entity.Client;
import com.commercial_manager.service.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://commercial-manager-front-prod-s3.s3-website.us-east-2.amazonaws.com")
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public List<Client> index() {
        return clientService.findAll();
    }

    @GetMapping("/show/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client show(@PathVariable Long id) {
        Client response = null;
        response = clientService.findById(id);
        return response;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@Valid @RequestBody Client client) {
        Map<String, Object> response = (Map<String, Object>) clientService.save(client);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@Valid @RequestBody Client client) {
        Map<String, Object> response = new HashMap<>();
        response = clientService.update(client);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        String response = clientService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public long clientCount() {
        return clientService.countClients();
    }
}
