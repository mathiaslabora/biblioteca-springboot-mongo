package com.biblioteca.biblio;

import com.biblioteca.biblio.models.BiblioModel;
import com.biblioteca.biblio.respositories.BiblioRepository;
import com.biblioteca.biblio.services.BiblioService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
class BibliotecaApplicationTests {




    @MockBean
    private BiblioRepository biblioRepository;

   @Autowired
   private BiblioService biblioService;


    @Test
    @DisplayName("Test 1")
    public void testBiblio() {
        var datos=new BiblioModel();
        datos.setId("12345");
        datos.setName("Diario1");
        datos.setTipe("Diario");
        var datos2=new BiblioModel();
        datos.setId("2345");
        datos.setName("revista2");
        datos.setTipe("revista");

        var lista = new ArrayList<BiblioModel>();
        lista.add(datos);
        lista.add(datos2);
        Mockito.when(biblioRepository.findAll()).thenReturn(lista);

        var resultado = biblioService.getRecursos();

        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(datos.getTipe(), resultado.get(0).getTipe());
        Assertions.assertEquals(datos2.getId(), resultado.get(1).getId());
    }


}
