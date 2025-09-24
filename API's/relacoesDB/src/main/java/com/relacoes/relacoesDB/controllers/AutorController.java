package com.relacoes.relacoesDB.controllers;

import com.relacoes.relacoesDB.models.Autor;
import com.relacoes.relacoesDB.services.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorService.getAutores();
        return ResponseEntity.ok(autores);
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.createAutor(autor);
        return ResponseEntity.ok(autor);
    }
}
