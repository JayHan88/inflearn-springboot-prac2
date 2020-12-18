package me.jay.demo.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerRestTemplateTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	@MockBean
	SampleService mockSampleService;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("jay");

		String result = testRestTemplate.getForObject("/hello", String.class);
		assertThat(result).isEqualTo("hello jay");
	}

}