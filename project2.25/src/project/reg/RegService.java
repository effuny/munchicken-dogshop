package project.reg;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.main.Controller;



public class RegService {
	
	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void insert(Parent ProjectRegister) {
		
		TextField idTxt = (TextField)ProjectRegister.lookup("#idTxt");
		PasswordField pwTxt = (PasswordField)ProjectRegister.lookup("#pwTxt");
		PasswordField confirmTxt = (PasswordField)ProjectRegister.lookup("#confirmTxt");
		
		
		String id = idTxt.getText();
		
		String check = "[0-9]";
		
		boolean num = id.matches(check);
		
		String pw = pwTxt.getText();
		String confirm = confirmTxt.getText();
		
		RadioButton manRadio = (RadioButton)ProjectRegister.lookup("#manRadio");
		RadioButton womanRadio = (RadioButton)ProjectRegister.lookup("#womanRadio");
		
		String gender = "";
		if(manRadio.isSelected())
			gender += "남";
		else if(womanRadio.isSelected())
			gender += "여";
		
		TextField phoneNumber = (TextField)ProjectRegister.lookup("#phoneNumber");		
		String phone = phoneNumber.getText();
		
		ComboBox<String> comboage = (ComboBox<String>)ProjectRegister.lookup("#ageCombo");
		String age = comboage.getValue();
		
		ComboBox<String> combocode = (ComboBox<String>)ProjectRegister.lookup("#countryCode");
		String countryCode = combocode.getValue();
		
		
		RadioButton petMaleRadio = (RadioButton)ProjectRegister.lookup("#petMaleRadio");
		RadioButton petFemaleRadio = (RadioButton)ProjectRegister.lookup("#petFemaleRadio");
		
		
		TextField petName1Txt = (TextField)ProjectRegister.lookup("#petName1Txt");		
		String petname1 = petName1Txt.getText();
		
		
		
		String petsex1 = "";
		if(petMaleRadio.isSelected())
			petsex1 += "남";
		else if(petFemaleRadio.isSelected())
			petsex1 += "여";
		
		
		ComboBox<String> comboPetAge = (ComboBox<String>)ProjectRegister.lookup("#petAge");
		String petage1 = comboPetAge.getValue();
		
		ComboBox<String> comboPetBreed = (ComboBox<String>)ProjectRegister.lookup("#petBreed");
		String petbreed1 = comboPetBreed.getValue();
		
		
			if(pw.equals(confirm)) {
				RegDAO regDao = new RegDAO();
				RegDTO regDto = regDao.SelectId(id);
				if(regDto == null) {
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
					
					
					regDao.insert(regDto);
					CommonService.Msg(id +"계정등록 완료");
					CommonService.WindowClose(ProjectRegister);
				}else {
					CommonService.Msg("중복체크를 해주세요");
				}
			}else {
				CommonService.Msg("입력한 두 패스워드가 다릅니다");
			}
			
		}
		
		
		
	

	public void overlap(Parent ProjectRegister) {
		TextField idTxt = (TextField)ProjectRegister.lookup("#idTxt");
		String id = idTxt.getText();
		RegDAO dao = new RegDAO();
		RegDTO overlapping = dao.SelectId(id);
		
		if(overlapping == null) {
			CommonService.Msg("사용가능한 아이디입니다");
		}else {
			CommonService.Msg(id + "은(는) 등록된 계정입니다.");
		}
		
		
	}

}
