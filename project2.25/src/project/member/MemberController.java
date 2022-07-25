package project.member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.member.messageBoard.writing.WritingController;
import project.member.reserve.ReserveController;

public class MemberController implements Initializable{
	private Parent ProjectMember;
	private MemberService memberService;
	private Controller controller;
	private WritingController writingController;
	
	
	
	
	@FXML
	private Label homeId;
	
	public void setController(Controller controller) {
		
		this.controller = controller;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberService = new MemberService();
		
	}


	public void setProjectMember(Parent ProjectMember) {
		this.ProjectMember = ProjectMember;
	}
	
	public Controller getController() {
		return controller;
	}
	
	



	public WritingController getWritingController() {
		return writingController;
	}

	public void setWritingController(WritingController writingController) {
		this.writingController = writingController;
	}

	
	public void messageOpenProc() {
//		System.out.println("메시지열떄 스테틱 : " + userId);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/ProjectMessageBoard.fxml"));
		Parent ProjectMessageBoard;
		
		try {
			ProjectMessageBoard=loader.load();
			
			controller.setMessageController(loader.getController());
			controller.getMessageController().setProjectMessageBoard(ProjectMessageBoard);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(ProjectMessageBoard));
			stage.setTitle("ProjectMessageBoard");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void dogShopProc() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/dogitem/ProjectDogShop.fxml"));
		Parent ProjectDogShop;
		
		try {
			ProjectDogShop=loader.load();
			
			controller.setDogShopController(loader.getController());
			controller.getDogShopController().setProjectDogShop(ProjectDogShop);
			
			System.out.println("여기1 : " + controller.getLoginDto().getId());
			
			Stage stage = new Stage();
			stage.setScene(new Scene(ProjectDogShop));
			stage.setTitle("ProjectDogShop");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void reserveOpenProc() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/reserve/ReserveForm.fxml"));
		Parent reserveForm;
		
		try {
			reserveForm = loader.load();
			
			controller.setReserveController(loader.getController());
			ReserveController reserveController = controller.getReserveController();
			reserveController.setReserveForm(reserveForm);
			reserveController.setController(controller);
			
			
			ComboBox<String> hourPicker = (ComboBox<String>)reserveForm.lookup("#serviceHour");
		    if(hourPicker != null) {
		    	hourPicker.getItems().addAll("9시","10시","11시","12시","1시","2시","3시","4시","5시");
		    }

		    ComboBox<String> serviceSelect = (ComboBox<String>)reserveForm.lookup("#service");
		    if(serviceSelect != null) {
		    	serviceSelect.getItems().addAll("목욕","커트","목욕+커트","염색");
		    }
		
			
			Stage stage = new Stage();
			stage.setScene(new Scene(reserveForm));
			stage.setTitle("ProjectMessageBoard");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editRegProc() {
	      
	      FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/editReg/EditRegForm.fxml"));
	      Parent EditRegForm;
	      
	      try {
	         EditRegForm = loader.load();
	         
	         
	         controller.setEditRegController(loader.getController());
	         controller.getEditRegController().setEditRegForm(EditRegForm);
	         
	         TextField TextId = (TextField)EditRegForm.lookup("#idTxt");
	         TextId.setText(controller.getLoginDto().getId());
	         String id = TextId.getText();
	         
	         System.out.println("아이디 : " + id);

	         ComboBox<String> comboage = (ComboBox<String>)EditRegForm.lookup("#ageCombo");
	         if(comboage != null) {
	            comboage.getItems().addAll("10대", "20대", "30대", "40대", "50대");
	            comboage.setValue(controller.getLoginDto().getAge());   
	         }
	         	System.out.println("여기1" + controller.getLoginDto().getAge());
	         
	         ComboBox<String> combocode = (ComboBox<String>)EditRegForm.lookup("#countryCode");
	         if(combocode != null) {
	            combocode.getItems().addAll("+1(미국)", "+44(영국)", "+81(일본)", "+82(대한민국)", "+86(중국)");
	            combocode.setValue(controller.getLoginDto().getCountrycode());
	         }
	         TextField phoneNumber = (TextField)EditRegForm.lookup("#phoneNumber");      
	         phoneNumber.setText(controller.getLoginDto().getPhone());
	         
	         TextField petName1Txt = (TextField)EditRegForm.lookup("#petName1Txt");      
	         petName1Txt.setText(controller.getLoginDto().getPetname1());
	         
	         
	         ComboBox<String> comboPetAge = (ComboBox<String>)EditRegForm.lookup("#petAge");
	            if(comboPetAge != null) {
	               comboPetAge.getItems().addAll("1~3","4~7","7~9","10세이상");
	               comboPetAge.setValue(controller.getLoginDto().getPetage1());
	            }
	         
	            ComboBox<String> comboPetBreed = (ComboBox<String>)EditRegForm.lookup("#petBreed");
	            if(comboPetBreed != null) {
	               comboPetBreed.getItems().addAll("토이푸들","보스턴테리어","말티즈","닥스훈트","요크셔테리어","비숑");
	               comboPetBreed.setValue(controller.getLoginDto().getPetbreed1());
	            }   
	            
	         
	         Stage stage = new Stage();
	         stage.setScene(new Scene(EditRegForm));
	         stage.setTitle("EditRegForm");
	         stage.show();
	         
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	   }
	

	
	public void logoutProc() {
		controller.open("LoginPage");
		CommonService.WindowClose(ProjectMember);
		
		
	}
	
	public void noticeOpenProc() {
	      FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/notice/NoticeMember.fxml"));
	      Parent NoticeMember;
	      
	      try {
	         NoticeMember = loader.load();
	         
	         controller.setNoticeMemberController(loader.getController());
	         controller.getNoticeMemberController().setNoticeMember(NoticeMember);
	         
	         Scene scene = new Scene(NoticeMember);
	         Stage primaryStage = new Stage();
	         primaryStage.setTitle("NoticeMember");
	         primaryStage.setScene(scene);
	         primaryStage.show();
	         
	         
	      }catch(IOException e){
	         e.printStackTrace();
	      }
	      
	      
	      
	   }
	
}
