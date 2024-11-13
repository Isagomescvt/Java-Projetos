package Propostos1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mercado {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Mercado");
		
		JPanel toppingsPanel = new JPanel();
		JLabel toppingsLabel = new JLabel("Selecione os itens:              Valores: ");
		
		
		
		JCheckBox ArrozCheckBox = new JCheckBox("Frango                                   R$ 18,00");
		JCheckBox FeijaoCheckBox = new JCheckBox("Macarrão 1kg                                  R$ 6,00");
		JCheckBox CarneCheckBox = new JCheckBox("Contra filé kg                                   R$ 32,00");
		JCheckBox BatatafritaCheckBox = new JCheckBox("Mussarela 100g                        R$ 4,00");
		
		
		toppingsPanel.setLayout(new GridLayout(0, 1));
		toppingsPanel.add(toppingsLabel);
		toppingsPanel.add(ArrozCheckBox);
		toppingsPanel.add(FeijaoCheckBox);
		toppingsPanel.add(CarneCheckBox);
		toppingsPanel.add(BatatafritaCheckBox);
		
		JButton orderButton = new JButton("Encomendar");
		
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder orderDetails = new StringBuilder("Pedido");
				if (ArrozCheckBox.isSelected()) {
					orderDetails.append("Arroz");
					
				}
				if (FeijaoCheckBox.isSelected()) {
					orderDetails.append("Feijão");
				}
				
				if (CarneCheckBox.isSelected()) {
					orderDetails.append("Carne");
				}
				if (BatatafritaCheckBox.isSelected()) {
					orderDetails.append("Batata Frita");
				}
				if (orderDetails.toString().equals("Pedidos:")) {
					orderDetails.append("Nenhum Iten Selecionado");
				}
				JOptionPane.showMessageDialog(frame,  orderDetails.toString());
			}
		});
		
		frame.setLayout(new BorderLayout());
		frame.add(toppingsPanel, BorderLayout.CENTER);
		frame.add(orderButton, BorderLayout.SOUTH);
		
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

	


