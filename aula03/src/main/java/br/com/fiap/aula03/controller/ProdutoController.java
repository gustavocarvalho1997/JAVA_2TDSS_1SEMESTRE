package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.produto.AtualizacaoProdutoDTO;
import br.com.fiap.aula03.dto.produto.CadastroProdutoDto;
import br.com.fiap.aula03.dto.produto.DetalhesProdutoDto;
import br.com.fiap.aula03.dto.produto.ListagemProdutoDTO;
import br.com.fiap.aula03.model.Produto;
import br.com.fiap.aula03.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    //GET
    @GetMapping
    public ResponseEntity<List<ListagemProdutoDTO>> listar(Pageable paginacao){
        var lista = produtoRepository.findAll(paginacao).stream().map(ListagemProdutoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }//GET

    //GET ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesProdutoDto> pesquisar(@PathVariable("id") Integer id) {
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }//GET ID


    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> cadastrar(@RequestBody CadastroProdutoDto produtoDto, UriComponentsBuilder uri) {
        var produto = new Produto(produtoDto);
        produtoRepository.save(produto);
        var url = uri.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesProdutoDto(produto));
    }//POST

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> atualizar(@PathVariable("id") Integer id, @RequestBody AtualizacaoProdutoDTO dto) {
        var produto = produtoRepository.getReferenceById(id);
        produto.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }//PUT

    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }//DELETE

}
