package br.com.fiap.revisao.dao;

import br.com.fiap.revisao.model.Produto;

import java.util.List;

public interface ProdutoDao {
        void cadastrar(Produto produto);
        List<Produto> listar();
}// Interface: ProdutoDao