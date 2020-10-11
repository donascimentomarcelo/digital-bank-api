package br.com.digitalBank.service.impl;

import br.com.digitalBank.domain.Address;
import br.com.digitalBank.repository.AddressRepository;
import br.com.digitalBank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }
}
