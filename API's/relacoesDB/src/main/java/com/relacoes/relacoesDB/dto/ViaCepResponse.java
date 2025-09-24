package com.relacoes.relacoesDB.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ViaCepResponse {
    @JsonProperty("cep")
    private String cep;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("localidade")
    private String cidade;

    @JsonProperty("uf")
    private String estado;
}
