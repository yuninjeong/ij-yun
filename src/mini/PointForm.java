package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import oracle.db.DbConnect;

public class PointForm extends JFrame {
	
	DbConnect db = new DbConnect();
	
	JLabel lblCheck;
	JButton btnSave, btnUse, btnNo;
	
	public PointForm()
	{
		super("HABBY POINT");
		this.setBounds(650, 300, 500, 400);
		this.getContentPane().setBackground(new Color(255, 100, 200));
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 처리 후 주석처리
		this.setVisible(true);
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		lblCheck = new JLabel("포인트를 어떻게 하실건가요?", JLabel.CENTER);
		lblCheck.setFont(new Font("나눔고딕", Font.BOLD, 25));
		lblCheck.setForeground(new Color(0, 10, 190));
		lblCheck.setBounds(0, 50, 500, 40);
		this.add(lblCheck);
		
		btnUse = new JButton("사용");
		btnUse.setFont(new Font("나눔고딕", Font.BOLD, 20));
		btnUse.setBackground(new Color(255, 40, 180));
		btnUse.setForeground(Color.white);
		btnUse.setBounds(70, 150, 100, 80);
		this.add(btnUse);
		btnUse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				UsePointForm upForm = new UsePointForm();
				
				PointForm.this.setVisible(false);
				
			}
		});
		
		btnSave = new JButton("적립");
		btnSave.setFont(new Font("나눔고딕", Font.BOLD, 20));
		btnSave.setBackground(new Color(0, 10, 190));
		btnSave.setForeground(new Color(255, 40, 180));
		btnSave.setBounds(200, 150, 100, 80);
		this.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SavePointForm spForm = new SavePointForm();
				
				PointForm.this.setVisible(false);
				
			}
		});
		
		btnNo = new JButton("건너뛰기");
		btnNo.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnNo.setBackground(Color.white);
		btnNo.setForeground(new Color(0, 10, 190));
		btnNo.setBounds(330, 150, 100, 80);
		this.add(btnNo);
		btnNo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				PointForm.this.setVisible(false);	
				
				PayForm payForm = new PayForm();
			}
		});
		
		/*
		 * 포인트 사용여부 예 - 결제금액 차감 - 결제
		 * 아니오 - 포인트 적립 - 결제
		 */
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new PointForm();

	}

}
