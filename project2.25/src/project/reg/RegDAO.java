package project.reg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class RegDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public RegDAO() {
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
	
	
	public RegDTO SelectId(String id) {
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
				regDto.setGender(rs.getString("gender"));
				regDto.setAge(rs.getString("age"));
				
				
				
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
	
	public  int insert(RegDTO  regDto) {
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, regDto.getId());
			ps.setString(2, regDto.getPw());
			ps.setString(3, regDto.getGender());
			ps.setString(4, regDto.getAge());
			ps.setString(5, regDto.getCountryCode());
			ps.setString(6, regDto.getPhone());
			ps.setString(7, regDto.getPetname1());
			ps.setString(8, regDto.getPetsex1());
			ps.setString(9, regDto.getPetage1());
			ps.setString(10, regDto.getPetbreed1());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
//				if(rs != null)
//					rs.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int update(RegDTO regDto) {
	      String sql = "UPDATE member SET pw =?, gender=?, age=?, phone=?, petname1=?, petsex1=?, petage1=?, petbreed1=?, countrycode=? WHERE id=?";
	      int result = 0;
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, regDto.getPw());
	         ps.setString(2, regDto.getGender());
	         ps.setString(3, regDto.getAge());
	         ps.setString(4, regDto.getPhone());
	         ps.setString(5, regDto.getPetname1());
	         ps.setString(6, regDto.getPetsex1());
	         ps.setString(7, regDto.getPetage1());
	         ps.setString(8, regDto.getPetbreed1());
	         ps.setString(9, regDto.getCountryCode());
	         ps.setString(10, regDto.getId());
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
