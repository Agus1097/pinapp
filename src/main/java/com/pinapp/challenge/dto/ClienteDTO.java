package com.pinapp.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {

    private String nombre;

    private String apellido;

    private int edad;

    @JsonProperty("fecha_nacimiento")
    private LocalDate fechaNacimiento;
}
