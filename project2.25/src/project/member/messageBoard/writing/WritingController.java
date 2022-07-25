package project.member.messageBoard.writing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.member.MemberController;

public class WritingController implements Initializable{
	private Parent BoardService;
	private WritingService writingService;
	private MemberController memberController;
	private Controller controller;
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return controller;
	}
	public void setMemberController(MemberController memberController) {
		this.memberController = memberController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		writingService = new WritingService();
		
	}
	
	public void setBoardService(Parent BoardService) {
		this.BoardService = BoardService;
	}
	
	public void uploadProc() {
		writingService.upload(BoardService);
		//writingService.open(BoardService);
		controller.getMemberController().messageOpenProc();
	}
	
	
	public void cancelProc() {
		CommonService.WindowClose(BoardService);
	}

	

	

	
}
