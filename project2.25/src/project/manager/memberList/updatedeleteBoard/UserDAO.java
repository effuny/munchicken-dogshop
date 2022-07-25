package project.manager.memberList.updatedeleteBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet res;
	public UserDAO() {
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
	public ObservableList<UserProduct> SelectAll() {
		String sql = "SELECT * FROM member";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<UserProduct> userProducts= FXCollections.observableArrayList();	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {								// member id , pw 변수 이름
				UserProduct UserProduct =new UserProduct(rs.getString("id"),rs.getString("pw"),rs.getString("gender"),rs.getString("age"),rs.getString("countryCode")
						,rs.getString("phone"),rs.getString("petname1"),rs.getString("petsex1"),rs.getString("petage1"),rs.getString("petbreed1"));
//				 rs.getString("pw")
				userProducts.add(UserProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userProducts;
	}

	
	public int delete(UserProduct user) {
		String sql = "DELETE FROM member WHERE id=?";
		
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
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
