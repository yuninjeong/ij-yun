package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import oracle.db.DbConnect;

public class BRJumunMain extends JFrame implements ActionListener{

	DbConnect db = new DbConnect();
	CartForm cf;
	
	JLabel lblWelcome, lblOrder;
	JButton[] btn = new JButton[10];
	JButton btnCart, btnPay;
	BtnEvent btnEvent;

	//menu_Image/2.jpg
	String[][] menu = {{"그린티", "menu_Image/1.jpg"},
			{"뉴욕치즈케이크", "menu_Image/2.jpg"},
			{"레드라즈베리소르베", "menu_Image/3.jpg"},
			{"민트초콜릿칩", "menu_Image/4.jpg"},
			{"사랑에빠진딸기", "menu_Image/5.jpg"},
			{"슈팅스타", "menu_Image/6.jpg"},
			{"아몬드봉봉", "menu_Image/7.jpg"},
			{"엄마는외계인", "menu_Image/8.jpg"},
			{"31요거트", "menu_Image/9.jpg"},
			{"초콜릿", "menu_Image/10.jpg"}};
	

	public BRJumunMain()
	{
		super("♡♡배스킹라빙스에 오신 것을 환영합니다♡♡");
		this.setBounds(400, 100, 1000, 900);
		this.getContentPane().setBackground(new Color(255, 100, 200));
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}



	private void setDesign() {

		this.setLayout(null);

		lblWelcome = new JLabel("☆배스킹라빙스에 오신 것을 환영합니다☆", JLabel.CENTER);
		lblWelcome.setFont(new Font("나눔고딕", Font.BOLD, 35));
		lblWelcome.setForeground(new Color(0, 10, 190));
		lblWelcome.setBounds(0, 50, 1000, 40);
		this.add(lblWelcome);

		lblOrder = new JLabel("주문하실 메뉴를 선택해주세요!", JLabel.CENTER);
		lblOrder.setFont(new Font("나눔고딕", Font.BOLD, 30));
		lblOrder.setForeground(new Color(255, 255, 255));
		lblOrder.setBounds(0, 100, 1000, 40);
		this.add(lblOrder);

		//////////////// 버튼 나열 ///////////////////
		int x = 100;
		int y = 200;
		int w = 150;
		int h = 250;

		for(int j=0; j<btn.length; j++)
		{	

			btn[j] = new JButton(new ImageIcon(menu[j][1]));
			btn[j].setBounds(x, y, w, h);
			this.add(btn[j]);
			btn[j].addActionListener(this);
			
			x+=160;		
			
			if((j+1)%5==0)
			{
				x=100;
				y+=270;
			}

		}
		///////////////////////////////////////////////
		
		btnCart = new JButton("장바구니 보기");
		btnCart.setFont(new Font("나눔고딕", Font.BOLD, 20));
		btnCart.setBackground(new Color(0, 10, 190));
		btnCart.setForeground(new Color(255, 40, 180));
		btnCart.setBounds(390, 750, 200, 80);
		this.add(btnCart);
		btnCart.addActionListener(this);
		
//		btnPay = new JButton("계산하기");
//		btnPay.setFont(new Font("나눔고딕", Font.BOLD, 20));
//		btnPay.setBackground(new Color(0, 10, 190));
//		btnPay.setForeground(Color.white);
//		btnPay.setBounds(520, 750, 200, 80);
		
//		this.add(btnPay);
//		btnPay.addActionListener(this);
		

	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BRJumunMain();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource();

		if (ob == btnCart) {
			CartForm cf = new CartForm();
			cf.setVisible(true);
		}
		
		for (int i = 0; i < 10; i++) {
			if (ob == btn[i]) {
				new BtnEvent(menu[i][0], menu[i][1]);
				break;
			}
		}
//			if (ob == btn[0]) {
//				String cname = "그린티";
//				String cimage = "menu_Image/1.jpg";
//				new BtnEvent(cname, menu[0]);
//			} else if (ob == btn[1]) {
//				String cname = "뉴욕치즈케이크";
//				String cimage = "menu_Image/2.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[2]) {
//				String cname = "레드라즈베리소르베";
//				String cimage = "menu_Image/3.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[3]) {
//				String cname = "민트초콜릿칩";
//				String cimage = "menu_Image/4.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[4]) {
//				String cname = "사랑에빠진딸기";
//				String cimage = "menu_Image/5.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[5]) {
//				String cname = "슈팅스타";
//				String cimage = "menu_Image/6.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[6]) {
//				String cname = "아몬드봉봉";
//				String cimage = "menu_Image/7.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[7]) {
//				String cname = "엄마는외계인";
//				String cimage = "menu_Image/8.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[8]) {
//				String cname = "31요거트";
//				String cimage = "menu_Image/9.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btn[9]) {
//				String cname = "초콜릿";
//				String cimage = "menu_Image/10.jpg";
//				new BtnEvent(cname, cimage);
//			} else if (ob == btnCart) {
//				CartForm cf = new CartForm();
//				cf.setVisible(true);
//			}
	}

}
