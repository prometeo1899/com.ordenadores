package com.example.com.ordenadores.controllers;








import com.example.com.ordenadores.entities.Laptop;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;


import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("htte://localhost" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }


    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/prueba", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

  @Test
  void create() {
       HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    String json = """
           {
                     
               "name": "canaima",
                 "color": "negro",
                 "price": 210
                   
                 
         }
           """;

 HttpHeaders<String> request =new HttpEntity<>(json,headers);

      ResponseEntity<Laptop> response= testRestTemplate.exchange
              ("/api/prueba", HttpMethod.POST,request,Laptop.class);

      Laptop result=response.getBody();
      essertEquals(1L, result.getId);
      eseertEquals("canaima", result.getTitle);

  }
}