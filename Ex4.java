package Propostos1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex4 {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ex4::new);
    }

    public Ex4() {
        criarJanelaLogin();
    }

    private void criarJanelaLogin() {
        frame = new JFrame("Tela de Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        frame.setVisible(true);
    }

    private void validarLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Verifique se o usuário e a senha são válidos
        if (username.equals("admin") && password.equals("senha123")) {
            exibirMensagemSucesso();
        } else {
            JOptionPane.showMessageDialog(frame, "Dados incorretos. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirMensagemSucesso() {
        JFrame successFrame = new JFrame("Sucesso");
        successFrame.setSize(250, 100);
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setLayout(new FlowLayout());

        JLabel successLabel = new JLabel("Login bem-sucedido!");
        successFrame.add(successLabel);

        successFrame.setVisible(true);
    }
}


