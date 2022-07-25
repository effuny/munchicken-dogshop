package project.findPw;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;

public class FindPwController implements Initializable{
	private Parent ProjectFindPw;
	private FindPwService findPwService;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findPwService = new FindPwService();
		
	}
	
	public void setProjectFindPw(Parent ProjectFindPw) {
		this.ProjectFindPw = ProjectFindPw;
	}
	
	
	public void findPwProc() {
		findPwService.findPwProc(ProjectFindPw);
		//
		
	}
	
	public void findPwCancelProc() {
		CommonService.WindowClose(ProjectFindPw);
	}
	
	

}
