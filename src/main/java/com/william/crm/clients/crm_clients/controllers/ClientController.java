package com.william.crm.clients.crm_clients.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.crm.clients.crm_clients.entities.Client;
import com.william.crm.clients.crm_clients.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
//@CrossOrigin(origins = "http://127.0.0.1:5501")   //esta es una de las 3 maneras para configurar CORS
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> findAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllClients());
    }

    @PostMapping
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client, BindingResult result){
        if(result.hasFieldErrors()){
            ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.createClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id){
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateClient(@PathVariable String id, @Valid @RequestBody Client client, BindingResult result){
        if(result.hasFieldErrors()){
            ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findClientById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findClientById(id));
    }

}
