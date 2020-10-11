package br.com.digitalBank.serviceTest;

import br.com.digitalBank.domain.Client;
import br.com.digitalBank.repository.ClientRepository;
import br.com.digitalBank.service.ClientService;
import br.com.digitalBank.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

import java.util.Date;

@SpringBootTest
public class ClientServiceTest {

    @MockBean
    private ClientServiceImpl clientServiceImpl;

    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Mock
    private Client client;

    @BeforeEach
    public void setUp() {
        clientService = new ClientServiceImpl(clientRepository);
        client = new Client();
        client.setName("Manuel");
        client.setLastName("Silva");
        client.setEmail("manuel.silva@hotmail.com");
        client.setCnh("74059739713");
        client.setDateOfBirth(new Date());
        client.setCpf("38706316000");
    }

    @Test
    public void itShouldCreatesAClient() {
        clientService.create(client);
        verify(clientRepository).save(client);
    }

    @Test
    public void itShouldFindByEmail() {
        try {
            clientService.findByEmail(client.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void itShouldFindByCpf() {
        try {
            clientService.findByCpf(client.getCpf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
