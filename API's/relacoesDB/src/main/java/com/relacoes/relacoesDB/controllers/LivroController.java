package com.relacoes.relacoesDB.controllers;

import com.relacoes.relacoesDB.models.Livro;
import com.relacoes.relacoesDB.repositories.LivroRepository;
import com.relacoes.relacoesDB.services.LivroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<Page<Livro>> getAllLivros(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Livro> livros = livroService.getLivros(pageable);
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.criarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping("/autor/nacionalidade/{nacionalidade}")
    public ResponseEntity<Page<Livro>> getByAutorNacion(@PathVariable String nacionalidade, Pageable pageable){
        return ResponseEntity.ok(livroService.findByAutorNacionalidade(nacionalidade, pageable));
    }

}
