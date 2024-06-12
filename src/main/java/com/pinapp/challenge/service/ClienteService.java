package com.pinapp.challenge.service;

import com.pinapp.challenge.dto.ClienteDTO;
import com.pinapp.challenge.dto.ClienteFechaMuerteDTO;
import com.pinapp.challenge.dto.ClienteKpiDTO;
import com.pinapp.challenge.exception.ClienteBadRequestException;
import com.pinapp.challenge.exception.ClienteNotFoundException;
import com.pinapp.challenge.model.Cliente;
import com.pinapp.challenge.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private static final int EDAD_MUERTE = 80;
    private final ClienteRepository clienteRepository;

    @Transactional
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        try {
            Cliente cliente = Cliente.builder()
                    .nombre(clienteDTO.getNombre())
                    .apellido(clienteDTO.getApellido())
                    .fechaNacimiento(clienteDTO.getFechaNacimiento())
                    .build();

            clienteRepository.save(cliente);
            clienteDTO.setEdad(getEdad(clienteDTO.getFechaNacimiento()));

            return clienteDTO;
        } catch (Exception ex) {
            throw new ClienteBadRequestException(String.format("Error al crear cliente. E: %s", ex.getMessage()));
        }
    }

    @Transactional(readOnly = true)
    public ClienteKpiDTO getKpiDeClientes() {
        try {
            ClienteKpiDTO clienteKpiDTO = new ClienteKpiDTO();
            clienteKpiDTO.setEdadPromedio(clienteRepository.getEdadPromedio());
            clienteKpiDTO.setDesviacionEstandar(clienteRepository.getDesviacionEstandar());

            return clienteKpiDTO;
        } catch (Exception ex) {
            throw new ClienteNotFoundException(String.format("No se pudo obtener los KPI de los clietes. E: %s", ex.getMessage()));
        }
    }

    @Transactional(readOnly = true)
    public List<ClienteFechaMuerteDTO> getClientes() {
        try {
            List<Cliente> clientes = clienteRepository.findAll();

            return clientes.stream()
                    .map(cliente -> {
                        ClienteFechaMuerteDTO clienteFechaMuerteDTO = new ClienteFechaMuerteDTO();
                        clienteFechaMuerteDTO.setClienteDTO(mapClienteToClienteDTO(cliente));
                        clienteFechaMuerteDTO.setFechaProbableDeMuerte(cliente.getFechaNacimiento().plusYears(EDAD_MUERTE));
                        return clienteFechaMuerteDTO;
                    }).toList();
        } catch (Exception ex) {
            throw new ClienteNotFoundException(String.format("No se pudo listar a los clientes. Error: %s", ex.getMessage()));
        }
    }

    private ClienteDTO mapClienteToClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setEdad(getEdad(cliente.getFechaNacimiento()));
        clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
        return clienteDTO;
    }

    private int getEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
