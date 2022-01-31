package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oracle.db.DbConnect;

public class SavePointForm extends JFrame {
	
	DbConnect db = new DbConnect();
	PointDTO pointDto = new PointDTO();
	
	JLabel lblTitle, lblNumber, lblNumber2, lblMember;
	JTextField tfNumber;
	JButton btnEnter;
	
	int point;
	
	public SavePointForm()
	{
		super("포인트 적립");
		this.setBounds(700, 250, 400, 400);
		this.getContentPane().setBackground(new Color(0, 10, 190));
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		lblTitle = new JLabel("<< 포인트 적립 >>");
		lblTitle.setFont(new Font("나눔고딕", Font.BOLD, 25));
		lblTitle.setForeground(new Color(255, 40, 180));
		lblTitle.setBounds(90, 50, 400, 30);
		this.add(lblTitle);
		
		lblNumber = new JLabel("핸드폰 번호를 입력해주세요!", JLabel.CENTER);
		lblNumber.setFont(new Font("나눔고딕", Font.BOLD, 25));
		lblNumber.setForeground(Color.white);
		lblNumber.setBounds(0, 100, 400, 30);
		this.add(lblNumber);
		
		tfNumber = new JTextField("");
		tfNumber.setFont(new Font("나눔고딕", Font.BOLD, 20));
		tfNumber.setBounds(70, 150, 170, 50);
		this.add(tfNumber);
		tfNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				tfNumber.setText("");
			}
		});
		
		CartForm cartForm = new CartForm();
		point = cartForm.allTotal*5/100;
		
		btnEnter = new JButton("입력");
		btnEnter.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnEnter.setBackground(new Color(255, 40, 180));
		btnEnter.setForeground(new Color(0, 10, 190));
		btnEnter.setBounds(240, 150, 70, 50);
		this.add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				pointDto.setPnumber(tfNumber.getText());	
				
				SavePointForm.this.checkAllPoint();
				
				//lblNumber2.setText(String.valueOf(point));
				
				JOptionPane.showMessageDialog(SavePointForm.this, "포인트가 적립됐어요~! '▽'//");
				
				SavePointForm.this.setVisible(false);	
				
				PayForm payForm = new PayForm();
			}
		});
		
		//this.checkAllPoint();
		
		lblMember = new JLabel("적립 예정 포인트(단위: 원)", JLabel.CENTER);
		lblMember.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblMember.setForeground(new Color(255, 40, 180));
		lblMember.setBounds(0, 230, 400, 30);
		this.add(lblMember);

		lblNumber2 = new JLabel(String.valueOf(point), JLabel.CENTER);
		lblNumber2.setFont(new Font("나눔고딕", Font.BOLD, 30));
		lblNumber2.setForeground(Color.white);
		lblNumber2.setBounds(0, 270, 400, 30);
		this.add(lblNumber2);
		
	}

	
	public void checkAllPoint()
	{		
		CartForm cartForm = new CartForm();	
		
		point = cartForm.allTotal*5/100;
//		System.out.println(point);
//		System.out.println(pointDto.getPnumber());
		
		Connection conn = db.getCloudOracle();
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into point (tpoint, pnumber) values (?,?)";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, point);
			pstmt.setString(2, pointDto.getPnumber());
			
			pstmt.execute();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally
		{
			db.dbClose(pstmt, conn);
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SavePointForm();

	}


}
