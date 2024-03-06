package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.CadastroMercadoDto;
import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;
import br.com.fiap.aula03.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mercados")
public class MercadoController {
    // Injeção de dependencia, o spring coloca o objeto no atributo
    @Autowired
    private MercadoRepository mercadoRepository;
    // GET
    @GetMapping("/consultar")
    public Mercado listar() {
        return new Mercado(1, "Carrefour", CategoriaMercado.HIPER);
    }//GET

    // POST
    @PostMapping
    public ResponseEntity<Mercado> cadastrar(@RequestBody Mercado dto, UriComponentsBuilder uriBuilder) {
        mercadoRepository.save(dto);
        var url = uriBuilder.path("/mercados/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }//POST
}//CLASS