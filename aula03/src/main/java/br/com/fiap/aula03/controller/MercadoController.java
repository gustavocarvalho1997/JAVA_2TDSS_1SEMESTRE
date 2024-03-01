package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.CadastroMercadoDto;
import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mercados")
public class MercadoController {
    // GET
    @GetMapping("/consultar")
    public Mercado listar() {
        return new Mercado(1, "Carrefour", CategoriaMercado.HIPER);
    }//GET

    // POST
    @PostMapping
    public ResponseEntity<Mercado> cadastrar(@RequestBody CadastroMercadoDto dto, UriComponentsBuilder uriBuilder) {
        var url = uriBuilder.path("/mercados/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(url).body(new Mercado(1, dto.nome(), dto.categoria()));
    }//POST
}//CLASS