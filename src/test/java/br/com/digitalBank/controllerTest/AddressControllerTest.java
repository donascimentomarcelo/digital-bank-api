package br.com.digitalBank.controllerTest;

import br.com.digitalBank.DigitalBankApplicationTests;
import br.com.digitalBank.dto.AddressDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/ddl.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/remove-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/insert-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/remove-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.yml")
public class AddressControllerTest extends DigitalBankApplicationTests {

    @Mock
    private AddressDto dto;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        dto = new AddressDto();
        dto.setZipcode("68906-453");
        dto.setStreet("rua a");
        dto.setNeighborhood("bras de pina");
        dto.setComplement("teste");
        dto.setCity("rio de janeiro");
        dto.setState("rio de janeiro");
        dto.setClientId(200L);
    }

    @Test
    public void itShoudSaveAddress() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mvc.perform(
                MockMvcRequestBuilders
                .post("/address")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isCreated());
    }

    @Test
    public void itShoudValidateZipcode() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        dto.setZipcode("626226262");
        mvc.perform(
                MockMvcRequestBuilders
                .post("/address")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isBadRequest());
    }
}
