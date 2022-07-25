package project.reg;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import project.common.CommonService;

public class RegController implements Initializable{
	private Parent ProjectRegister;
	private RegService regService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			regService = new RegService();
	}
	
	public void setProjectRegister(Parent ProjectRegister) {
		this.ProjectRegister = ProjectRegister;
	}
	
	//중복체크
	public void overlappingProc() {
		regService.overlap(ProjectRegister);
		
	}
	
	
	public void regProc() {
		regService.insert(ProjectRegister);
	}
	
	public void regCancelProc() {
		CommonService.WindowClose(ProjectRegister);
	}

}
