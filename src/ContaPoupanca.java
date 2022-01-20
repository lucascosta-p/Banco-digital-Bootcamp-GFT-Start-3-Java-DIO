import javax.swing.*;
import java.text.DecimalFormat;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        super.imprimirInfosComuns();
    }
}
