package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.CadastroProdutoDto;
import br.com.fiap.aula03.dto.DetalhesProdutoDto;
import br.com.fiap.aula03.model.Produto;
import br.com.fiap.aula03.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    // Injeção de dependencia, o spring coloca o objeto no atributo
    @Autowired
    private ProdutoRepository produtoRepository;

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> cadastrar(@RequestBody CadastroProdutoDto produtoDto, UriComponentsBuilder uri) {
        var produto = new Produto(produtoDto);
        produtoRepository.save(produto);
        var url = uri.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesProdutoDto(produto));
    }//POST

}
