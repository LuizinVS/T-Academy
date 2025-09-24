package com.relacoes.relacoesDB.repositories;

import com.relacoes.relacoesDB.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
