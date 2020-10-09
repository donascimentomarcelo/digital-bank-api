package br.com.digitalBank.service;

import br.com.digitalBank.domain.Client;

public interface ClientService {

    Client findByEmail(final String email);

    Client create(final Client client);

    Client findByCpf(String cpf);
}
