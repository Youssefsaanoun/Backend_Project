package com.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.models.Client;
import java.util.UUID;

@Service
public interface ClientServise {
    public List<Client> getALLclient();
    public void DeleteClient(UUID id);
    public Client getClientByID(UUID id );
    public Client AddClient(Client client);
    public Client UpdateClient(Client client);

    
} 


