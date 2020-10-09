package br.com.digitalBank.service.impl;

import br.com.digitalBank.domain.Client;
import br.com.digitalBank.repository.ClientRepository;
import br.com.digitalBank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByEmail(final String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client create(final Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}
