package mini;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import oracle.db.DbConnect;

public class BtnEvent extends JFrame implements ActionListener{
	
	DbConnect db = new DbConnect();
	Connection conn = db.getCloudOracle();
		
	CartDTO cartDto = new CartDTO();
	
	JLabel lblRPrice, lblPPrice, lblCount, lblSize;
	JButton btnMinus, btnPlus, btnCart, btnCancel;
	JRadioButton rbRegular, rbPint;
	JTextField tfCount;
	String cname, cimage;
	SelectImage sImage = new SelectImage();
	Image selectImage;
	
	Object choice1; // 내부클래스에서 값을 넘겨받을 변수는 외부에서 생성해주어야 함
	Object choice2;
	Object choice3;
	
	public BtnEvent(String cname, String cimege)
	{
		super("원하는만큼 담아주세요☆☆☆");
		this.getContentPane().setBackground(new Color(0, 10, 190));
		this.setBounds(700, 200, 400, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 메소드 호출하면 수정하기
		this.setDesign();
		this.setVisible(true);
		
		cartDto.setCmenu(cname);	
		cartDto.setCimage(cimege);
	}
	
	
	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		sImage.setBounds(120, 50, 150, 200);
		sImage.setVisible(true);
		this.add(sImage);

		lblSize = new JLabel("사이즈 선택");
		lblSize.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblSize.setForeground(new Color(255, 100, 200));
		lblSize.setBounds(140, 280, 400, 30);
		this.add(lblSize);
		
		rbRegular= new JRadioButton("싱글레귤러");
		rbRegular.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		rbRegular.setForeground(Color.white);
		rbRegular.setBounds(100, 310, 100, 30);
		rbRegular.setOpaque(false);
		this.add(rbRegular);
		
		lblRPrice = new JLabel("(3,200원)");
		lblRPrice.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblRPrice.setForeground(Color.white);
		lblRPrice.setBounds(120, 330, 400, 30);
		this.add(lblRPrice);
		
		rbPint= new JRadioButton("파인트");
		rbPint.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		rbPint.setForeground(Color.white);
		rbPint.setBounds(220, 310, 100, 30);
		rbPint.setOpaque(false);
		this.add(rbPint);
		
		lblPPrice = new JLabel("(8,200원)");
		lblPPrice.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblPPrice.setForeground(Color.white);
		lblPPrice.setBounds(220, 330, 400, 30);
		this.add(lblPPrice);
		
		ButtonGroup bgSize = new ButtonGroup();
		bgSize.add(rbRegular);
		bgSize.add(rbPint);
		
		lblCount = new JLabel("주문수량");
		lblCount.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblCount.setForeground(new Color(255, 100, 200));
		lblCount.setBounds(150, 380, 400, 30);
		this.add(lblCount);
		
		tfCount = new JTextField();
		tfCount.setText("1");
		tfCount.setFont(new Font("나눔고딕", Font.BOLD, 20));
		tfCount.setBounds(130, 420, 120, 30);
		this.add(tfCount);
		
		btnMinus = new JButton(new ImageIcon("D:\\bitjava0719\\javawork\\MiniProject\\menu_Image\\덜기.jpg"));
		btnMinus.setFont(new Font("나눔고딕", Font.BOLD, 10));
		btnMinus.setBackground(new Color(255, 100, 200));
		btnMinus.setForeground(Color.white);
		btnMinus.setBounds(100, 420, 30, 30);
		this.add(btnMinus);
		btnMinus.addActionListener(this);
		
		btnPlus = new JButton(new ImageIcon("D:\\bitjava0719\\javawork\\MiniProject\\menu_Image\\담기.jpg"));
		btnPlus.setFont(new Font("나눔고딕", Font.BOLD, 10));
		btnPlus.setBackground(new Color(255, 100, 200));
		btnPlus.setForeground(Color.white);
		btnPlus.setBounds(250, 420, 30, 30);
		this.add(btnPlus);
		btnPlus.addActionListener(this);
		
		btnCart = new JButton("장바구니 담기");
		btnCart.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnCart.setBackground(new Color(255, 100, 200));
		btnCart.setForeground(Color.white);
		btnCart.setBounds(30, 480, 150, 50);
		this.add(btnCart);
		
		//PintForm pintForm = new PintForm(cartDto);
		// pintForm에서 쓰는 carDto의 값은 BtnEvent 클래스에서 
		// 넘겨받는 값이기 때문에 호출할 때 파라미터 설정을 해줘야 한다
		
		btnCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(!rbRegular.isSelected() && !rbPint.isSelected())
				{
					JOptionPane.showMessageDialog(BtnEvent.this, "사이즈를 선택해주세요!");
					return;
				}

				
				Connection conn = db.getCloudOracle();
				PreparedStatement pstmt = null;
				
				String sql = "insert into cart values (?,?,?,?,?,?,?,?,?)";
				
				String cimage = cartDto.getCimage();
				String cname = cartDto.getCmenu();
				String csize = null;
				int cprice = 0;
				int ccount = Integer.parseInt(tfCount.getText());
				int ctotal = 0;
				
				if(rbRegular.isSelected())
				{
					csize = "레귤러"; // 싱글이냐 파인트냐에 따라 가격 달라짐
					cprice = 3200;
					choice1 = cartDto.getCmenu();
				}
				else if(rbPint.isSelected())
				{
					csize = "파인트";
					cprice = 8200;					
					choice1 = cartDto.getChoice1();
					choice2 = cartDto.getChoice2();
					choice3 = cartDto.getChoice3();				
					
					JOptionPane.showMessageDialog(BtnEvent.this, "파인트는 3가지 맛을 선택해주세요!");
					
					PintForm pintForm = new PintForm(cartDto);
					pintForm.cart();
					
				}

				
				
				ctotal = ccount*cprice;
				
				System.out.println(cname + csize + cprice + ccount + ctotal + choice1 + choice2 + choice3);
				
				
				cartDto.setCmenu(cname);
				cartDto.setCsize(csize);
				cartDto.setCcount(ccount);
				cartDto.setCprice(cprice);
				cartDto.setCtotal(ctotal);
				cartDto.setChoice1(choice1);
				cartDto.setChoice2(choice2);
				cartDto.setChoice3(choice3);
				
				try 
				{
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, cimage);
					pstmt.setString(2, cname);
					pstmt.setString(3, csize);
					pstmt.setInt(4, ccount);
					pstmt.setInt(5, cprice);
					pstmt.setInt(6, ctotal);
					pstmt.setObject(7, choice1);
					pstmt.setObject(8, choice2);
					pstmt.setObject(9, choice3);
					
					pstmt.execute();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					db.dbClose(pstmt, conn);
				}
				
				BtnEvent.this.setVisible(false);
			}
		});
		
		btnCancel = new JButton("선택 취소");
		btnCancel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnCancel.setBackground(new Color(0, 10, 190));
		btnCancel.setForeground(new Color(255, 100, 200));
		btnCancel.setBounds(210, 480, 150, 50);
		this.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub		
				
				BtnEvent.this.setVisible(false);
			}
		});

	}


	class SelectImage extends Canvas
	{
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			String sImageName = cartDto.getCimage();
			selectImage = new ImageIcon(sImageName).getImage();
			
			g.drawImage(selectImage, 0, 0, 150, 200, this);		
		}
	}
	
//	public static void main(String[] args)
//	{
//		new BtnEvent();
//	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource();
		
		if(ob == btnMinus)
		{
			int m = Integer.parseInt(tfCount.getText());
			m--;
			
			if(m <= 0)
			{
				JOptionPane.showMessageDialog(BtnEvent.this, "1개 이상 담아주세요~!");
				return;
			}
			
			tfCount.setText(String.valueOf(m));
		}
		else if(ob == btnPlus)
		{
			int p = Integer.parseInt(tfCount.getText());
			p++;
			tfCount.setText(String.valueOf(p));
		}
		
	}

}
