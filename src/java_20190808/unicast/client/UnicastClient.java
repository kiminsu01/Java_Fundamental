package java_20190808.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener { //ActionListener 이벤트 대기
	private String id;
	private String ip;
	private int port;
	private JFrame jframe;	
	private JTextArea jta;
	private TextField jtf;
	private JButton jbtn;
		
	public UnicastClient(String id, String ip, int port) { // ip는 서버ip
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		jframe = new JFrame("Unicast Chatting");
		/*****************중앙 시작************************************/
		jta = new JTextArea("",20,50);
		jta.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 텍스트창 생성
		jta.setBackground(new Color(80,60,80)); //RGB 색상 지정
		/******************중앙 끝************************************/
		
		/*****************하단 시작************************************/
		jtf = new TextField(30);
		jbtn = new JButton("SEND"); //버튼 생성
		jbtn.setBackground(Color.YELLOW); // 버튼에 색깔넣기
		
		JPanel j1= new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf,BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		/*****************하단 끝************************************/
		
		/***************상단 시작************************************/
		JPanel j2 =  new JPanel();
		JLabel jl1 = new JLabel("User ID : ["+id+"]");
		j2.setBackground(new Color(204,153,255)); //RGB 색상 지정
		//j2.setBackground(Color.GREEN);
		JLabel jl2 = new JLabel("Server Ip : "+id);
		j2.setLayout(new BorderLayout());
		j2.add(jl1, BorderLayout.CENTER);
		j2.add(jl2, BorderLayout.EAST);
		/****************상단 끝************************************/
		
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(j1,BorderLayout.SOUTH);
		jframe.add(j2,BorderLayout.NORTH);
		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);
		
		//jta = new JTextArea("ssss",30,30);
		//jframe.add(jsp,BorderLayout.CENTER);
		//jframe.add(jtf,BorderLayout.SOUTH);
		//jframe.pack();
		
		//jframe.setSize(500,300); // 크기 고정 설정
		
		
		// X(종료)를 눌러 프로그램을 종료하기 위한 코드 
		jframe.addWindowListener(new WindowAdapter() {  //생성자
			public void windowClosing(WindowEvent e) {
				//System.exit(0);	// ;는 문장이 끝났다는 의미
			}
			public void windowOpened(WindowEvent e) {
					jtf.requestFocus();	
			}
			
		});
		// 이벤트 등록
		jbtn.addActionListener(this);
		jtf.addActionListener(this);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("action...."); 이벤트 발생시 출력
		Object obj = e.getSource();
		if(obj == jtf) {
			//System.out.println("action jtf..."); 
			//텍스트 필드 가져오기 
			String message = jtf.getText();
			if(message.trim().length()==0) {
				JOptionPane.showMessageDialog(jframe,"try again", "Warning", JOptionPane.ERROR_MESSAGE);
				//JOptionPane.ERROR_MESSAGE => x표 아이콘 화면출력
			}else {
				//텍스트 에어리어에 추가하기 
				jta.append(id+ ":"+ message+"\n"); //입력자 id 출력, 줄바꾸기
				//텍스트 필드에 입력된 값 없애기
			}
			jtf.setText(""); // 작은 if문 밖으로...
			
		}else if(obj == jbtn) {
			//텍스트 필드 가져오기 
			String message = jtf.getText();
			if(message.trim().length()==0) {
				JOptionPane.showMessageDialog(jframe,"try again", "Warning", JOptionPane.ERROR_MESSAGE);
				//JOptionPane.ERROR_MESSAGE => x표 아이콘 화면출력
			}else {
				//텍스트 에어리어에 추가하기
				jta.append(id+ " : " + message+"\n");
				//텍스트 필드에 입력된 값 없애기
								
			}
			jtf.setText(""); // 작은 if문 밖으로...
			jtf.requestFocus();
		}
	}	
}