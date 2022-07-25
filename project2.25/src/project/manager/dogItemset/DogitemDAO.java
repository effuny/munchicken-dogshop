package project.manager.dogItemset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DogitemDAO {
	
	private Connection con;
	private	PreparedStatement ps;
	private ResultSet rs;
	
	DogitemProduct dip = new DogitemProduct();
	
	public DogitemDAO() {
		
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
		public ObservableList<DogitemDTO> showNum() {
			String sql = "SELECT * FROM dogshop";

			ObservableList<DogitemDTO> products = FXCollections.observableArrayList();   

			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					DogitemDTO dogitemDTO =new DogitemDTO(rs.getInt("num"), rs.getString("Name"), rs.getString("price"));
		            products.add(dogitemDTO);

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
			return products;	
		
	}
		
	public int insertItem(DogitemProduct dogitemProduct) {
		
		String sql = "INSERT INTO dogshop(num,name,price,infor,toyimg) VALUES(?,?,?,?,?)";
		
		ObservableList<DogitemProduct> dogitemProducts = FXCollections.observableArrayList();	
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, dogitemProduct.getNewnum());
			ps.setString(2, dogitemProduct.getNewname());
			ps.setString(3, dogitemProduct.getNewprice());
			ps.setString(4, dogitemProduct.getNewinfor());
			ps.setString(5, dogitemProduct.getNewtoyimg());
			dogitemProducts.add(dogitemProduct);
		
			result = ps.executeUpdate();
			
			
		
	}catch (SQLException e) {
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
		return result;
	}
	
	public DogitemProduct maxValue() {
		String sql = "SELECT MAX(num) as total FROM dogshop";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		if(rs.next()) {
			
			 dip.setNewnum(rs.getInt("total") + 1);
//			System.out.println("여긴 어때? : " + rs.getInt("num"));
//			return val;
//			 int r = dip.getNewnum();
			return dip; 
		}
		}catch (Exception e) {
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



