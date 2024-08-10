package com.william.crm.clients.crm_clients.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.william.crm.clients.crm_clients.entities.Client;
import com.william.crm.clients.crm_clients.repositories.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Client> findAllClients(){
        return (List<Client>)clientRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Client> createClient(Client client){
        if(!findClientByEmail(client.getEmail()).isPresent()){  //!findClientById(client.getId()).isPresent() || 
            client.setId(Long.toString(System.currentTimeMillis()).substring(0, 10));
            return Optional.of(clientRepository.save(client));
        }
        return Optional.ofNullable(null);
    }

    @Override
    @Transactional
    public void deleteClient(String id){
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Client> updateClient(String id, Client client){
        Optional<Client> clientOptional = findClientById(id);
        if(clientOptional.isPresent()){
            return Optional.of(clientRepository.save(client));
        }
        return Optional.ofNullable(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findClientById(String id){
        return clientRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findClientByEmail(String email){
        Client client = clientRepository.findByEmail(email);
        return client!=null ? Optional.of(client) : Optional.empty();
    }
}
