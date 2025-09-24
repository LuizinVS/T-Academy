package com.relacoes.relacoesDB.controllers;

import com.relacoes.relacoesDB.models.Autor;
import com.relacoes.relacoesDB.services.AutorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<Autor>> getAllAutores(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Autor> autoresPage = autorService.getAutores(pageable);
        return ResponseEntity.ok(autoresPage);
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.createAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }
}
