package oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
	
	static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";
	
	static final String ORACLE_CLOUD = "jdbc:oracle:thin:@yuns_high?TNS_ADMIN=D:/OracleCloud";
	
	public DbConnect()
	{
		try 
		{
			Class.forName(ORACLEDRIVER);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 연결 실패");
		}
	}
	
	public Connection getCloudOracle()
	{
		Connection conn = null;
		
		try 
		{
			conn = DriverManager.getConnection(ORACLE_CLOUD, "admin", "09Dhfkzmfdb18");
		} catch (SQLException e) {
			System.out.println("클라우드 연결 실패");
		}
		
		return conn;
	}

	public void dbClose(PreparedStatement pstmt, Connection conn)
	{
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} 
		catch (SQLException e) {}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} 
		catch (SQLException e) {}
	}

}
