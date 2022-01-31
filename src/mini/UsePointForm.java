package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oracle.db.DbConnect;

public class UsePointForm extends JFrame {
	
	DbConnect db = new DbConnect();
	
	JLabel lblTitle, lblNumber, lblNumber2, lblMember, lblUse, lblCheck, lblPay;
	JTextField tfNumber, tfUse;
	JButton btnEnter, btnEnter2, btnUse;
	
	int allPoint = 0;
	int allTotal = 0;
	
	public UsePointForm()
	{
		super("����Ʈ ���");
		this.setBounds(700, 150, 400, 750);
		this.getContentPane().setBackground(new Color(0, 10, 190));
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/*
	 * ����Ʈ ��ȸ�� ���� ��ȣ �Է�
	 * ����Ʈ ��ȸ 3000����Ʈ �̻� ���� �� ��� ����
	 * ������ ��� �Ұ� -����/�ǳʶٱ� �̵� 
	 * ���� - ����� ����Ʈ �Է�
	 * �ǳʶٱ�
	 * ���� - �����ݾ׿��� ���� - ������ư - ī�带 �־��ּ��� �˾� 3���� ������(�ǳ�?) 
	 */

	private void setDesign() {
		// TODO Auto-generated method stub
		
		this.setLayout(null);
		
		lblTitle = new JLabel("<< ����Ʈ ��� >>");
		lblTitle.setFont(new Font("�������", Font.BOLD, 25));
		lblTitle.setForeground(new Color(255, 40, 180));
		lblTitle.setBounds(90, 50, 400, 30);
		this.add(lblTitle);
		
		lblNumber = new JLabel("�ڵ��� ��ȣ�� �Է����ּ���!", JLabel.CENTER);
		lblNumber.setFont(new Font("�������", Font.BOLD, 25));
		lblNumber.setForeground(Color.white);
		lblNumber.setBounds(0, 100, 400, 30);
		this.add(lblNumber);
		
		tfNumber = new JTextField();
		tfNumber.setFont(new Font("�������", Font.BOLD, 20));
		tfNumber.setBounds(70, 150, 170, 50);
		this.add(tfNumber);
	
		btnEnter = new JButton("�Է�");
		btnEnter.setFont(new Font("�������", Font.BOLD, 15));
		btnEnter.setBackground(new Color(255, 40, 180));
		btnEnter.setForeground(new Color(0, 10, 190));
		btnEnter.setBounds(240, 150, 70, 50);
		this.add(btnEnter);
		
		PointDTO pointDto = new PointDTO();
		
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
								
				pointDto.setPnumber(tfNumber.getText());
				
				UsePointForm.this.checkAllPoint();
				UsePointForm.this.checkTotal();

				lblNumber2.setText(String.valueOf(allPoint));
				lblPay.setText(String.valueOf(allTotal));
			
			}
		});

		
		lblMember = new JLabel("��� ���� ����Ʈ(����: ��)", JLabel.CENTER);
		lblMember.setFont(new Font("�������", Font.BOLD, 20));
		lblMember.setForeground(new Color(255, 40, 180));
		lblMember.setBounds(0, 230, 400, 30);
		this.add(lblMember);
		
		lblNumber2 = new JLabel("", JLabel.CENTER);
		lblNumber2.setFont(new Font("�������", Font.BOLD, 30));
		lblNumber2.setForeground(Color.white);
		lblNumber2.setBounds(0, 270, 400, 30);
		this.add(lblNumber2);
		
		lblUse = new JLabel("����� ����Ʈ(����: ��)", JLabel.CENTER);
		lblUse.setFont(new Font("�������", Font.BOLD, 20));
		lblUse.setForeground(Color.white);
		lblUse.setBounds(0, 340, 400, 30);
		this.add(lblUse);
		
		tfUse = new JTextField("0");
		tfUse.setFont(new Font("�������", Font.BOLD, 20));
		tfUse.setBounds(70, 390, 170, 50);
		this.add(tfUse);
		tfUse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				tfUse.setText("");
			}
		});
		
		btnEnter2 = new JButton("�Է�");
		btnEnter2.setFont(new Font("�������", Font.BOLD, 15));
		btnEnter2.setBackground(new Color(255, 40, 180));
		btnEnter2.setForeground(new Color(0, 10, 190));
		btnEnter2.setBounds(240, 390, 70, 50);
		this.add(btnEnter2);
		btnEnter2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				pointDto.setUpoint(Integer.parseInt(tfUse.getText()));
				
				//System.out.println(pointDto.getUpoint());
				
				int a = allTotal;
				int b = pointDto.getUpoint();
				
				lblPay.setText(String.valueOf(a-b));

			}
		});
		
		lblCheck = new JLabel("���� ���� �ݾ�", JLabel.CENTER);
		lblCheck.setFont(new Font("�������", Font.BOLD, 20));
		lblCheck.setForeground(new Color(255, 40, 180));
		lblCheck.setBounds(0, 480, 400, 30);
		this.add(lblCheck);
		
		lblPay = new JLabel("", JLabel.CENTER);
		lblPay.setFont(new Font("�������", Font.BOLD, 30));
		lblPay.setForeground(Color.white);
		lblPay.setBounds(0, 520, 400, 30);
		this.add(lblPay);
		
		btnUse = new JButton("����");
		btnUse.setFont(new Font("�������", Font.BOLD, 20));
		btnUse.setBackground(new Color(255, 40, 180));
		btnUse.setForeground(new Color(0, 10, 190));
		btnUse.setBounds(120, 610, 150, 50);
		this.add(btnUse);
		btnUse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(tfUse.getText().isBlank())
				{
					JOptionPane.showMessageDialog(UsePointForm.this, "����� ����Ʈ�� �Է����ּ���!");
				}
				else if(tfUse.getText().equals("0"))
				{
					String[] buttons = {"���ƿ䢽", "�����ƿ�~"};
			
					JOptionPane.showOptionDialog(UsePointForm.this, "����Ʈ ����ȭ������ �̵��ұ��?", "HABBY POINT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "���ƿ䢽");
					int c = JOptionPane.showOptionDialog(UsePointForm.this, "����Ʈ ����ȭ������ �̵��ұ��?", "HABBY POINT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "���ƿ䢽");
					
					if(c == JOptionPane.NO_OPTION)
					{
						UsePointForm.this.setVisible(false);
						
						PayForm payForm = new PayForm();
					}
					else if(c == JOptionPane.YES_OPTION)
					{
						UsePointForm.this.setVisible(false);	
						
						SavePointForm spForm = new SavePointForm();
					}
				}
				else if(!tfUse.getText().isBlank() && !tfUse.getText().equals("0"))
				{
					UsePointForm.this.updatePoint();
					UsePointForm.this.setVisible(false);
					PayForm payForm = new PayForm();
				}
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new UsePointForm();
	}
	
	public void checkAllPoint()
	{
		
		Connection conn = db.getCloudOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select sum(tpoint) allPoint from point where pnumber = ?";
					
		try 
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tfNumber.getText());
			
			rs = pstmt.executeQuery();	
			
			while(rs.next())
			{
				allPoint = rs.getInt("allPoint");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally
		{
			db.dbClose(rs, pstmt, conn);
		}

	}
	
	
	public void checkTotal()
	{
		Connection conn = db.getCloudOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select sum(ctotal) allTotal from cart";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			
			while(rs.next())
			{
				allTotal = rs.getInt("allTotal");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			db.dbClose(rs, pstmt, conn);
		}

	}
	
	
	public void updatePoint()
	{
		Connection conn = db.getCloudOracle();
		PreparedStatement pstmt = null;
		
		String sql = "update point set tpoint = ? where pnumber = ?";
		
		int a = allPoint;
		int b = Integer.parseInt(tfUse.getText());
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (a-b));
			pstmt.setString(2, tfNumber.getText());
	
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			db.dbClose(pstmt, conn);
		}

	}
		

}
