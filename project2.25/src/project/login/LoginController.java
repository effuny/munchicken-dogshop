package project.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.manager.ManagerDTO;

public class LoginController implements Initializable{

	private Parent ProjectLoginPage;
	private LoginServiceImpl loginSvc;
	private Controller controller;
	
	 @FXML
	 private TextField idText;
	
	static String useId;
	
	public static String bring() { 
		return useId;
	}
	
	public void setProjectLoginPage(Parent ProjectLoginPage) {
		this.ProjectLoginPage = ProjectLoginPage;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.loginSvc = new LoginServiceImpl();
		
		
		
		
	}
	
	
		

	
	public void loginProc() {
		ManagerDTO managerDto = loginSvc.MloginProc(ProjectLoginPage);
		LoginDTO loginDto = loginSvc.loginProc(ProjectLoginPage);
		controller.setLoginDto(loginDto);
//		useId = controller.getLoginDto().getId();
//		System.out.println("스태틱변수에 값이? : " + useId);
		
		
		
		
		
		
		
		if(managerDto != null) {
			controller.open("Manager");
			loginDto = new LoginDTO();
			loginDto.setId(managerDto.getId());
			controller.setLoginDto(loginDto);
			CommonService.WindowClose(ProjectLoginPage);
			
		}else if(loginDto != null) {
			controller.open("Member");
			useId = controller.getLoginDto().getId();
			managerDto = new ManagerDTO();
			managerDto.setId(loginDto.getId());
			controller.setManagerDto(managerDto);
			CommonService.WindowClose(ProjectLoginPage);
			
		}
		
	}
	
	
	
	
	public void findIdProc() throws Exception{
		controller.open("FindId");
	}
	public void findPwProc() throws Exception{
		controller.open("FindPw");
	}
	public void regOpenProc() throws Exception{
		controller.open("Register");
	}
	
	
	public void introProc() throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/showShop/ShowShopForm.fxml"));
		Parent showShop;
		
		try {
			showShop = loader.load();
			
			Scene scene = new Scene(showShop);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ShowShop");
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e) {
			e.printStackTrace();
	
		}
	}
	
	
	
	
	
}
