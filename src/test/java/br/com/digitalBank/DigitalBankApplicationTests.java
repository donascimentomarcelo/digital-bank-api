package br.com.digitalBank;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application-test.yml"})
public abstract class DigitalBankApplicationTests {

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}

}
