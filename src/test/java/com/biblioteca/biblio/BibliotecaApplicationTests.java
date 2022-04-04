package com.biblioteca.biblio;

import com.biblioteca.biblio.models.BiblioModel;
import com.biblioteca.biblio.respositories.BiblioRepository;
import com.biblioteca.biblio.services.BiblioService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@AutoConfigureMockMvc
class BibliotecaApplicationTests {
    @Autowired
    MockMvc mockMvc;



    @Mock
    private BiblioRepository biblioRepository;

   /* @Before("")
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
    }*/

    @Before("")
    public void setupMock(){
        biblioRepository= mock(BiblioRepository.class);
    }

    @Test
    void testBiblio() {

       // when((Publisher<?>) biblioRepository.findByTipe("libro")).thenReturn("libro");

        assertEquals("libro", biblioRepository.findByTipe("libro"));

    }


}
