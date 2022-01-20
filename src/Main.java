import javax.swing.JOptionPane;
import java.text.DecimalFormat;


public class Main {


    public static void main(String[] args) {

        DecimalFormat df2 = new DecimalFormat("R$ #,##0.00");
        String[] opcoesJOptionPane = {"Acessar Banco", "Sair"};

        Cliente primeiroCliente = new Cliente("Lucas");

        Conta cc = new ContaCorrente(primeiroCliente);
        Conta cp = new ContaPoupanca(primeiroCliente);

        int opcao;

        opcao = JOptionPane.showOptionDialog(
                null,
                "Selecione sua opção:",
                "HOME",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesJOptionPane,
                opcoesJOptionPane[0]
        );

        if (opcao == 0) telaCliente();
    }

    protected static void telaCliente() {

        DecimalFormat df2 = new DecimalFormat("R$ #,##0.00");
        String[] opcaoConta = {"Corrente", "Poupança"};
        int opcao;
        double valor;

        opcao = JOptionPane.showOptionDialog(
                null,
                "Informe a conta que deseja acessar: ",
                "Tela Cliente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcaoConta,
                opcaoConta[0]
        );

        if (opcao == 0) {
            Cliente primeiroCliente = new Cliente("Lucas");
            Conta cc = new ContaCorrente(primeiroCliente);
            Conta cp = new ContaPoupanca(primeiroCliente);

            String[] opcoesCliente = {"Sacar", "Depositar", "Transferir", "Imprimir Extrato", "Sair"};

            do {
                opcao = JOptionPane.showOptionDialog(
                        null,
                        "Informe a operação que deseja realizar: ",
                        "Conta corrente",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoesCliente,
                        opcoesCliente[0]
                );

                if (opcao == 0) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado: "));
                    cc.sacar(valor);
                } else if (opcao == 1) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser depositado: "));
                    cc.depositar(valor);
                } else if (opcao == 2) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser transferido: "));
                    cc.transferir(valor, cp);
                } else if (opcao == 3) {
                    cc.imprimirExtrato();
                }
            } while (opcao != 4);
        } else if (opcao == 1) {
            Cliente primeiroCliente = new Cliente("Lucas");
            Conta c1 = new ContaCorrente(primeiroCliente);
            Conta cp1 = new ContaPoupanca(primeiroCliente);
            int op;

            String[] opcoesCliente = {"Sacar", "Depositar", "Transferir", "Imprimir Extrato", "Sair"};
            do {
                op = JOptionPane.showOptionDialog(
                        null,
                        "Informe a operação que deseja realizar: ",
                        "Conta poupança",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoesCliente,
                        opcoesCliente[0]
                );

                if (op == 0) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado: "));
                    cp1.sacar(valor);
                } else if (op == 1) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado: "));
                    cp1.depositar(valor);
                } else if (op == 2) {
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado: "));
                    cp1.transferir(valor, c1);
                } else if (op == 3) {
                    cp1.imprimirExtrato();
                }
            } while (op != 4);
        }
    }
}