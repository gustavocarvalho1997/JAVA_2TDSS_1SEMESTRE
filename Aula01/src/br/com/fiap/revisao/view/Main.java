package br.com.fiap.revisao.view;

import br.com.fiap.revisao.model.Churros;
import br.com.fiap.revisao.model.Produto;
import br.com.fiap.revisao.model.TipoChurros;

public class Main {
    public static void main(String[] args) {
        //Instanciar um Produto
        Produto produto = new Produto(1, "Sorvete", 20.0);

        //Instanciar um Churros
        Churros churros = new Churros(1, "Chocolate", 8.0, "Chocolate com granulado");

        //Chamar o método de calcular valor final
        var valor = produto.calcularValorFinal("CHURROSTDS");
        System.out.println(valor);

        valor = churros.calcularValorFinal("CHURROSTDS");
        System.out.println(valor);

        //TODO SETAR O TIPO DO CHURROS
        churros.setTipo(TipoChurros.SALGADO);
        //TODO VALIDAR SE O CHURROS É SALGADO
        if (churros.getTipo() == TipoChurros.SALGADO){
            System.out.println("O churros é salgado");
        } else {
            System.out.println("O churros não é salgado");
        }

    }
}