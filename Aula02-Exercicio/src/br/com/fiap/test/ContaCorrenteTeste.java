import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertThrows;

public class ContaCorrenteTeste {
    ContaCorrente cc = new ContaCorrente(1, 100, 1000, LocalDate.of(2021, 1, 1), TipoConta.COMUM);

    @Test
    public void testDepositar() {
        cc.depositar(100);
        assert cc.getSaldo() == 1100;
    }//testDepositar

    @Test
    public void testRetirar() {
        cc.retirar(100);
        assert cc.getSaldo() == 900;
    }//testRetirar

    @Test
    public void testRetirarSaldoInsuficiente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cc.retirar(1001);
        });
        assert exception.getMessage().equals("Saldo insuficiente");
    }//testRetirarSaldoInsuficiente
}//CLASS