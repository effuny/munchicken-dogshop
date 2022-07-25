package project.findId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.reg.RegDTO;


public class FindIdDAO {
	
	private Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public RegDTO regDto;

	public FindIdDAO() {
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
	
	public RegDTO SelectId(String phone) {
		
		String sql = "SELECT * FROM member WHERE phone=?";
//		PreparedStatement ps;
//		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if(rs.next()) {
				RegDTO regDto = new RegDTO();
				
				regDto.setId(rs.getString("id"));
				regDto.setPhone(rs.getString("phone"));
				
				
				return regDto;
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
	
	public RegDTO SelectPw(String id) {
		
		String sql = "SELECT * FROM member WHERE id=?";
//		PreparedStatement ps;
//		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				RegDTO regDto = new RegDTO();
				
				regDto.setId(rs.getString("id"));
				regDto.setPw(rs.getString("pw"));
				regDto.setPhone(rs.getString("phone"));
				
				return regDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
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
