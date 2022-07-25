package project.member.messageBoard.select2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;
import project.main.Controller;


public class SelectController2 implements Initializable{
	private Parent SelectForm2;
	private SelectService2 selectSerivce2;
	private Controller controller;
	
	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectSerivce2 = new SelectService2();
		
	}

	
	public void cancelProc() {
		CommonService.WindowClose(SelectForm2);
	}
	
	public void setSelectForm2(Parent selectForm2) {
		this.SelectForm2 = selectForm2;
	}
	
	
}
