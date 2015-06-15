import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginAccountTextField;
	private JPasswordField loginPasswordField;
	static Main frame = new Main();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public Main() {
		this.setTitle("WW -- 微型聊天系统");	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWW = new JLabel("W W");
		lblWW.setHorizontalAlignment(SwingConstants.CENTER);
		lblWW.setBounds(128, 6, 200, 50);
		contentPane.add(lblWW);
		
		JLabel loginAccountLlabel = new JLabel("账号");
		loginAccountLlabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginAccountLlabel.setBounds(75, 62, 95, 50);
		contentPane.add(loginAccountLlabel);
		
		JLabel loginPasswordLabel = new JLabel("密码");
		loginPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginPasswordLabel.setBounds(75, 118, 95, 50);
		contentPane.add(loginPasswordLabel);
		
		loginAccountTextField = new JTextField();
		loginAccountTextField.setColumns(10);
		loginAccountTextField.setBounds(222, 73, 134, 28);
		contentPane.add(loginAccountTextField);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(222, 129, 134, 28);
		contentPane.add(loginPasswordField);
		
		//登陆按钮
		JButton loginButton = new JButton("登陆");
		loginButton.setBounds(100, 204, 117, 29);
		contentPane.add(loginButton);
		loginButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = "";
				String loginPassword = new String(loginPasswordField.getPassword());//输入的密码
				String password = null;// 从数据库中得到的密码
				
				username = loginAccountTextField.getText(); //获取输入的用户名
				//获取输入的密码

				//连接数据库，从数据库获取密码，并验证登陆
				MongodbLink ml =new MongodbLink();
				password = ml.getPassword(username);
								    
//				System.out.println(loginPassword);
//				System.out.println(password);
				if (loginPassword.compareTo(password)==0){
					//System.out.println(3);
					frame.setVisible(false);
//					frame.dispose();
					new MyFriendList(username);					
				}
			}			
		});
		
		
		//注册按钮
		JButton loginRegisterButton = new JButton("注册");
		loginRegisterButton.setBounds(239, 204, 117, 29);
		contentPane.add(loginRegisterButton);
		loginRegisterButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(1);
				if(e.getSource()==loginRegisterButton){
					frame.setVisible(false);
					frame.dispose();
					new RegisterDemo();
				}
			}
		});
		
	}

	
}
