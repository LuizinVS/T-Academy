package com.relacoes.relacoesDB.services;

import com.relacoes.relacoesDB.models.Autor;
import com.relacoes.relacoesDB.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

}
