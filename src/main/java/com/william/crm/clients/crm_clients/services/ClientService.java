package com.william.crm.clients.crm_clients.services;

import java.util.List;
import java.util.Optional;

import com.william.crm.clients.crm_clients.entities.Client;

public interface ClientService {
    List<Client> findAllClients();
    Optional<Client> createClient(Client client);
    void deleteClient(String id);
    Optional<Client> updateClient(String id, Client client);
    Optional<Client> findClientById(String id);
    Optional<Client> findClientByEmail(String email);
}
