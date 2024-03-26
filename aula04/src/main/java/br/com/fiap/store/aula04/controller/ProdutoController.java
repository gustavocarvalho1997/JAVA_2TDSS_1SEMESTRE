package br.com.fiap.store.aula04.controller;

import br.com.fiap.store.aula04.dto.produto.CadastroProdutoDTO;
import br.com.fiap.store.aula04.dto.produto.DetalhesProdutoDTO;
import br.com.fiap.store.aula04.dto.produto.ListagemProdutoDTO;
import br.com.fiap.store.aula04.model.Produto;
import br.com.fiap.store.aula04.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    // GET all
    @GetMapping
    public ResponseEntity<List<ListagemProdutoDTO>> listar(Pageable paginacao) {
        var lista = produtoRepository.findAll(paginacao).stream().map(ListagemProdutoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    // GET by id
    @GetMapping("/{codigo}")
    public ResponseEntity<DetalhesProdutoDTO> pesquisar(@PathVariable("codigo") Long codigo) {
        var produto = produtoRepository.getReferenceById(codigo);
        return ResponseEntity.ok(new DetalhesProdutoDTO(produto));
    }
}
