package project.member.editReg;

import java.net.URL; 
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;
import project.main.Controller;

public class EditRegController implements Initializable{
	private Parent EditRegForm;
	private EditRegService editRegService;
	private Controller controller;
	
	
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setEditRegForm(Parent EditRegForm) {
		this.EditRegForm = EditRegForm;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		editRegService = new EditRegService();
		
	}
	
	public void editProc() {
		editRegService.update(EditRegForm);
	}
	
	
	
	
	
	public void cancelProc() {
		CommonService.WindowClose(EditRegForm);
	}
	
	

}
