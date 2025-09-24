package com.relacoes.relacoesDB.services;

import com.relacoes.relacoesDB.dto.ViaCepResponse;
import com.relacoes.relacoesDB.models.Cliente;
import com.relacoes.relacoesDB.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ViaCepService viaCepService;

    public ClienteService(ClienteRepository clienteRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.viaCepService = viaCepService;
    }

    public Cliente criarCliente(Cliente cliente) {
        ViaCepResponse cepInfo = viaCepService.buscarCep(cliente.getCep());

        if (cepInfo != null && cepInfo.getCep() != null) {
            cliente.setCidade(cepInfo.getCidade());
            cliente.setEstado(cepInfo.getEstado());
            cliente.setBairro(cepInfo.getBairro());
        } else {
            throw new RuntimeException("CEP inválido ou não encontrado");
        }

        return clienteRepository.save(cliente);
    }
}