package project.member.messageBoard.select;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;
import project.main.Controller;
//수정창
public class SelectController implements Initializable{
	private Parent SelectForm;
	private SelectService selectService;
	private Controller controller;
	
	public Controller getController() {
		return controller;
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectService = new SelectService();
	}

	
	public void cancelProc() {
		CommonService.WindowClose(SelectForm);
	}


	public void setSelectForm(Parent selectForm) {
		this.SelectForm = selectForm;
		
	}
}
