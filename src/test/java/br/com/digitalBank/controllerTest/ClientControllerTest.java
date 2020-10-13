package br.com.digitalBank.controllerTest;

import br.com.digitalBank.DigitalBankApplicationTests;
import br.com.digitalBank.dto.ClientDto;
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

import java.util.Calendar;
import java.util.Date;

@Sql(value = "/ddl.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/remove-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/insert-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/remove-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.yml")
public class ClientControllerTest extends DigitalBankApplicationTests {

    @Mock
    private ClientDto dto;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        dto = new ClientDto();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -20);
        Date date = calendar.getTime();

        dto.setName("Manuel");
        dto.setLastName("Silva");
        dto.setEmail("manuel.silva-1@hotmail.com");
        dto.setCnh("74059739712");
        dto.setDateOfBirth(date);
        dto.setCpf("38706316000");
    }

    @Test
    public void itShoudSaveClient() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mvc.perform(
                MockMvcRequestBuilders
                .post("/clients")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isCreated());
    }

    @Test
    public void itShoudValidateCpf() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        dto.setCpf("teste_");
        mvc.perform(
                MockMvcRequestBuilders
                .post("/clients")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void itShoudValidateEmail() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        dto.setEmail("manuel.silva@hotmail.com");
        mvc.perform(
                MockMvcRequestBuilders
                .post("/clients")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void itShoudValidateDateOfBirth() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        dto.setDateOfBirth(new Date());
        mvc.perform(
                MockMvcRequestBuilders
                .post("/clients")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void itShoudValidateFormatEmail() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        dto.setEmail("manuel.silvahotmail.com");
        mvc.perform(
                MockMvcRequestBuilders
                .post("/clients")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isBadRequest());
    }
}
