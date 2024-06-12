package com.pinapp.challenge.controller.impl;

import com.pinapp.challenge.dto.ClienteDTO;
import com.pinapp.challenge.dto.ClienteFechaMuerteDTO;
import com.pinapp.challenge.dto.ClienteKpiDTO;
import com.pinapp.challenge.dto.ClienteListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteControllerImpl {

    @Operation(summary = "Endpoint para crear un cliente",
            description = "Los paramentros que utiliza son: nombre, apellido y fecha_nacimiento")
    @ApiResponses(value = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = ClienteDTO.class), mediaType = "application/json")),
            @ApiResponse(description = "BadRequest", responseCode = "400", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<ClienteDTO> createCliente(ClienteDTO clienteDTO);

    @Operation(summary = "Endpoint para obtener el KPI de los clientes",
            description = "No son necesarios parametros de entrada")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteKpiDTO.class), mediaType = "application/json")),
            @ApiResponse(description = "NotFound", responseCode = "404", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<ClienteKpiDTO> getKpiDeClientes();

    @Operation(summary = "Endpoint para listar todos los cliente y sus fecha probable de muerte",
            description = "No son necesarios parametros de entrada")
    @ApiResponses(value = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteListDTO.class), mediaType = "application/json")),
            @ApiResponse(description = "NotFound", responseCode = "404", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<List<ClienteFechaMuerteDTO>> getClientes();
}