package br.com.fiap.store.aula04.controller;

import br.com.fiap.store.aula04.dto.cliente.AtualizacaoClienteDTO;
import br.com.fiap.store.aula04.dto.cliente.CadastroClienteDTO;
import br.com.fiap.store.aula04.dto.cliente.DetalhesClienteDTO;
import br.com.fiap.store.aula04.dto.cliente.ListagemClienteDTO;
import br.com.fiap.store.aula04.model.Cliente;
import br.com.fiap.store.aula04.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // Repository
    @Autowired
    private ClienteRepository clienteRepository;

    // POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDTO> cadastrar(@RequestBody @Valid CadastroClienteDTO dto, UriComponentsBuilder uri) {
        var cliente = new Cliente(dto);
        clienteRepository.save(cliente);
        var url = uri.path("/clientes/{id}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesClienteDTO(cliente));
    }

    // GET All
    @GetMapping
    public ResponseEntity<List<ListagemClienteDTO>> listar(Pageable paginacao) {
        var lista = clienteRepository.findAll(paginacao).stream().map(ListagemClienteDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    // GET Codigo
    @GetMapping("/{codigo}")
    public ResponseEntity<DetalhesClienteDTO> pesquisar(@PathVariable("codigo") Long codigo) {
        var cliente = clienteRepository.getReferenceById(codigo);
        return ResponseEntity.ok(new DetalhesClienteDTO(cliente));
    }

    // PUT
    @PutMapping("/{codigo}")
    @Transactional
    public ResponseEntity<DetalhesClienteDTO> atualizar(@PathVariable("codigo") Long codigo, @RequestBody AtualizacaoClienteDTO dto){
        var cliente = clienteRepository.getReferenceById(codigo);
        cliente.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesClienteDTO(cliente));
    }

    // DELETE
    @DeleteMapping("/{codigo}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("codigo") Long codigo) {
        clienteRepository.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }
}//CLASS