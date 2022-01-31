package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import oracle.db.DbConnect;

public class PayForm extends JFrame {
	
	DbConnect db = new DbConnect();
	
	JLabel lblCard;
	JButton btnCard;
	
	public PayForm()
	{
		super("결제하기");
		this.setBounds(750, 300, 300, 300);
		this.getContentPane().setBackground(new Color(0, 10, 190));
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		lblCard = new JLabel("카드를 넣어주세요!");
		lblCard.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lblCard.setForeground(Color.white);
		lblCard.setBounds(60, 70, 200, 30);
		this.add(lblCard);
		
		btnCard = new JButton("카드 삽입");
		btnCard.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnCard.setBackground(new Color(255, 100, 200));
		btnCard.setForeground(new Color(0, 10, 190));
		btnCard.setBounds(95, 130, 100, 50);
		this.add(btnCard);
		btnCard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JOptionPane.showMessageDialog(PayForm.this, "주문이 완료되었습니다!");
				
				Connection conn = db.getCloudOracle();
				PreparedStatement pstmt = null;
				
				String sql = "delete from cart";
				
				try 
				{
					pstmt = conn.prepareStatement(sql);
					pstmt.execute();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					db.dbClose(pstmt, conn);
				}
				
				PayForm.this.setVisible(false);
				
				//System.exit(0);
				
			}
		});
		
	}

	// 확인용
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new PayForm();

	}

}
