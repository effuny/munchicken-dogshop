package project.manager.reserveList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.manager.Product;

public class ReserveDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	public ReserveDTO reserveDTO;

	public ReserveDAO() {
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
	
	public ObservableList<ReserveDTO> SelectAll() {
		String sql = "SELECT * FROM reserve";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<ReserveDTO> reserves = FXCollections.observableArrayList();	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {								// member id , pw 변수 이름
				ReserveDTO reserveDTO =new ReserveDTO(rs.getString("name"),rs.getString("service"),rs.getString("serviceDate"),rs.getString("serviceHour"),rs.getString("id"));
//				 rs.getString("pw")
				reserves.add(reserveDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserves;
	}

	public int addReserve(ReserveDTO reserveDto) {
		
		int res = 0;
		try {
		String sql = "insert into reserve values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, reserveDto.getName());
		pstmt.setString(2, reserveDto.getService());
		pstmt.setString(3, reserveDto.getServiceDate());
		pstmt.setString(4, reserveDto.getServiceHour());
		pstmt.setString(5, reserveDto.getId());
		res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public int delete(ReserveDTO reserveDto) {
		String sql = "DELETE FROM reserve WHERE name=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reserveDto.getName());
//			pstmt.setString(2, reserveDto.getName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) 
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
