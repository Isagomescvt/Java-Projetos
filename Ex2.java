package Propostos1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex2 extends JFrame {
    private JButton okButton;
    private JButton cancelButton;
    private JRadioButton redButton;
    private JComboBox<String> bgOptions;
    private JComboBox<String> fgOptions;

    public Ex2() {
        setTitle("ColorSelect");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

       
        redButton = new JRadioButton("RED");
        redButton.setSelected(true);

     
        String[] colors = {"WHITE", "BLACK", "BLUE", "GREEN", "YELLOW"};
        bgOptions = new JComboBox<>(colors);
        fgOptions = new JComboBox<>(colors);

   
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

       
        okButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                Color backgroundColor = getColorFromSelection((String) bgOptions.getSelectedItem());
                Color foregroundColor = getColorFromSelection((String) fgOptions.getSelectedItem());
                getContentPane().setBackground(backgroundColor);
                redButton.setForeground(foregroundColor);
                JOptionPane.showMessageDialog(null, "Cores Aplicadas!");
            }
        });

    
        cancelButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
               
            }
        });

      
        add(redButton);
        add(new JLabel("Background:"));
        add(bgOptions);
        add(new JLabel("Foreground:"));
        add(fgOptions);
        add(okButton);
        add(cancelButton);
    }

   
    private Color getColorFromSelection(String color) {
        switch (color) {
            case "WHITE":
                return Color.WHITE;
            case "BLACK":
                return Color.BLACK;
            case "BLUE":
                return Color.BLUE;
            case "GREEN":
                return Color.GREEN;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ex2 colorSelect = new Ex2();
            colorSelect.setVisible(true);
        });
    }


}

