package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Client;
import com.nelioalves.cursomc.respositories.ClientRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repo;

    public Client findOne(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("404 - Not Found ID: " + id, new Throwable("Type: " + Client.class.getName())));
    }

}
