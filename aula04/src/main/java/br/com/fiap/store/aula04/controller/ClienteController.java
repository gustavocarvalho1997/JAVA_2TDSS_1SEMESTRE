package br.com.fiap.store.aula04.controller;

import br.com.fiap.store.aula04.dto.CadastroClienteDTO;
import br.com.fiap.store.aula04.dto.DetalhesClienteDTO;
import br.com.fiap.store.aula04.model.Cliente;
import br.com.fiap.store.aula04.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // Repository
    @Autowired
    private ClienteRepository clienteRepository;

    // POST
    // TODO : Terminar de implementar o POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDTO> cadastrar(@RequestBody CadastroClienteDTO dto, UriComponentsBuilder uri) {
        var cliente = new Cliente(dto);
        clienteRepository.save(cliente);
        var url = uri.path("/clientes/{id}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesClienteDTO(cliente));
    }
}//CLASS