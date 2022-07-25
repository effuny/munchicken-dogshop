package project.manager.memberList.addBoard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.manager.memberList.MemberListController;

public class AddController implements Initializable{
	private Parent ProjectAddBoard;
	private AddBoardService addBoardService;
	private Controller controller;
	
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		addBoardService = new AddBoardService();
		
	}
	public void plusMember() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/ManagerOfficial.fxml"));
		Parent ManagerOfficial;
		
		TextField idTxt = (TextField)ProjectAddBoard.lookup("#idTxt");
		PasswordField pwTxt = (PasswordField)ProjectAddBoard.lookup("#pwTxt");
		PasswordField confirmTxt = (PasswordField)ProjectAddBoard.lookup("#confirmTxt");
		
		
		String id = idTxt.getText();
		String pw = pwTxt.getText();
		String confirm = confirmTxt.getText();
		
		RadioButton manRadio = (RadioButton)ProjectAddBoard.lookup("#manRadio");
		RadioButton womanRadio = (RadioButton)ProjectAddBoard.lookup("#womanRadio");
		
		String gender = "";
		if(manRadio.isSelected())
			gender += "남";
		else if(womanRadio.isSelected())
			gender += "여";
		
		TextField phoneNumber = (TextField)ProjectAddBoard.lookup("#phoneNumber");		
		String phone = phoneNumber.getText();
		
		ComboBox<String> petage = (ComboBox<String>)ProjectAddBoard.lookup("#petAge");
		String page = petage.getValue();
		
		ComboBox<String> petBreed = (ComboBox<String>)ProjectAddBoard.lookup("#petBreed");
		String pBReed = petBreed.getValue();
		
		TextField pTxt = (TextField)ProjectAddBoard.lookup("#petName1Txt");
		String pid = pTxt.getText();
		
		RadioButton pm = (RadioButton)ProjectAddBoard.lookup("#petMaleRadio");
		RadioButton pf = (RadioButton)ProjectAddBoard.lookup("#petFemaleRadio");
		
		String pgender = "";
		if(pm.isSelected())
			pgender += "남";
		else if(pf.isSelected())
			pgender += "여";
		
		ComboBox<String> comboage = (ComboBox<String>)ProjectAddBoard.lookup("#ageCombo");
		String age = comboage.getValue();
		
		ComboBox<String> combocode = (ComboBox<String>)ProjectAddBoard.lookup("#countryCode");
		String countryCode = combocode.getValue();

		
		
			if(pw.equals(confirm)) {
				AddDAO addDao = new AddDAO();
				AddDTO addDto = addDao.AddSelectId(id);
				if(addDto == null) {
					addDto = new AddDTO();
					addDto.setId(id);
					addDto.setPw(pw);
					addDto.setGender(gender);
					addDto.setAge(age);
					addDto.setCountryCode(countryCode);
					addDto.setPhone(phone);
					addDto.setPetname1(pid);
					addDto.setPetage1(page);
					addDto.setPetbreed1(pBReed);
					addDto.setPetsex1(pgender);

					addDao.addInsert(addDto);
					CommonService.Msg(id +"계정등록 완료");
					CommonService.WindowClose(ProjectAddBoard);
				}else {
					CommonService.Msg("중복체크를 해주세요");
				}
			}else {
				CommonService.Msg("입력한 두 패스워드가 다릅니다");
			}
			
			try {
				ManagerOfficial = loader.load();
				controller.setMemberListController(loader.getController());
				MemberListController memberListController = controller.getMemberListController();
				memberListController.setManagerOfficial(ManagerOfficial);
				
				Scene scene = new Scene(ManagerOfficial);
				Stage primaryStage = new Stage();
				primaryStage.setTitle("ManagerOfficial");
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
			}catch(IOException e){
				e.printStackTrace();
			}
		
	}
//	public void overlappingProc() {
//		addBoardService.overlap(ProjectAddBoard);
//	}

	public void setProjectAddBoard(Parent projectAddBoard) {
		ProjectAddBoard = projectAddBoard;
	}
	

}
