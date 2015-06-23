import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConnectWithServer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectWithServer frame = new ConnectWithServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConnectWithServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWW = new JLabel("W W");
		lblWW.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWW.setHorizontalAlignment(SwingConstants.CENTER);
		lblWW.setBounds(160, 18, 120, 26);
		contentPane.add(lblWW);
		
		JLabel label = new JLabel("服务器");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(104, 80, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("端口");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(104, 125, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("用户名");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(104, 173, 61, 16);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setText("127.0.0.1");
		textField.setBounds(213, 75, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("8000");
		textField_1.setColumns(10);
		textField_1.setBounds(213, 120, 134, 28);
		contentPane.add(textField_1);
		
		txtAdmin = new JTextField();
		txtAdmin.setText("admin");
		txtAdmin.setColumns(10);
		txtAdmin.setBounds(213, 168, 134, 28);
		contentPane.add(txtAdmin);
		
		JButton button = new JButton("连接");
		button.addActionListener(event->{
			this.setVisible(false);
			new ChatClient();
		});
		button.setBounds(163, 218, 117, 29);
		contentPane.add(button);
	}
}
