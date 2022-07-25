package project.member.messageBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MessageDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MessageDAO() {
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
	
	public ObservableList<Review> SelectAll() {
		String sql = "SELECT * FROM review";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<Review> reviews = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Review review = new Review(rs.getString("title"), rs.getString("id"), rs.getString("treatment"),
						rs.getString("content"));
				reviews.add(review);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return reviews;
	}
	
	public ObservableList<Review2> SelectAll2() {
		String sql = "SELECT * FROM review2";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<Review2> reviews = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Review2 review = new Review2(rs.getString("title"), rs.getString("id"),rs.getString("product"),
						rs.getString("content"),rs.getString("img"));
				reviews.add(review);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return reviews;
	}
	
	public int delete(String title) {
		String sql = "DELETE FROM review WHERE title=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
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
	
	public int delete2(String title) {
		String sql = "DELETE FROM review2 WHERE title=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
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
