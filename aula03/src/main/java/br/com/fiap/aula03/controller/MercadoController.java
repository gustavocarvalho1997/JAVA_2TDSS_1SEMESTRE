package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.mercado.AtualizacaoMercadoDTO;
import br.com.fiap.aula03.dto.mercado.CadastroMercadoDto;
import br.com.fiap.aula03.dto.mercado.DetalhesMercadoDto;
import br.com.fiap.aula03.dto.mercado.ListagemMercadoDTO;
import br.com.fiap.aula03.model.Mercado;
import br.com.fiap.aula03.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @Autowired //Injeção de dependencia, o spring coloca o objeto no atributo
    private MercadoRepository mercadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesMercadoDto> cadastrar(@RequestBody CadastroMercadoDto mercadoDto,
                                                        UriComponentsBuilder uri){
        var mercado = new Mercado(mercadoDto);
        mercadoRepository.save(mercado);
        var url = uri.path("/mercados/{id}").buildAndExpand(mercado.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesMercadoDto(mercado));
    }

    @GetMapping
    public ResponseEntity<List<ListagemMercadoDTO>> listar(Pageable paginacao) {
        var lista = mercadoRepository.findAll(paginacao).stream().map(ListagemMercadoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesMercadoDto> pesquisar(@PathVariable("id") Integer id) {
        var mercado = mercadoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesMercadoDto(mercado));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesMercadoDto> atualizar(@PathVariable("id") Integer id,
                                                       @RequestBody AtualizacaoMercadoDTO dto) {
        var mercado = mercadoRepository.getReferenceById(id);
        mercado.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesMercadoDto(mercado));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) {
        mercadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}