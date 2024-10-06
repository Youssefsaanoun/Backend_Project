package com.serviseimplementation;

import java.util.List;
import java.util.Optional;

import com.models.Client;
import com.repository.ClientRepository;
import com.servise.ClientServise;
import java.util.UUID;

public class ClientIm implements ClientServise {

private final ClientRepository clientRepository;
    public ClientIm(ClientRepository clientRepository ){
        this.clientRepository=clientRepository;
    }

    @Override
    public List<Client> getALLclient() {
        return clientRepository.findAll();
    }

    @Override
    public void DeleteClient(UUID id ) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientByID(UUID id) {
        Optional <Client> optional=clientRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        else
            return null;
    }

    @Override
    public Client AddClient(Client client) {
     return clientRepository.save(client);
    }

    @Override
    public Client UpdateClient(Client client) {
        return clientRepository.save(client);
    }


}
