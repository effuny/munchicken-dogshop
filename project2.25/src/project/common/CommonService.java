package project.common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import project.main.Controller;

public class CommonService {
	
//	Controller controller;
	static String use;
	
	
	
	
	
	
//	public static void setController(Controller controller) {
//		this.controller = controller;
//	}


	public static void Msg(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("알람");
		alert.setContentText(content);
		
		alert.show();
		
	}
	
	
	public static void WindowClose(Parent form) {
		Stage stage = (Stage)form.getScene().getWindow();
		stage.close();
		
	}
	public static String bringId(String immi) {
		
	 	
		return immi; 
	}
	
	
	
	
	

}
