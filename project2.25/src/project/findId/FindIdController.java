package project.findId;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;

public class FindIdController implements Initializable{
	private Parent ProjectFindId;
	private FindIdService findIdService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findIdService = new FindIdService();
		
	}
	
	public void setProjectFindId(Parent ProjectFindId) {
		this.ProjectFindId = ProjectFindId;
	}
	
	
	public void findIdProc() {
		findIdService.findIdProc(ProjectFindId);
		//
	}
	
	public void findIdCancelProc() {
		CommonService.WindowClose(ProjectFindId);
	}
	
}
