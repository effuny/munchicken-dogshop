package project.manager.noticeBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.member.messageBoard.Review;

public class NoticeDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public NoticeDAO() {
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
	
	public ObservableList<Notice> SelectAll() {
		String sql = "SELECT * FROM notice";
		PreparedStatement ps;
		ResultSet rs;
		ObservableList<Notice> notices = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice(rs.getString("title"), rs.getString("noticedate"),
						rs.getString("content"));
				notices.add(notice);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return notices;
	}

	public int delete(String title) {
		String sql = "DELETE FROM notice WHERE title=?";
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
