package ru.perm.v.springconfig;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TestRestTemplate for integration tests https://www.baeldung.com/spring-boot-testresttemplate
 * with Spring Boot STARTED and testing.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeanConfigurationRestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void forRussianURL() {
        String body = restTemplate.getForObject("http://127.0.0.1:" + port + "/api/greet/russian", String.class);
        assertEquals("Привет, vasi", body);
    }
    @Test
    void forEnglishURL() {
        String body = restTemplate.getForObject("http://127.0.0.1:" + port + "/api/greet/english", String.class);
        assertEquals("Hello, vasi", body);
    }

    @Test
    void forGermanyURL() {
        String body = restTemplate.getForObject("http://127.0.0.1:" + port + "/api/greet/germany", String.class);
        assertEquals("Guten Tag, vasi", body);
    }

    @Test
    void forSelectedLanguageURL() {
        String body = restTemplate.getForObject("http://127.0.0.1:" + port + "/api/greet/selected", String.class);
        assertEquals("Привет, vasi", body);
    }
}
