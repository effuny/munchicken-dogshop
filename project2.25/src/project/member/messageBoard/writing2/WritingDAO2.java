package project.member.messageBoard.writing2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.member.messageBoard.writing.WritingDTO;

public class WritingDAO2 {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private WritingDTO2 writDto2;
	
	
	public WritingDAO2() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String password = "oracle";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public WritingDTO2 SelectTitle(String title) {
		String sql = "SELECT * FROM review2 WHERE title=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			if(rs.next()) {
				WritingDTO2 writDto2 = new WritingDTO2();
				
				writDto2.setTitle(rs.getString("title"));
				writDto2.setProduct(rs.getString("product"));
				writDto2.setContent(rs.getString("content"));
				writDto2.setImg(rs.getString("img"));
				
				
				
				return writDto2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(WritingDTO2 writDto2) {
		String sql = "INSERT INTO review2 VALUES(?,?,?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, writDto2.getTitle());
			ps.setString(2, writDto2.getId());
			ps.setString(3, writDto2.getProduct());
			ps.setString(4, writDto2.getContent());
			ps.setString(5, writDto2.getImg());
			
			result = ps.executeUpdate();
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
	
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
