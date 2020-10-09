package br.com.digitalBank.controller;

import br.com.digitalBank.domain.Client;
import br.com.digitalBank.dto.ClientDto;
import br.com.digitalBank.service.ClientService;
import br.com.digitalBank.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody final ClientDto clientDto) {
        Client client = clientService.create(clientDto.fromEntity());

        URI uri = Util.getUri(client.getId());
        return ResponseEntity.created(uri).build();
    }


}
