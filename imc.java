package Propostos1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class imc {
    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel labelPeso = new JLabel("Peso (kg):");
        labelPeso.setBounds(50, 50, 100, 25);
        frame.add(labelPeso);

        JLabel labelAltura = new JLabel("Altura (m):");
        labelAltura.setBounds(50, 100, 100, 25);
        frame.add(labelAltura);

        JLabel labelResultado = new JLabel("IMC:");
        labelResultado.setBounds(50, 200, 300, 25);
        frame.add(labelResultado);

        // Campos de texto
        JTextField textPeso = new JTextField();
        textPeso.setBounds(150, 50, 100, 25);
        frame.add(textPeso);

        JTextField textAltura = new JTextField();
        textAltura.setBounds(150, 100, 100, 25);
        frame.add(textAltura);

        // Botão de calcular
        JButton botaoCalcular = new JButton("Calcular IMC");
        botaoCalcular.setBounds(50, 150, 200, 30);
        frame.add(botaoCalcular);

        // Ação do botão
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter valores do texto
                    double peso = Double.parseDouble(textPeso.getText());
                    double altura = Double.parseDouble(textAltura.getText());

                    // Verificar altura
                    if (altura <= 0) {
                        JOptionPane.showMessageDialog(frame, "A altura precisa ser maior que zero", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Calcular IMC
                    double imc = peso / (altura * altura);
                    String faixaIMC;

                    // Determinar faixa de IMC
                    if (imc < 18.5) {
                        faixaIMC = "Abaixo do peso";
                    } else if (imc < 24.9) {
                        faixaIMC = "Peso normal";
                    } else if (imc < 29.9) {
                        faixaIMC = "Sobrepeso";
                    } else {
                        faixaIMC = "Obesidade";
                    }

                    // Mostrar resultado
                    labelResultado.setText(String.format("IMC: %.2f - %s", imc, faixaIMC));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos para peso e altura", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Exibir a janela
        frame.setVisible(true);
    }
}



