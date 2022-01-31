package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import oracle.db.DbConnect;


public class CartForm extends JFrame {
	
	DbConnect db = new DbConnect();
	BRJumunDB jumunDB = new BRJumunDB();
	CartDTO cartDto = new CartDTO();
	
	JLabel lblCart, lblTotal1, lblTotal2;
	JButton btnPay, btnCancel, btnClose;
	int allTotal = 0;
	
	DefaultTableModel tableModel;
	JTable table;
	String selectName;
	Vector<CartDTO> cartList;
	
	public CartForm()
	{
		super("��ٱ���");
		this.getContentPane().setBackground(new Color(0, 10, 190));
		this.setBounds(600, 200, 600, 600);
		this.setDesign();
		this.setVisible(false); 
	}

	public void setDesign() {

		this.setLayout(null);
		
		lblCart = new JLabel("<< ��ٱ��Ͽ� ��� ��ǰ�Դϴ� >>");
		lblCart.setFont(new Font("�������", Font.BOLD, 25));
		lblCart.setForeground(new Color(255, 100, 200));
		lblCart.setBounds(100, 30, 400, 30);
		this.add(lblCart);
		
		// ���̺� �߰�
		String[] title = {"�޴���", "������", "����", "�ܰ�", "�հ�"};
		
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(45, 100, 500, 200);
		this.add(js);
		
		this.cartCheck();
		
		if(tableModel.getRowCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "��ٱ��ϰ� ����־��!");
			this.setVisible(false);
		}
		
		lblTotal1 = new JLabel(">> �����ݾ� <<", JLabel.CENTER);
		lblTotal1.setFont(new Font("�������", Font.BOLD, 20));
		lblTotal1.setForeground(new Color(255, 100, 200));
		lblTotal1.setBounds(200, 330, 180, 30);
		this.add(lblTotal1);

		this.checkTotal();
		
		lblTotal2 = new JLabel(String.valueOf(allTotal) + "��", JLabel.CENTER);
		lblTotal2.setFont(new Font("�������", Font.BOLD, 25));
		lblTotal2.setBorder(new LineBorder(new Color(255, 100, 200), 2, true));
		lblTotal2.setForeground(Color.white);
		lblTotal2.setBounds(200, 370, 180, 40);
		this.add(lblTotal2);
		
		btnClose = new JButton("�ݱ�");
		btnClose.setFont(new Font("�������", Font.BOLD, 20));
		btnClose.setBackground(Color.white);
		btnClose.setForeground(new Color(255, 100, 200));
		btnClose.setBounds(50, 430, 150, 80);
		this.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				CartForm.this.setVisible(false);
			}
		});
		
		btnPay = new JButton("����ϱ�");
		btnPay.setFont(new Font("�������", Font.BOLD, 20));
		btnPay.setBackground(new Color(255, 100, 200));
		btnPay.setForeground(new Color(0, 10, 190));
		btnPay.setBounds(220, 430, 150, 80);
		this.add(btnPay);
		btnPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				CartForm.this.setVisible(false);
				
				PointForm pointForm = new PointForm();
				
			}
		});
		
		
		btnCancel = new JButton("�ֹ� ���");
		btnCancel.setFont(new Font("�������", Font.BOLD, 20));
		btnCancel.setBackground(new Color(0, 10, 190));
		btnCancel.setForeground(Color.white);
		btnCancel.setBounds(390, 430, 150, 80);
		this.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JOptionPane.showMessageDialog(CartForm.this, "��ٱ��ϸ� ���ϴ�!");
				
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
				
				
				CartForm.this.setVisible(false);
			}
		});
		
	
	}
	
	// �ֹ������� ��� �޼ҵ�
	public void cartCheck()
	{
		cartList = jumunDB.getCart();
		
		for(CartDTO cDto: cartList)
		{
			Vector<String> data = new Vector<String>();
			data.add(cDto.getCmenu());
			data.add(cDto.getCsize());
			data.add(String.valueOf(cDto.getCcount()));
			data.add(String.valueOf(cDto.getCprice()));
			data.add(String.valueOf(cDto.getCtotal()));
			
			tableModel.addRow(data);
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
	
	
	
	
	// �ּ�ó������(Ȯ�ο�޼ҵ�)
//	public static void main(String[] args)
//	{
//		new CartForm();
//	}


	

}
