import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;



public class User extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchTextField;


	
	public User(String username) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//显示用户头像
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Volumes/代码库/Java1/WW/images/users1.jpg"));
		lblNewLabel.setBounds(0, 0, 50, 50);
		contentPane.add(lblNewLabel);
		//显示用户名
		JLabel userName = new JLabel("");
		userName.setBounds(50, 0, 61, 50);
		contentPane.add(userName);
		userName.setText(username);
		//好友搜索栏
		searchTextField = new JTextField();
		searchTextField.setBounds(0, 56, 225, 28);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		//好友搜索按钮
		JButton searchButton = new JButton("搜索");
		searchButton.setBounds(227, 55, 67, 29);
		contentPane.add(searchButton);
		
		//一个panel用于盛放“我的好友”按钮
		JPanel friendPanel = new JPanel(new BorderLayout());
		//我的好友按钮
		JButton friendButton = new JButton("我的好友");
		friendPanel.add(friendButton);
		friendButton.addActionListener(event -> {
				
		});
		
		contentPane.add(friendPanel);
		
		//用于盛放列表
		JPanel friendList = new JPanel(new GridLayout(20, 1, 4, 4));
		friendList.setBounds(0, 88, 300, 314);
		//底部的两个按钮
		JPanel buttom = new JPanel(new GridLayout(2, 1));
		buttom.setBounds(0, 406, 300, 72);
		contentPane.add(buttom);
		
		
			
				
		//陌生人按钮
		JButton stranger = new JButton("陌生人");
		//黑名单
		JButton limited = new JButton("黑名单");
		buttom.add(stranger);
		buttom.add(limited);
		
		JScrollPane friendScroll = new JScrollPane(friendList);
		
		JLabel [] friends = new JLabel[20];
		for (int i=0;i<friends.length;i++){
			friends[i] = new JLabel(i+1+"",new ImageIcon("images/users2.jpg"),JLabel.LEFT);
			friendList.add(friends[i],"North");
			friendList.add(friendScroll,"Center");
			friendList.add(buttom,"South");
			
			this.add(friendList);
			
			}
		
		
		
		
		
		
//		//Lambda表达式
//		searchButton.addActionListener(event -> {
//			String user = null;
//			user = searchTextField.getText();
//			MongodbLink a = new MongodbLink();
//			DBObject result= a.searchUser(username);
//			
//		});
	}
}

