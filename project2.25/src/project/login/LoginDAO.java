package project.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
	private Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public LoginDAO() {
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
	
	public LoginDTO SelectId(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				LoginDTO loginDto = new LoginDTO();
				
				
				loginDto.setId(rs.getString("id"));
	            loginDto.setPw(rs.getString("pw"));
	            
				
				return loginDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

}
