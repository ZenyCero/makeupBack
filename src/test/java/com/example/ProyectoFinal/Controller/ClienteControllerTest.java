package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+ port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Cliente[]> response = testRestTemplate.getForEntity("/api/clientes", Cliente[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        List<Cliente> laptops =  Arrays.asList(response.getBody());
        System.out.println(laptops.size());
        System.out.println("FindAll: "+laptops);
    }

    @Test
    void findOneById() {
        ResponseEntity<Cliente> response = testRestTemplate.getForEntity("/api/cliente/1", Cliente.class);
        Cliente result = response.getBody();
        System.out.println("FindById: "+result);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                             "fk_distrito": {
                                 "id_distrito": 1,
                                 "nombre": "Villa Maria del Triunfo"
                             },
                             "email": "elias@hotmail.com",
                             "pass": "123456",
                             "full_name": "Elias Tagle",
                             "direccion": "Psj lima",
                             "telefono": 99999999
                         }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Cliente> response = testRestTemplate.exchange("/api/cliente",HttpMethod.POST,request, Cliente.class);

        Cliente result =  response.getBody();
        System.out.println("Create: "+result);
        assertEquals(10L,result.getId_cliente());
        assertEquals("Psj lima",result.getDireccion());
    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                            "id_cliente": 1,
                             "fk_distrito": {
                                 "id_distrito": 1,
                                 "nombre": "Villa Maria del Triunfo"
                             },
                             "email": "elias@hotmail.com",
                             "pass": "123456",
                             "full_name": "Elias Tagle",
                             "direccion": "Psj lima",
                             "telefono": 99999999
                         }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Cliente> response = testRestTemplate.exchange("/api/cliente",HttpMethod.PUT,request, Cliente.class);

        Cliente result =  response.getBody();
        System.out.println("Update: "+result);
        assertEquals(1L,result.getId_cliente());
        assertEquals("elias@hotmail.com",result.getEmail());
    }

    @Test
    void delete() {
        ResponseEntity<Cliente> response = testRestTemplate.getForEntity("/api/cliente/1",Cliente.class);
        Cliente result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
    }

    /*@Test
    void deleteAll() {

    }*/
}