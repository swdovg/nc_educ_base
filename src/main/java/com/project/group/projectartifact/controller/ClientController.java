package com.project.group.projectartifact.controller;

import com.project.group.projectartifact.model.Client;
import com.project.group.projectartifact.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientManagement/")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        Client client = clientService.read(id);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
