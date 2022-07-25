package project.manager.noticeBoard.writing;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.main.Controller;

public class NoticeWritingService {
	private Controller controller;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}


	public void upload(Parent noticeWriting) {
		TextField titleTxt = (TextField)noticeWriting.lookup("#titleText");
		String title = titleTxt.getText();
		
		TextArea contentTxt = (TextArea)noticeWriting.lookup("#contentText");
		String content = contentTxt.getText();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String noticedate = sdf.format(date);
		
		
		NoticeWritingDAO noticeDao = new NoticeWritingDAO();
		NoticeWritingDTO noticeDto = noticeDao.SeletTitle(title);
			noticeDto = new NoticeWritingDTO();
			noticeDto.setTitle(title);
			noticeDto.setNoticedate(noticedate);
			noticeDto.setContent(content);
			
			noticeDao.insert(noticeDto);
			CommonService.Msg(title + "의 글이 게재되었습니다.");
			CommonService.WindowClose(noticeWriting);
		
		
	}

}
