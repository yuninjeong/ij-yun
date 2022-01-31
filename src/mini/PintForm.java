package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PintForm extends JFrame {
	
	CartDTO cartDto;
	// BtnEvent의 CartDTO 생성자 값을 받아올 것이기 때문에
	// pintForm에서는 new 생성할 필요 없다.
	
	String[] menu = {"","그린티","뉴욕치즈케이크","레드 라즈베리 소르베","민트초콜릿칩","사랑에 빠진 딸기","슈팅스타",
				"아몬드 봉봉", "엄마는 외계인", "31요거트", "초콜릿"};
	
	Object c1, c2, c3;
	boolean b1 = false;
	boolean b2 = false;
	boolean b3 = false;
	
	JComboBox<String> cbMenu1, cbMenu2, cbMenu3;
	JLabel lblTitle, lblChoice1, lblChoice2, lblChoice3;
	JButton btnCart;
	
	// 위에서 cartDTO 선언만 해주고 대신 호출될 때 파라미터 받게 설정
	public PintForm(CartDTO cartDto)
	{
		super("파인트 맛 선택");
		
		this.cartDto = cartDto;
		// 여기에서 쓰는 cartDto 는 파라미터 값을 받아온 cartDto 라는 뜻
		
		this.setBounds(700, 250, 400, 480);
		this.getContentPane().setBackground(new Color(0, 10, 190));
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 처리 후 주석처리
		this.setVisible(true);
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		lblTitle = new JLabel("☆파인트에 담을 맛을 선택해주세요☆");
		lblTitle.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblTitle.setForeground(new Color(255, 40, 180));
		lblTitle.setBounds(30, 50, 400, 30);
		this.add(lblTitle);
		
		lblChoice1 = new JLabel("선택 1");
		lblChoice1.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblChoice1.setForeground(Color.white);
		lblChoice1.setBounds(70, 120, 100, 30);
		this.add(lblChoice1);
		
		cbMenu1 = new JComboBox<String>(menu);
		cbMenu1.setBounds(150, 120, 150, 30);
		this.add(cbMenu1);
		cbMenu1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				b1 = true;
				
				if(cbMenu1.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(PintForm.this, "맛을 선택해주세요!");
				}
				
				c1 = cbMenu1.getSelectedItem();
			}
		});

		
		lblChoice2 = new JLabel("선택 2");
		lblChoice2.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblChoice2.setForeground(Color.white);
		lblChoice2.setBounds(70, 170, 100, 30);
		this.add(lblChoice2);
		
		cbMenu2 = new JComboBox<String>(menu);
		cbMenu2.setBounds(150, 170, 150, 30);
		this.add(cbMenu2);
		cbMenu2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				b2 = true;
				
				if(cbMenu2.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(PintForm.this, "맛을 선택해주세요!");
				}
				
				c2 = cbMenu2.getSelectedItem();
			}
		});
		
		lblChoice3 = new JLabel("선택 3");
		lblChoice3.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblChoice3.setForeground(Color.white);
		lblChoice3.setBounds(70, 220, 100, 30);
		this.add(lblChoice3);
		
		cbMenu3 = new JComboBox<String>(menu);
		cbMenu3.setBounds(150, 220, 150, 30);
		this.add(cbMenu3);
		cbMenu3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				b3 = true;
				
				if(cbMenu3.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(PintForm.this, "맛을 선택해주세요!");
				}
				
				c3 = cbMenu3.getSelectedItem();
			}
		});
		
		btnCart = new JButton("선택 완료");
		btnCart.setFont(new Font("나눔고딕", Font.BOLD, 20));
		btnCart.setBackground(new Color(255, 40, 180));
		btnCart.setForeground(new Color(0, 10, 190));
		btnCart.setBounds(120, 300, 150, 80);
		this.add(btnCart);
		btnCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(!b1 || !b2 || !b3 || cbMenu1.getSelectedIndex()==0 
						|| cbMenu2.getSelectedIndex()==0 || cbMenu3.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(PintForm.this, "맛을 모두 선택해주세요!");
				}
				else
				{
					//PintForm.this.cart();
					
					JOptionPane.showMessageDialog(PintForm.this, "장바구니에 담았어요!");
					
					PintForm.this.setVisible(false);
				}
				
			}
		});
		
	}
	
	public void cart()
	{
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		cartDto.setChoice1(c1);
		cartDto.setChoice2(c2);
		cartDto.setChoice3(c3);
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		new PintForm(new CartDTO());
//
//	}

}
