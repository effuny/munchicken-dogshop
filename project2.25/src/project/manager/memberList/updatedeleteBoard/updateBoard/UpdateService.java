package project.manager.memberList.updatedeleteBoard.updateBoard;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import project.common.CommonService;


public class UpdateService {
	
	public void Update(Parent ProjectUpdateBoard) {
		
		Label labelId = (Label)ProjectUpdateBoard.lookup("#idLabel");
		String id = labelId.getText();
		
		PasswordField pwTxt = (PasswordField)ProjectUpdateBoard.lookup("#pwTxt");
		String pw = pwTxt.getText();
		
		PasswordField confirmTxt = (PasswordField)ProjectUpdateBoard.lookup("#confirmTxt");
		String cPw = confirmTxt.getText();
		
		//-----------------------------
		RadioButton manRadio = (RadioButton)ProjectUpdateBoard.lookup("#manRadio");
		RadioButton womanRadio = (RadioButton)ProjectUpdateBoard.lookup("#womanRadio");
		
		String gender = "";
		if(manRadio.isSelected())
			gender += "남";
		else if(womanRadio.isSelected())
			gender += "여";
		
		//-----------------------------
		
		
		TextField phoneNumber = (TextField)ProjectUpdateBoard.lookup("#phoneNumber");		
		String phone = phoneNumber.getText();
		
		ComboBox<String> comboage = (ComboBox<String>)ProjectUpdateBoard.lookup("#ageCombo");
		String age = comboage.getValue();
		
		ComboBox<String> combocode = (ComboBox<String>)ProjectUpdateBoard.lookup("#countryCode");
		String countryCode = combocode.getValue();
		
		
		RadioButton petMaleRadio = (RadioButton)ProjectUpdateBoard.lookup("#petMaleRadio");
		RadioButton petFemaleRadio = (RadioButton)ProjectUpdateBoard.lookup("#petFemaleRadio");
		
		
		TextField petName1Txt = (TextField)ProjectUpdateBoard.lookup("#petName1Txt");		
		String petname1 = petName1Txt.getText();

		
		String petsex1 = "";
		if(petMaleRadio.isSelected())
			petsex1 += "남";
		else if(petFemaleRadio.isSelected())
			petsex1 += "여";
		
		
		ComboBox<String> comboPetAge = (ComboBox<String>)ProjectUpdateBoard.lookup("#petAge");
		String petage1 = comboPetAge.getValue();
		
		ComboBox<String> comboPetBreed = (ComboBox<String>)ProjectUpdateBoard.lookup("#petBreed");
		String petbreed1 = comboPetBreed.getValue();
		
		
		UpdateDAO updateDao = new UpdateDAO();
		UpdateDTO updateDto = updateDao.UpdateSelectId(id);
		

			updateDto = new UpdateDTO();
			updateDto.setId(id);
			updateDto.setPw(pw);
			updateDto.setGender(gender);
			updateDto.setAge(age);
//			updateDto.setPetname1(petname1);
//			updateDto.setPetsex1(petsex1);
//			updateDto.setPetbreed1(petbreed1);
//			updateDto.setPetage1(petage1);

			
			if(pw.equals(cPw)) {
				UpdateDAO upDao = new UpdateDAO();
				UpdateDTO upDto = upDao.UpdateSelectId(id);
				if(upDto == null) {
					upDto = new UpdateDTO();
					upDto.setId(id);
					upDto.setPw(pw);
					upDto.setGender(gender);
					upDto.setAge(age);
					upDto.setCountryCode(countryCode);
					upDto.setPhone(phone);
					upDto.setPetname1(petname1);
					upDto.setPetsex1(petsex1);
					upDto.setPetage1(petage1);
					upDto.setPetbreed1(petbreed1);
					

//					upDao.updateUpdate(upDto);
					CommonService.Msg("회원 수정 완료");
					CommonService.WindowClose(ProjectUpdateBoard);
				}
			}else {
				CommonService.Msg("입력한 두 패스워드가 다릅니다");
			}
		
		
		
	
	}

}
