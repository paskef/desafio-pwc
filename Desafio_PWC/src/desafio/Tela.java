package desafio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela {

    private JFrame frmDesafioPwc;
    private JTextField txtAddress;
    private JTextField txtAddress_Output;
    private Lógica logica;

    /**
     * Método principal para iniciar a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela window = new Tela();
                    window.frmDesafioPwc.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Construtor da classe Tela.
     */
    public Tela() {
        initialize();
        logica = new Lógica(); // Inicializa a classe da lógica.
    }

    /**
     * Inicializa os componentes da interface gráfica.
     */
    private void initialize() {
        frmDesafioPwc = new JFrame();
        frmDesafioPwc.setTitle("Desafio PWC");
        frmDesafioPwc.getContentPane().setBackground(new Color(27, 28, 29));
        frmDesafioPwc.setBounds(100, 100, 877, 604);
        frmDesafioPwc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDesafioPwc.getContentPane().setLayout(null);
        frmDesafioPwc.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(60, 60, 60));
        panel.setBounds(0, 0, 279, 567);
        frmDesafioPwc.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblAddress = new JLabel("Endereço:");
        lblAddress.setForeground(new Color(255, 255, 255));
        lblAddress.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 27));
        lblAddress.setBounds(401, 120, 397, 47);
        frmDesafioPwc.getContentPane().add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBackground(new Color(98, 98, 98));
        txtAddress.setForeground(new Color(210, 210, 210));
        txtAddress.setFont(new Font("Rockwell", Font.ITALIC, 15));
        txtAddress.setBounds(401, 177, 358, 38);
        frmDesafioPwc.getContentPane().add(txtAddress);
        txtAddress.setColumns(10);

        JLabel lblOutput = new JLabel("Saída");
        lblOutput.setForeground(Color.WHITE);
        lblOutput.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 27));
        lblOutput.setBounds(401, 252, 397, 47);
        frmDesafioPwc.getContentPane().add(lblOutput);

        txtAddress_Output = new JTextField();
        txtAddress_Output.setEditable(false);
        txtAddress_Output.setForeground(new Color(210, 210, 210));
        txtAddress_Output.setFont(new Font("Rockwell", Font.ITALIC, 16));
        txtAddress_Output.setColumns(10);
        txtAddress_Output.setBackground(new Color(98, 98, 98));
        txtAddress_Output.setBounds(401, 309, 358, 38);
        frmDesafioPwc.getContentPane().add(txtAddress_Output);

        JButton btnAdjust = new JButton("ENVIAR");
        btnAdjust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processarEndereco();
            }
        });
        btnAdjust.setBackground(new Color(98, 98, 98));
        btnAdjust.setForeground(new Color(210, 210, 210));
        btnAdjust.setFont(new Font("Rockwell", Font.BOLD, 11));
        btnAdjust.setBounds(401, 396, 82, 33);
        frmDesafioPwc.getContentPane().add(btnAdjust);

        JButton btnClear = new JButton("LIMPAR");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos(); // Puxa o método para limpar os textFields
            }
        });
        btnClear.setForeground(new Color(210, 210, 210));
        btnClear.setFont(new Font("Rockwell", Font.BOLD, 11));
        btnClear.setBackground(new Color(98, 98, 98));
        btnClear.setBounds(540, 396, 82, 33);
        frmDesafioPwc.getContentPane().add(btnClear);

        JButton btnExit = new JButton("SAIR");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra o programa
            }
        });
        btnExit.setForeground(new Color(210, 210, 210));
        btnExit.setFont(new Font("Rockwell", Font.BOLD, 11));
        btnExit.setBackground(new Color(98, 98, 98));
        btnExit.setBounds(678, 396, 82, 33);
        frmDesafioPwc.getContentPane().add(btnExit);
    }

    /**
     * Limpa os campos de texto
     */
    public void limparCampos() {
        txtAddress.setText("");
        txtAddress_Output.setText("");
    }

    /**
     * Processa o endereço digitado pelo usuário
     */
    private void processarEndereco() {
        String endereco = txtAddress.getText();
        String[] resultado = logica.processarEndereco(endereco);

        // Configura a saída
        txtAddress_Output.setText("Nome: \"" + resultado[0] + "\"  Num: \"" + resultado[1] + "\"");
    }
}
