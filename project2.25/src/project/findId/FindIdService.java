package project.findId;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.reg.RegDTO;

public class FindIdService {
	
	public RegDTO findIdProc(Parent root) {
		

		TextField NumberTxt = (TextField)root.lookup("#phoneNumberText");

		
		FindIdDAO findIdDao = new FindIdDAO();
		RegDTO regDto =  findIdDao.SelectId(NumberTxt.getText());
		
		if(regDto != null && regDto.getPhone().equals(NumberTxt.getText())) {
			CommonService.Msg("당신의 아이디는  : "  + regDto.getId());
		}else if(regDto != null && !regDto.getPhone().equals(NumberTxt.getText())) {
			CommonService.Msg("등록된 전화번호가 없어요!");
			
			NumberTxt.requestFocus();
		}
		
		return null;
		
	}

}
