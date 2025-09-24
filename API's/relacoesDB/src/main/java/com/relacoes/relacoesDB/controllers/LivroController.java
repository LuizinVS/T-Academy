package com.relacoes.relacoesDB.controllers;

import com.relacoes.relacoesDB.models.Livro;
import com.relacoes.relacoesDB.repositories.LivroRepository;
import com.relacoes.relacoesDB.services.LivroService;
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
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> livros = livroService.getLivros();
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.criarLivro(livro);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/autor/nacionalidade/{nacionalidade}")
    public ResponseEntity<List<Livro>> getByAutorNacion(@PathVariable String nacionalidade){
        return ResponseEntity.ok(livroService.findByAutorNacionalidade(nacionalidade));
    }

}
