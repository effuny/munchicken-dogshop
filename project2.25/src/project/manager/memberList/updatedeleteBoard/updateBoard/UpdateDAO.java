package project.manager.memberList.updatedeleteBoard.updateBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.manager.memberList.addBoard.AddDTO;
import project.manager.memberList.updatedeleteBoard.UserProduct;

public class UpdateDAO {
	
	private Connection con;
	PreparedStatement ps;
	private ResultSet rs;
	public UpdateDAO() {
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
	
	
	public int updateUpdate(UserProduct userPro) {
		
		String sql = "update member set id=?,pw=?,gender=?,age=?,"
				+ "countryCode=?,phone=?,petname1=?,petsex1=?,petage1=?,petbreed1=? "
				+ "where id=?";
		PreparedStatement ps;
		int result = 0;
		try {
			
			
			ps = con.prepareStatement(sql);
			ps.setString(1, userPro.getId());
			ps.setString(2, userPro.getPassword());
			ps.setString(3, userPro.getGender());
			ps.setString(4, userPro.getAge());
			ps.setString(5, userPro.getCountryCode());
			ps.setString(6, userPro.getNumber());
			ps.setString(7, userPro.getDogName());
			ps.setString(8, userPro.getSex());
			ps.setString(9, userPro.getDogAge());
			ps.setString(10, userPro.getBreed());
			ps.setString(11, userPro.getId());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public UpdateDTO UpdateSelectId(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				UpdateDTO updateDto = new UpdateDTO();
				
				updateDto.setId(rs.getString("id"));
				updateDto.setPw(rs.getString("pw"));
				updateDto.setGender(rs.getString("gender"));
				updateDto.setAge(rs.getString("age"));
				
				
				
				return updateDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
