package br.com.fiap.revisao.view;

import br.com.fiap.revisao.dao.ProdutoDao;
import br.com.fiap.revisao.dao.oracle.ProdutoOracleDao;
import br.com.fiap.revisao.model.Produto;

public class InterfaceTeste {
    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoOracleDao();
        // Cadastrar um produto
        dao.cadastrar(new Produto(1, "Churros", 10.0));
        dao.cadastrar(new Produto(2, "Café", 5.0));
        dao.cadastrar(new Produto(3, "Coxinha", 4.0));
        // Listar os produtos
        for (Produto item : dao.listar()){
            System.out.println(item.getNome());
        }
    }
}// InterfaceTeste