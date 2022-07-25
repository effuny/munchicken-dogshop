package project.manager.memberList.updatedeleteBoard.updateBoard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.main.Controller;

public class UpdateController implements Initializable{
	private Parent ProjectUpdateBoard;
	private UpdateService updateService;
	private Controller controller;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateService = new UpdateService();
		
	}

	public void setProjectUpdateBoard(Parent projectUpdateBoard) {
		ProjectUpdateBoard = projectUpdateBoard;
	}
//
	public void setController(Controller controller) {
		this.controller = controller;
		
		
	}
//	public void updateProc(Parent ProjectUpdateBoard) {
//		

	public void updateProc(Parent ProjectUpdateBoard) {
		updateService.Update(ProjectUpdateBoard);
	}

	
	
	

}
