package project.manager.noticeBoard.writing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.member.messageBoard.writing.WritingDTO;

public class NoticeWritingDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	public NoticeWritingDTO noticeWritingDto;
	
	
	public NoticeWritingDAO() {
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
	
	
	public NoticeWritingDTO SeletTitle(String title) {
		String sql = "SELECT * FROM notice WHERE title=?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			if(rs.next()) {
				NoticeWritingDTO noticeDto = new NoticeWritingDTO();
				
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setNoticedate(rs.getString("noticedate"));
				noticeDto.setContent(rs.getString("content"));
			
				return noticeDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int insert(NoticeWritingDTO noticeDto) {
		String sql = "INSERT INTO notice VALUES(?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, noticeDto.getTitle());
			ps.setString(2, noticeDto.getNoticedate());
			ps.setString(3, noticeDto.getContent());
			
			result = ps.executeUpdate();
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
	
		return result;
	}
	
	
	
	
	
	
	
}
