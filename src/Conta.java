import javax.swing.*;
import java.text.DecimalFormat;

public abstract class Conta implements IConta {

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo > valor) this.saldo -= valor;
        else JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque!");
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(this.saldo > valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else JOptionPane.showMessageDialog(null, "Saldo insuficiente para transferência!");
    }

    protected void imprimirInfosComuns() {
        DecimalFormat df2 = new DecimalFormat("R$ #,##0.00");

        String msg = "Titular: "      + this.cliente.getNome() +
                     "\nAgência: "    + this.getAgencia() +
                     "\nConta: "      + this.getConta()  +
                     "\nSaldo: "      + df2.format(this.getSaldo());
        JOptionPane.showMessageDialog(null, msg);
    }

}
