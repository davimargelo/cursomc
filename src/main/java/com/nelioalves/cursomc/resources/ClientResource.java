package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Client;
import com.nelioalves.cursomc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> list() {

        Client cli1 = new Client();
        Client cli2 = new Client();

        List<Client> list = new ArrayList<>();

        list.add(cli1);
        list.add(cli2);

        return list;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Integer id) {
        Client cli = clientService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(cli);
    }
}
