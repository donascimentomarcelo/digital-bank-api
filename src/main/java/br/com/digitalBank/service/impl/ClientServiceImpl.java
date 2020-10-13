package br.com.digitalBank.service.impl;

import br.com.digitalBank.domain.Client;
import br.com.digitalBank.repository.ClientRepository;
import br.com.digitalBank.service.ClientService;
import br.com.digitalBank.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private S3Service s3Service;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

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

    @Override
    public URI uploadPicture(MultipartFile multipartFile) {
        return s3Service.uploadFile(multipartFile);
    }


}
