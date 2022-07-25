package project.manager.memberList.addBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddDAO {
	private Connection con;
	PreparedStatement ps;
	private ResultSet rs;
	public AddDAO() {
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
	
	
	public int addInsert(AddDTO addDto) {
		
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, addDto.getId());
			ps.setString(2, addDto.getPw());
			ps.setString(3, addDto.getGender());
			ps.setString(4, addDto.getAge());
			ps.setString(5, addDto.getCountryCode());
			ps.setString(6, addDto.getPhone());
			ps.setString(7, addDto.getPetname1());
			ps.setString(8, addDto.getPetsex1());
			ps.setString(9, addDto.getPetage1());
			ps.setString(10, addDto.getPetbreed1());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public AddDTO AddSelectId(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				AddDTO addDto = new AddDTO();
				
				addDto.setId(rs.getString("id"));
				addDto.setPw(rs.getString("pw"));
				addDto.setGender(rs.getString("gender"));
				addDto.setAge(rs.getString("age"));
				
				
				
				return addDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	

}
