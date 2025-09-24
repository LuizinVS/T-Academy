package com.relacoes.relacoesDB.services;

import com.relacoes.relacoesDB.models.Livro;
import com.relacoes.relacoesDB.repositories.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Page<Livro> getLivros(Pageable pageable){
        return livroRepository.findAll(pageable);
    }

    public Livro criarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public Page<Livro> findByAutorNacionalidade(String nacionalidade, Pageable pageable){
        return livroRepository.findByAutorNacionalidadeIgnoreCase(nacionalidade, pageable);
    }
}
