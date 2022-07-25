package project.member.messageBoard.edit;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;
import project.main.Controller;

public class EditController implements Initializable{
	private Parent EditForm;
	private EditService editService;
	private Controller controller;
	
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		editService = new EditService();
	}
	
	
	public void editProc() {
		editService.edit(EditForm);
		
		//controller.getMemberController().messageOpenProc();
	}
	
	
	
	
	public void cancelProc() {
		CommonService.WindowClose(EditForm);
	}

	public void setEditForm(Parent editForm) {
		this.EditForm = editForm;
	}
	
}
