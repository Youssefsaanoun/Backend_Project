package com.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviseimplementation.ClientIm;
import com.serviseimplementation.ProductIm;
import com.models.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientIm clientIm;  

    public ClientController(ClientIm clientIm, ProductIm productIm) {
        this.clientIm = clientIm;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientIm.AddClient(client);
        return ResponseEntity.ok(newClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientIm.getALLclient();
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable UUID id, @RequestBody Client client) {
        client.setId(id);
        Client updatedClient = clientIm.UpdateClient(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientIm.DeleteClient(id);
        return ResponseEntity.noContent().build();
    }

  
    @GetMapping("/{id}")
    public  ResponseEntity <Client> getClientByID(@PathVariable UUID id ){
        Client Cliente=clientIm.getClientByID(id);
        if (Cliente==null) {
            return ResponseEntity.noContent().build();}
        else
            return ResponseEntity.ok(Cliente);
            
        }


}
