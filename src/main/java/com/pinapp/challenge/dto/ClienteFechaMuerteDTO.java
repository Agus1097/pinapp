package com.pinapp.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteFechaMuerteDTO {

    @JsonProperty("cliente")
    private ClienteDTO clienteDTO;

    @JsonProperty("fecha_probable_de_muerte")
    private LocalDate fechaProbableDeMuerte;
}