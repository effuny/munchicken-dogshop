package project.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	public ManagerDTO managerDto;

	public ProductDAO() {
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
	
	public ObservableList<Product> SelectAll() {
		String sql = "SELECT * FROM member";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<Product> products = FXCollections.observableArrayList();	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {								// member id , pw 변수 이름
				Product product =new Product(rs.getString("id"),rs.getString("pw"),rs.getString("phone"));
//				 rs.getString("pw")
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public int addMember(Product product) {
		
		int res = 0;
		try {
		String sql = "insert into member values(?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, product.getId());
		pstmt.setString(2, product.getPassword());
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
