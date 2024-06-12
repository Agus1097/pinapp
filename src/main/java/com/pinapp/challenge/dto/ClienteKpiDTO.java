package com.pinapp.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteKpiDTO {

    @JsonProperty("edad_promedio")
    private int edadPromedio;

    @JsonProperty("desviacion_estandar")
    private double desviacionEstandar;
}
