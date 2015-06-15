import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;
import java.awt.event.*;
public class ChatClient extends Frame{
	//与服务器的连接
	Socket s = null; 
	//输入输出流
	DataOutputStream dos = null;
	DataInputStream din = null;
	private boolean connected = false;
	
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	
	Thread tRecv = new Thread(new RecveThread());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//客户端界面
		new ChatClient().launchFrame();

	}
	
	
	public void launchFrame(){
		setLocation(400,300);
		this.setSize(400, 300);
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		pack();//消除空白
		this.addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowClosing(WindowEvent arg0){
				disconnect();//disconnect with the server
				System.exit(0);
			}

		});
		tfTxt.addActionListener(new TFListener());
		setVisible(true);
		connect();
		
		tRecv.start();
	}
	
	//建立与服务器链接
	public void connect(){
		
		try {
			s = new Socket("127.0.0.1",11111);
			dos = new DataOutputStream(s.getOutputStream());
			din = new DataInputStream(s.getInputStream());
			connected = true;
		}catch (UnknownHostException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//断开与服务器连接
	public void disconnect(){
		try {
			dos.close();
			din.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			connected = false;
			
			tRecv.join();
				
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
		}
		*/
	}
	
	
	private class TFListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//trim()去掉前后空格
			String str = tfTxt.getText().trim();
			//获取输入内容
			String temps = taContent.getText();
			temps = temps+"\n"+str;
			temps = temps.trim();
//			taContent.setText(temps);
			tfTxt.setText("");
			try {
					dos.writeUTF(str);
					dos.flush();
					//dos.close();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	private class RecveThread implements Runnable {

		public void run() {

				try {
					while(connected){
						String str = din.readUTF();
						taContent.setText(taContent.getText()+str +'\n');
					}
				}catch (SocketException e){
					System.out.println("exit");
				}catch(EOFException e){
					System.out.println("exit");
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
}
