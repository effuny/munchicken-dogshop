package project.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.reg.RegService;

public class MainService {
	private Controller controller;
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void findIdOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/findId/ProjectFindId.fxml"));
		Parent ProjectFindId;
		
		try {
			ProjectFindId = loader.load();
			controller.setFindIdController(loader.getController());
			controller.getFindIdController().setProjectFindId(ProjectFindId);
			
			Scene scene = new Scene(ProjectFindId);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ProjectFindId");
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e) {
			e.printStackTrace();
	
		}
	}
	
	public void findPwOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/findPw/ProjectFindPw.fxml"));
		Parent ProjectFindPw;
		
		try {
			ProjectFindPw = loader.load();
			controller.setFindPwController(loader.getController());
			controller.getFindPwController().setProjectFindPw(ProjectFindPw);
			
			Scene scene = new Scene(ProjectFindPw);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ProjectFindPw");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
	
		}
	}
	

	public void regOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/reg/ProjectRegister.fxml"));
		Parent ProjectRegister;
		
		try {
			ProjectRegister = loader.load();
			controller.setRegController(loader.getController());
			controller.getRegController().setProjectRegister(ProjectRegister);
			
			RegService regService = new RegService();
			regService.setController(controller);
			
			
			ComboBox<String> comboage = (ComboBox<String>)ProjectRegister.lookup("#ageCombo");
			if(comboage != null) {
				comboage.getItems().addAll("10대", "20대", "30대", "40대", "50대");
			}
			
			ComboBox<String> combocode = (ComboBox<String>)ProjectRegister.lookup("#countryCode");
			if(combocode != null) {
				combocode.getItems().addAll("+1(미국)", "+44(영국)", "+81(일본)", "+82(대한민국)", "+86(중국)");
			}
			 ComboBox<String> comboPetAge = (ComboBox<String>)ProjectRegister.lookup("#petAge");
	         if(comboPetAge != null) {
	            
	        	 comboPetAge.getItems().addAll("1~3","4~7","7~9","10세이상");
	         }
	         ComboBox<String> comboPetBreed = (ComboBox<String>)ProjectRegister.lookup("#petBreed");
	         if(comboPetBreed != null) {
	            
	        	 comboPetBreed.getItems().addAll("토이푸들","보스턴테리어","말티즈","닥스훈트","요크셔테리어","비숑");
	         }	
			Scene scene = new Scene(ProjectRegister);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ProjectRegister");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}catch(IOException e) {
			e.printStackTrace();
	
		}
	}

	public void memberPageOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/ProjectMember.fxml"));
		Parent ProjectMember;
		
		try {
			ProjectMember = loader.load();
			
			controller.setMemberController(loader.getController());
			controller.getMemberController().setProjectMember(ProjectMember);
			
			Label label = (Label)ProjectMember.lookup("#homeId");
			label.setText(controller.getLoginDto().getId());
			
			Scene scene = new Scene(ProjectMember);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ProjectMember");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public void managerPageOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/ProjectAdmin.fxml"));
		Parent ProjectAdmin;
		
		try {
			ProjectAdmin = loader.load();
			
			controller.setManagerController(loader.getController());
			controller.getManagerController().setProjectAdmin(ProjectAdmin);
			
			Scene scene = new Scene(ProjectAdmin);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ProjectAdmin");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void loginPageOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/login/ProjectLoginPage.fxml"));
		Parent ProjectLoginPage;
		
		try {
			ProjectLoginPage=loader.load();
		
			controller.setLoginController(loader.getController());
			controller.getLoginController().setProjectLoginPage(ProjectLoginPage);
		
		
			Scene scene = new Scene(ProjectLoginPage);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("MainLoginPage");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	

	

	
}
