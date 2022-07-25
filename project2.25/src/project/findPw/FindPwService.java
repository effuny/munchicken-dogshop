package project.findPw;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.findId.FindIdDAO;
import project.reg.RegDTO;

public class FindPwService {
	
	public RegDTO findPwProc(Parent root) {
		
		TextField Id = (TextField)root.lookup("#idText");
		TextField Number = (TextField)root.lookup("#phoneNumberText");
//		PasswordField NumberTxt = (PasswordField)root.lookup("#phoneNumberText");

		System.out.println("아이디  : " + Id.getText());
		System.out.println("전번 : " + Number.getText());
		
		FindIdDAO findIdDao = new FindIdDAO();
		RegDTO regDto =  findIdDao.SelectPw(Id.getText());
		
		if(regDto != null && regDto.getId().equals(Id.getText())) {
			if(regDto != null && regDto.getPhone().equals(Number.getText())) {
				
				CommonService.Msg("당신의 비밀번호는 ?   : "  + regDto.getPw());
			}
		}else{
			CommonService.Msg("아이디 전화번호가 틀렸습니다.");
			
		}
		
		Id.requestFocus();		
		return null;
		
	}

}
