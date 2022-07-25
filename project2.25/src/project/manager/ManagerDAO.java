package project.manager;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.reg.RegDTO;

public class ManagerDAO {

	private Connection con;
	public ManagerDTO managerDto;
	PreparedStatement ps;
	ResultSet rs;

	public ManagerDAO() {
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
	public int insert(){
		
		String sql = "INSERT INTO member(id,pw) VALUES(?,?)";
//		PreparedStatement ps;
		ObservableList<Product> products = FXCollections.observableArrayList();	
		int result = 0;
		try {
			ps = con.prepareStatement(sql);

			Product product = new Product();
			
			ps.setString(1, product.getId());
			ps.setString(2, product.getPassword());
			products.add(product);
			
			result = ps.executeUpdate();
			
//			while(rs.next()) {
//				Product product =new Product(rs.getString("id"), rs.getString("pw"));
//				products.add(product);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(ps != null)
					ps.close();
			
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return result;
		
	}

	public ManagerDTO SelectId(String id) {
		String sql = "SELECT * FROM manager WHERE id=?";
//		PreparedStatement ps;
//		ResultSet rs;
//		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				ManagerDTO managerDto = new ManagerDTO();

				managerDto.setId(rs.getString("id"));
				managerDto.setPw(rs.getString("pw"));

				return managerDto;
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
