import br.com.fiap.bean.ContaPoupanca;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertThrows;

public class ContaPoupancaTeste {
    ContaPoupanca cp = new ContaPoupanca(1, 100, 1000, LocalDate.of(2021, 1, 1), 0.5f);

    @Test
    public void testDepositar() {
        cp.depositar(100);
        assert cp.getSaldo() == 1100;
    }//TEST

    @Test
    public void testRetirar() {
        cp.retirar(100);
        assert cp.getSaldo() == 899.5;
    }//TEST

    @Test
    public void testRetirarSaldoInsuficiente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cp.retirar(1001);
        });
        assert exception.getMessage().equals("Saldo insuficiente");
    }//TEST

    @Test
    public void testCalcularRetornoInvestimento() {
        // verificar ignorando possíveis diferenças de arredondamento
        assert Math.round(cp.calcularRetornoInvestimento()) == 50;
    }//TEST
}//CLASS