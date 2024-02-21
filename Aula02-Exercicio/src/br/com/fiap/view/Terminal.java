package br.com.fiap.view;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

import java.time.LocalDate;
import java.util.List;

public class Terminal {
    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(1, 100, 1000, LocalDate.of(2021, 1, 1), TipoConta.ESPECIAL);
        ContaPoupanca cp1 = new ContaPoupanca(2, 200, 2000, LocalDate.of(2021, 1, 1), 0.5f);

        ContaCorrente cc2 = new ContaCorrente(3, 300, 3000, LocalDate.of(2021, 1, 1), TipoConta.COMUM);
        ContaCorrente cc3 = new ContaCorrente(4, 400, 4000, LocalDate.of(2021, 1, 1), TipoConta.PREMIUM);
        ContaCorrente cc4 = new ContaCorrente(5, 500, 5000, LocalDate.of(2021, 1, 1), TipoConta.ESPECIAL);

        List<ContaCorrente> lista = List.of(cc1, cc2, cc3, cc4);

        for(ContaCorrente conta : lista) {
            System.out.println(conta.getSaldo());
        }
    }//MAIN
}//CLASS