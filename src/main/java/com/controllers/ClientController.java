package com.controllers;

import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientIm clientIm;  
    private final ProductIm productIm;  

    public ClientController(ClientIm clientIm, ProductIm productIm) {
        this.clientIm = clientIm;
        this.productIm = productIm;
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

    // Ajouter un produit à un client (Many-to-Many)
    @PostMapping("/{clientId}/addProduct/{productId}")
    public ResponseEntity<Client> addProductToClient(@PathVariable UUID clientId, @PathVariable UUID productId) {
        Client client = clientIm.getClientByID(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        product product = productIm.getproductByID(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        client.getProducts().add(product); 
        Client updatedClient = clientIm.UpdateClient(client);

        return ResponseEntity.ok(updatedClient);
    }
}
