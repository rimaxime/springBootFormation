package com.mriviere.rest;


import com.mriviere.jpa.repository.ClientRepository;
import com.mriviere.model.Client;
import com.mriviere.model.Product;
import com.mriviere.model.ProductDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsRessource {

    private ClientRepository clientRepository;

    public ClientsRessource(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id") Long id) {
        return clientRepository.getOne(id);
    }

    @PutMapping
    public void putClient(@RequestBody Client client) {
        clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientRepository.delete(id);
    }

}
