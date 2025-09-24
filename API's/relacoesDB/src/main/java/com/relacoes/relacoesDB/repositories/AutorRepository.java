package com.relacoes.relacoesDB.repositories;

import com.relacoes.relacoesDB.models.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Page<Autor> findAll(Pageable pageable);

}
