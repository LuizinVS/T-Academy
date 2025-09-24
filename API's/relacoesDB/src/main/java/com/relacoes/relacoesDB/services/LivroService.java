package com.relacoes.relacoesDB.services;

import com.relacoes.relacoesDB.models.Livro;
import com.relacoes.relacoesDB.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    public Livro criarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> findByAutorNacionalidade(String nacionalidade){
        return livroRepository.findByAutorNacionalidadeIgnoreCase(nacionalidade);
    }
}
