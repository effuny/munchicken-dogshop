package project.member.notice.selet;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;
import project.main.Controller;

public class NoticeMemController implements Initializable{
	private Parent NotMSeletForm;
	private NoticeMemService noticeMemService;
	private Controller controller;
	
	
	
	public Controller getController() {
		return controller;
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		noticeMemService = new NoticeMemService();
		
	}

	
	public void exitPro() {
		CommonService.WindowClose(NotMSeletForm);
	}
	
	public void setNotMSeletForm(Parent notMSeletForm) {
		this.NotMSeletForm = notMSeletForm;
	}
	
	
}
