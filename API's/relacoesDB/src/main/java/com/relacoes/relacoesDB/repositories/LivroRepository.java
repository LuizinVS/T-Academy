package com.relacoes.relacoesDB.repositories;

import com.relacoes.relacoesDB.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorNacionalidadeIgnoreCase(String nacionalidade);
}
