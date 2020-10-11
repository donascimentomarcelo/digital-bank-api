package br.com.digitalBank.controller;

import br.com.digitalBank.domain.Address;
import br.com.digitalBank.dto.AddressDto;
import br.com.digitalBank.service.AddressService;
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
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<?> createAddress(@Valid @RequestBody final AddressDto addressDto) {
        Address address = addressService.create(addressDto.fromEntity());

        URI uri = Util.getUri(address.getId());
        return ResponseEntity.created(uri).build();
    }
}
