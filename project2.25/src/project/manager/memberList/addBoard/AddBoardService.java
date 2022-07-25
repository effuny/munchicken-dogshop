package project.manager.memberList.addBoard;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
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

public class AddBoardService {
	private Controller controller;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void Addinsert(Parent ProjectAddBoard) {
		
//
//    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/ManagerOfficial.fxml"));
//		Parent ManagerOfficial;
//		
//		TextField idTxt = (TextField)ProjectAddBoard.lookup("#idTxt");
//		PasswordField pwTxt = (PasswordField)ProjectAddBoard.lookup("#pwTxt");
//		PasswordField confirmTxt = (PasswordField)ProjectAddBoard.lookup("#confirmTxt");
//		
//		
//		String id = idTxt.getText();
//		String pw = pwTxt.getText();
//		String confirm = confirmTxt.getText();
//		
//		RadioButton manRadio = (RadioButton)ProjectAddBoard.lookup("#manRadio");
//		RadioButton womanRadio = (RadioButton)ProjectAddBoard.lookup("#womanRadio");
//		
//		String gender = "";
//		if(manRadio.isSelected())
//			gender += "남";
//		else if(womanRadio.isSelected())
//			gender += "여";
//		
//		TextField phoneNumber = (TextField)ProjectAddBoard.lookup("#phoneNumber");		
//		String phone = phoneNumber.getText();
//		
//		ComboBox<String> comboage = (ComboBox<String>)ProjectAddBoard.lookup("#ageCombo");
//		String age = comboage.getValue();
//		
//		ComboBox<String> combocode = (ComboBox<String>)ProjectAddBoard.lookup("#countryCode");
//		String countryCode = combocode.getValue();
//
//		
//			if(pw.equals(confirm)) {
//				AddDAO addDao = new AddDAO();
//				AddDTO addDto = addDao.AddSelectId(id);
//				if(addDto == null) {
//					addDto = new AddDTO();
//					addDto.setId(id);
//					addDto.setPw(pw);
//					addDto.setGender(gender);
//					addDto.setAge(age);
//					addDto.setCountryCode(countryCode);
//					addDto.setPhone(phone);
//
//					addDao.addInsert(addDto);
//					CommonService.Msg(id +"계정등록 완료");
//					CommonService.WindowClose(ProjectAddBoard);
//				}else {
//					CommonService.Msg("중복체크를 해주세요");
//				}
//			}else {
//				CommonService.Msg("입력한 두 패스워드가 다릅니다");
//			}
//			
//			try {
//				ManagerOfficial = loader.load();
//				
//				MemberListController memberListController = controller.getMemberListController();
//				memberListController.setManagerOfficial(ManagerOfficial);
//				
//				Scene scene = new Scene(ManagerOfficial);
//				Stage primaryStage = new Stage();
//				primaryStage.setTitle("ManagerOfficial");
//				primaryStage.setScene(scene);
//				primaryStage.show();
//				
//				
//			}catch(IOException e){
//				e.printStackTrace();
//			}
	}
	
//	public void overlap(Parent ProjectAddBoard) {
//		TextField idTxt = (TextField)ProjectAddBoard.lookup("#idTxt");
//		String id = idTxt.getText();
//		AddDAO dao = new AddDAO();
//		AddDTO overlapping = dao.AddSelectId(id);
//		
//		if(overlapping == null) {
//			CommonService.Msg("사용가능한 아이디입니다");
//		}else {
//			CommonService.Msg(id + "은(는) 등록된 계정입니다.");
//		}
//		
//		
//	}

}
