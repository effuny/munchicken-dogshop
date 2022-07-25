package project.manager.noticeBoard.writing;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;
import project.main.Controller;

public class NoticeWritingController implements Initializable{
	private Parent NoticeWriting;
	private NoticeWritingService noticeWritingService;
	private Controller controller;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		noticeWritingService = new NoticeWritingService();
	}

	
	public void setNoticeWriting(Parent NoticeWriting) {
		this.NoticeWriting = NoticeWriting;
	}
	
	
	public void uploadProc() {
		noticeWritingService.upload(NoticeWriting);
		controller.getManagerController().noticeOpenProc();
	}
	
	
	public void cancelProc() {
		CommonService.WindowClose(NoticeWriting);
		controller.getManagerController().noticeOpenProc();
	}
	
}
