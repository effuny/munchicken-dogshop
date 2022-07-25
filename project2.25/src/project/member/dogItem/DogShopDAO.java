package project.member.dogItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.common.CommonService;
import project.login.LoginController;
import project.main.Controller;
import project.member.MemberController;
import project.member.dogItem.bucket.BucketDTO;

public class DogShopDAO {
	
	private Connection con;
	private Controller controller;
	
	
	
	
	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	public DogShopDAO() {
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
	public ObservableList<DogShopProduct> selectNum() {
		String sql = "SELECT * FROM dogshop";

		PreparedStatement ps;
		ResultSet rs;
		ObservableList<DogShopProduct> products = FXCollections.observableArrayList();   

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DogShopProduct product =new DogShopProduct(rs.getInt("num"), rs.getString("Name"), rs.getString("price"), rs.getString("infor") , rs.getString("toyimg"));
	            products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public int addBucket(BucketDTO bucketDto) {
		String sql = "INSERT INTO bucket VALUES(?,?,?,?)";
		int result = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bucketDto.getName());
			ps.setString(2, bucketDto.getPrice());
			ps.setString(3, bucketDto.getInfor());
			ps.setString(4, bucketDto.getId());
			
			result = ps.executeUpdate();
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
	
		return result;
		
	}
	
	public ObservableList<BucketDTO> SelectIdList() {
		String sql = "SELECT * FROM bucket where id = ?";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<BucketDTO> bucket = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
//			System.out.println("여기23 : " + useId);
			ps.setString(1, controller.getLoginDto().getId());
			rs = ps.executeQuery();
			while(rs.next()) {
				BucketDTO bucketDto = new BucketDTO(rs.getString("name"), rs.getString("price"), rs.getString("infor"));
				bucket.add(bucketDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bucket;
	}
	


}
