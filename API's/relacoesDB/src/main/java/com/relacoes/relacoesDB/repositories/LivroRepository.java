package com.relacoes.relacoesDB.repositories;

import com.relacoes.relacoesDB.models.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    //List<Livro> findByAutorNacionalidadeIgnoreCase(String nacionalidade);

    Page<Livro> findAll(Pageable pageable);
    Page<Livro> findByAutorNacionalidadeIgnoreCase(String nacionalidade, Pageable pageable);
}
