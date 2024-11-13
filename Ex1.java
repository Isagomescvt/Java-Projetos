package Propostos1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 extends JFrame {
	private JPanel panel;

	public Ex1() {

		setTitle("Color Changer");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton redButton = new JButton("Vermelho");
		JButton greenButton = new JButton("Verde");
		JButton blueButton = new JButton("Azul");

		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);

		redButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.RED);
			}
		});

		greenButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.GREEN);
			}
		});

		blueButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.BLUE);
			}
		});

		add(panel);

		setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new Ex1();
			}
		});
	}
}


