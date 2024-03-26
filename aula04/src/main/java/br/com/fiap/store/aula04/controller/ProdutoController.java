package br.com.fiap.store.aula04.controller;

import br.com.fiap.store.aula04.dto.produto.CadastroProdutoDTO;
import br.com.fiap.store.aula04.dto.produto.DetalhesProdutoDTO;
import br.com.fiap.store.aula04.model.Produto;
import br.com.fiap.store.aula04.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDTO> cadastrar(@RequestBody CadastroProdutoDTO dto, UriComponentsBuilder uri) {
        var produto = new Produto(dto);
        produtoRepository.save(produto);
        var url = uri.path("/produtos/{id}").buildAndExpand(produto.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesProdutoDTO(produto));
    }
}
