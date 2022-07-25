package project.member.editReg;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.reg.RegDAO;
import project.reg.RegDTO;

public class EditRegService {

	public void update(Parent editRegForm) {
		
		TextField idTxt = (TextField)editRegForm.lookup("#idTxt");
		PasswordField pwTxt = (PasswordField)editRegForm.lookup("#pwTxt");
		PasswordField confirmTxt = (PasswordField)editRegForm.lookup("#confirmTxt");
		
		String id = idTxt.getText();
		String pw = pwTxt.getText();
		String confirm = confirmTxt.getText();
		
		RadioButton manRadio = (RadioButton)editRegForm.lookup("#manRadio");
		RadioButton womanRadio = (RadioButton)editRegForm.lookup("#womanRadio");
		
		String gender = "";
		if(manRadio.isSelected())
			gender += "남";
		else if(womanRadio.isSelected())
			gender += "여";
		
		TextField phoneNumber = (TextField)editRegForm.lookup("#phoneNumber");		
		String phone = phoneNumber.getText();
		
		ComboBox<String> comboage = (ComboBox<String>)editRegForm.lookup("#ageCombo");
		String age = comboage.getValue();
		
		ComboBox<String> combocode = (ComboBox<String>)editRegForm.lookup("#countryCode");
		String countryCode = combocode.getValue();
		
		
		
		RadioButton petMaleRadio = (RadioButton)editRegForm.lookup("#petMaleRadio");
		RadioButton petFemaleRadio = (RadioButton)editRegForm.lookup("#petFemaleRadio");
		
		
		TextField petName1Txt = (TextField)editRegForm.lookup("#petName1Txt");		
		String petname1 = petName1Txt.getText();
		
		String petsex1 = "";
		if(petMaleRadio.isSelected())
			petsex1 += "남";
		else if(petFemaleRadio.isSelected())
			petsex1 += "여";
		
		
		ComboBox<String> comboPetAge = (ComboBox<String>)editRegForm.lookup("#petAge");
		String petage1 = comboPetAge.getValue();
		
		ComboBox<String> comboPetBreed = (ComboBox<String>)editRegForm.lookup("#petBreed");
		String petbreed1 = comboPetBreed.getValue();
		
		if(pw.equals(confirm)) {
			RegDAO regDao = new RegDAO();
			RegDTO regDto = regDao.SelectId(id);
			if(regDto != null) {
				regDto = new RegDTO();
				regDto.setId(id);
				regDto.setPw(pw);
				regDto.setGender(gender);
				regDto.setAge(age);
				regDto.setCountryCode(countryCode);
				regDto.setPhone(phone);
				regDto.setPetname1(petname1);
				regDto.setPetsex1(petsex1);
				regDto.setPetage1(petage1);
				regDto.setPetbreed1(petbreed1);
				
				
				
				regDao.update(regDto);
				
				
				CommonService.Msg(id +"계정수정 완료");
				CommonService.WindowClose(editRegForm);
			}else {
				CommonService.Msg("중복체크를 해주세요");
			}
		}else {
			CommonService.Msg("입력한 두 패스워드가 다릅니다");
		}
		
	}

}
