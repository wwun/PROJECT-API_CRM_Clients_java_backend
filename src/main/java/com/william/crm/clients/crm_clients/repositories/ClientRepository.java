package com.william.crm.clients.crm_clients.repositories;

import org.springframework.data.repository.CrudRepository;

import com.william.crm.clients.crm_clients.entities.Client;


public interface ClientRepository extends CrudRepository<Client, String>{
    Client findByEmail(String email);
    
}
