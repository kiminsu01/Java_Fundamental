package java_20190807.unicast.client;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient {
	private String id;
	private String ip;
	private int port;
	private JFrame jframe;	
	private JTextArea jta;
	private TextField jtf;
	private JButton jbtn;
		
	public UnicastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		jframe = new JFrame("Unicast Chatting");
		JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jtf = new TextField(30);
		jbtn = new JButton("전송");
		
		JPanel j1= new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf,BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		
		jta = new JTextArea("ssss",30,30);
		jta.setEditable(false); // 에디팅 금지 
		
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(jtf,BorderLayout.SOUTH);
		jframe.pack();
		//jframe.setSize(500,300); // 크기 고정 설정
		jframe.setResizable(true);
		jframe.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("syh1011","127.0.0.1",5000);
		
	}
}
