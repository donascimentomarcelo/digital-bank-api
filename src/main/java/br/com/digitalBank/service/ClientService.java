package br.com.digitalBank.service;

import br.com.digitalBank.domain.Client;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

public interface ClientService {

    Client findByEmail(final String email);

    Client create(final Client client);

    Client findByCpf(String cpf);

    URI uploadPicture(final MultipartFile multipartFile);
}
