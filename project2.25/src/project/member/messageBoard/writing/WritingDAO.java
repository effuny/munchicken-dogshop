package project.member.messageBoard.writing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class WritingDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	public WritingDTO writDto;
	
	
	public WritingDAO() {
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
	
	public WritingDTO SelectTitle(String title) {
		String sql = "SELECT * FROM review WHERE title=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			if(rs.next()) {
				WritingDTO writDto = new WritingDTO();
				
				writDto.setTitle(rs.getString("title"));
				writDto.setId(rs.getString("id"));
				writDto.setTreatment(rs.getString("treatment"));
				writDto.setContent(rs.getString("content"));
				
				
				
				
				return writDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int insert(WritingDTO writDto) {
		String sql = "INSERT INTO review VALUES(?,?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, writDto.getTitle());
			ps.setString(2, writDto.getId());
			ps.setString(3, writDto.getTreatment());
			ps.setString(4, writDto.getContent());
			
			result = ps.executeUpdate();
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
	
		return result;
	}
	
	public int update(WritingDTO writDto) {
		String sql = "UPDATE review SET id =?, treatment=?, content=? WHERE title=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, writDto.getId());
			ps.setString(2, writDto.getTreatment());
			ps.setString(3, writDto.getContent());
			ps.setString(4, writDto.getTitle());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) 
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	

}
