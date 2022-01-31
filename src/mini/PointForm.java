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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // �ݱ� ó�� �� �ּ�ó��
		this.setVisible(true);
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		lblCheck = new JLabel("����Ʈ�� ��� �Ͻǰǰ���?", JLabel.CENTER);
		lblCheck.setFont(new Font("�������", Font.BOLD, 25));
		lblCheck.setForeground(new Color(0, 10, 190));
		lblCheck.setBounds(0, 50, 500, 40);
		this.add(lblCheck);
		
		btnUse = new JButton("���");
		btnUse.setFont(new Font("�������", Font.BOLD, 20));
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
		
		btnSave = new JButton("����");
		btnSave.setFont(new Font("�������", Font.BOLD, 20));
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
		
		btnNo = new JButton("�ǳʶٱ�");
		btnNo.setFont(new Font("�������", Font.BOLD, 15));
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
		 * ����Ʈ ��뿩�� �� - �����ݾ� ���� - ����
		 * �ƴϿ� - ����Ʈ ���� - ����
		 */
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new PointForm();

	}

}
