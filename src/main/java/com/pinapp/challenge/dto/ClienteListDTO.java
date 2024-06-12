package com.pinapp.challenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteListDTO {
    List<ClienteFechaMuerteDTO> clientes;
}
