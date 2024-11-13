package Propostos1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex3 {
    private JTextField display;
    private String operador = "";
    private double num1 = 0;

    public static void main(String[] args) {
        new Ex3().criarCalculadora();
    }

    private void criarCalculadora() {
        // Criação da janela
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Campo de texto para exibir resultados
        display = new JTextField();
        display.setBounds(20, 20, 240, 40);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display);

        // Botões da calculadora
        String[] botoes = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "0", "C", "="
        };

        // Disposição dos números
        int x = 20, y = 80;
        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setBounds(x, y, 60, 60);
            botao.addActionListener(new BotaoListener());
            frame.add(botao);

            x += 70;
            if (x > 220) {
                x = 20;
                y += 70;
            }
        }

        // Botões de operação
        String[] operacoes = {"+", "-", "*", "/"};
        x = 220;
        y = 80;
        for (String texto : operacoes) {
            JButton botao = new JButton(texto);
            botao.setBounds(x, y, 60, 60);
            botao.addActionListener(new BotaoListener());
            frame.add(botao);
            y += 70; // Coloca os botões de operação em linha
        }

        // Exibir a janela
        frame.setVisible(true);
    }

    private class BotaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if ("C".equals(comando)) {
                display.setText("");
                operador = "";
                num1 = 0;
            } else if ("=".equals(comando)) {
                double num2 = Double.parseDouble(display.getText());
                double resultado = calcular(num1, num2, operador);
                display.setText(String.valueOf(resultado));
                operador = ""; // Limpa o operador após cálculo
            } else if ("+".equals(comando) || "-".equals(comando) || "*".equals(comando) || "/".equals(comando)) {
                num1 = Double.parseDouble(display.getText());
                operador = comando;
                display.setText("");
            } else {
                display.setText(display.getText() + comando);
            }
        }

        private double calcular(double num1, double num2, String operador) {
            switch (operador) {
                case "/":
                    return num1 / num2;
                case "*":
                    return num1 * num2;
                case "-":
                    return num1 - num2;
                case "+":
                    return num1 + num2;
                default:
                    return 0;
            }
        }
    }
}
