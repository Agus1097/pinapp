package com.pinapp.challenge.controller;

import com.pinapp.challenge.controller.impl.ClienteControllerImpl;
import com.pinapp.challenge.dto.ClienteDTO;
import com.pinapp.challenge.dto.ClienteFechaMuerteDTO;
import com.pinapp.challenge.dto.ClienteKpiDTO;
import com.pinapp.challenge.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Cliente")
public class ClienteController implements ClienteControllerImpl {

    private final ClienteService clienteService;

    @Override
    @PostMapping("/crearcliente")
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.createCliente(clienteDTO), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/kpideclientes")
    public ResponseEntity<ClienteKpiDTO> getKpiDeClientes() {
        return new ResponseEntity<>(clienteService.getKpiDeClientes(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/listclientes")
    public ResponseEntity<List<ClienteFechaMuerteDTO>> getClientes() {
        return new ResponseEntity<>(clienteService.getClientes(), HttpStatus.OK);
    }
}
