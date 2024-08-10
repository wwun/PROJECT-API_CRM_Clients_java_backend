package com.william.crm.clients.crm_clients.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.william.crm.clients.crm_clients.entities.Client;
import java.util.List;


public interface ClientRepository extends CrudRepository<Client, String>{
    Client findByEmail(String email);
    
}
