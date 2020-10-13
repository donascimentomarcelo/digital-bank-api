package br.com.digitalBank.serviceTest;

import br.com.digitalBank.domain.Address;
import br.com.digitalBank.domain.Client;
import br.com.digitalBank.repository.AddressRepository;
import br.com.digitalBank.service.AddressService;
import br.com.digitalBank.service.impl.AddressServiceImpl;
import br.com.digitalBank.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class AddressServiceTest {

    @MockBean
    private AddressServiceImpl addressServiceImpl;

    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @Mock
    private Address address;

    @BeforeEach
    public void setUp() {
        addressService = new AddressServiceImpl(addressRepository);
        address = new Address();
        address.setZipcode("68906-453");
        address.setStreet("rua a");
        address.setNeighborhood("bras de pina");
        address.setComplement("teste");
        address.setCity("rio de janeiro");
        address.setState("rio de janeiro");
        address.setClient(new Client(200L));
    }

    @Test
    public void itShouldCreatesAnAddress() {
        addressService.create(address);
        verify(addressRepository).save(address);
    }

}
