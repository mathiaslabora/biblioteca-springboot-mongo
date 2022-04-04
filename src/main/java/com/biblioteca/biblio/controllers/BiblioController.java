package com.biblioteca.biblio.controllers;

import com.biblioteca.biblio.DTO.BiblioDTO;
import com.biblioteca.biblio.models.BiblioModel;
import com.biblioteca.biblio.services.BiblioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BiblioController {
    @Autowired
    BiblioService biblioService;

    @GetMapping("/{id}")
    public ResponseEntity<BiblioDTO> findbyId(@PathVariable("id") String id) throws Throwable {
        return new ResponseEntity(biblioService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BiblioDTO>> findAll() {
        return new ResponseEntity(biblioService.getRecursos(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BiblioDTO> create(@RequestBody BiblioDTO biblioDTO) {
        return new ResponseEntity(biblioService.create(biblioDTO), HttpStatus.CREATED);
    }

    //prestar
    @PutMapping("/lend/{id}")
    public ResponseEntity<BiblioDTO> lend(@PathVariable("id") String id, @RequestBody BiblioDTO biblioDTO) {
        if (biblioDTO.getId() != null) {
            return new ResponseEntity(biblioService.lend(id), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //devolver
    @PutMapping("/giveback/{id}")
    public ResponseEntity<BiblioDTO> giveback(@PathVariable("id") String id, @RequestBody BiblioDTO biblioDTO) {
        if (biblioDTO.getId() != null) {
            return new ResponseEntity(biblioService.giveback(id), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //consulta disponibilidad:
    @GetMapping("/availability/{id}")
    public ResponseEntity<BiblioDTO> availability(@PathVariable("id") String id) throws Throwable {
        return new ResponseEntity(biblioService.availability(id), HttpStatus.OK);
    }

    //recomendar por tematica
    @GetMapping("/recommendtheme/{consulta}")
    public ResponseEntity<BiblioDTO> recommendtheme(@PathVariable("consulta") String consulta) throws Throwable {
        return new ResponseEntity(biblioService.recommendtheme(consulta), HttpStatus.OK);
    }
    //recomendar por tipo
    @GetMapping("/recommendtipe/{consulta}")
    public ResponseEntity<BiblioDTO> recommendtipe(@PathVariable("consulta") String consulta) throws Throwable {
        return new ResponseEntity(biblioService.recommendtipe(consulta), HttpStatus.OK);
    }

    //recomendar por ambos
    @GetMapping("/tipeandtheme/{tipe}/{theme}")
    public ResponseEntity<BiblioDTO> recommendtipeandtheme(@PathVariable("tipe") String tipe,@PathVariable("theme") String theme) throws Throwable {
        return new ResponseEntity(biblioService.recommendtipeandtheme(tipe,theme), HttpStatus.OK);
    }

}
