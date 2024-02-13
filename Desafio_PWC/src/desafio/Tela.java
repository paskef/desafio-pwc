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

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmDesafioPwc = new JFrame();
		frmDesafioPwc.setTitle("Desafio PWC");
		frmDesafioPwc.getContentPane().setBackground(new Color(27, 28, 29));
		frmDesafioPwc.setBounds(100, 100, 877, 604);
		frmDesafioPwc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesafioPwc.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(111, 27, 2));
		panel.setBounds(0, 0, 324, 567);
		frmDesafioPwc.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 27));
		lblAddress.setBounds(440, 120, 397, 47);
		frmDesafioPwc.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBackground(new Color(98, 98, 98));
		txtAddress.setForeground(new Color(210, 210, 210));
		txtAddress.setFont(new Font("Rockwell", Font.ITALIC, 15));
		txtAddress.setBounds(440, 177, 358, 38);
		frmDesafioPwc.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 27));
		lblOutput.setBounds(440, 252, 397, 47);
		frmDesafioPwc.getContentPane().add(lblOutput);
		
		txtAddress_Output = new JTextField();
		txtAddress_Output.setEditable(false);
		txtAddress_Output.setText("address:");
		txtAddress_Output.setForeground(new Color(210, 210, 210));
		txtAddress_Output.setFont(new Font("Rockwell", Font.ITALIC, 16));
		txtAddress_Output.setColumns(10);
		txtAddress_Output.setBackground(new Color(98, 98, 98));
		txtAddress_Output.setBounds(440, 309, 358, 38);
		frmDesafioPwc.getContentPane().add(txtAddress_Output);
		
		JButton btnAdjust = new JButton("ADJUST");
		btnAdjust.setBackground(new Color(98, 98, 98));
		btnAdjust.setForeground(new Color(210, 210, 210));
		btnAdjust.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnAdjust.setBounds(440, 396, 81, 33);
		frmDesafioPwc.getContentPane().add(btnAdjust);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(new Color(210, 210, 210));
		btnClear.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnClear.setBackground(new Color(98, 98, 98));
		btnClear.setBounds(577, 396, 81, 33);
		frmDesafioPwc.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setForeground(new Color(210, 210, 210));
		btnExit.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnExit.setBackground(new Color(98, 98, 98));
		btnExit.setBounds(710, 396, 81, 33);
		frmDesafioPwc.getContentPane().add(btnExit);
	}
}
