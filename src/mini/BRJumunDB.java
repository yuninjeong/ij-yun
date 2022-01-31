package mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.DbConnect;

public class BRJumunDB {
	
	DbConnect db = new DbConnect();
	
	// 장바구니 데이터 가져오기
	public Vector<CartDTO> getCart()
	{
		String sql = "select cmenu, csize, ccount, cprice, ctotal from cart";
		
		Vector<CartDTO> list = new Vector<CartDTO>();
		
		Connection conn = db.getCloudOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				CartDTO cartDto = new CartDTO();
				
				cartDto.setCmenu(rs.getString("cmenu"));
				cartDto.setCsize(rs.getString("csize"));
				cartDto.setCcount(rs.getInt("ccount"));
				cartDto.setCprice(rs.getInt("cprice"));
				cartDto.setCtotal(rs.getInt("ctotal"));
				
				list.add(cartDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	
	

}
