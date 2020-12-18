package me.jay.demo.sample;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureWebTestClient
public class SampleControllerWebTestClientTest {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	SampleService mockSampleService;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("jay");

		webTestClient.get().uri("/hello").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("hello jay");
	}

}