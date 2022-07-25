package project.login;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.manager.ManagerDAO;
import project.manager.ManagerDTO;


public class LoginServiceImpl implements LoginService{

	
	public ManagerDTO MloginProc(Parent root) {
	      
	      TextField idText = (TextField) root.lookup("#idText");
	      PasswordField pwText = (PasswordField) root.lookup("#pwText");
	      System.out.println("아이디 : " + idText.getText());
	      System.out.println("비밀번호 : " + pwText.getText());
	      
	      ManagerDAO managerDao = new ManagerDAO();
	      ManagerDTO managerDto = managerDao.SelectId(idText.getText());

	     
	      
	      if(managerDto != null && managerDto.getPw().equals(pwText.getText())) {
	         CommonService.Msg("관리자님 안녕하세요 !"); 
	         return managerDto;
	         
	      }else if(managerDto != null&& !managerDto.getPw().equals(pwText.getText())){
	            CommonService.Msg("로그인 실패, 아이디 혹은 비밀번호가 맞지 않습니다.");
	           
	            idText.requestFocus();
	           
	        return null;
	      }
	           
	      return null;
	  }
	      

	   
	   public LoginDTO loginProc(Parent root) {
	      try {
			TextField idText = (TextField) root.lookup("#idText");
			  PasswordField pwText = (PasswordField) root.lookup("#pwText");
			  System.out.println("아이디 : " + idText.getText());
			  System.out.println("비밀번호 : " + pwText.getText());
			  
			  
			  LoginDAO loginDao = new LoginDAO();
			  LoginDTO loginDto = loginDao.SelectId(idText.getText());
			  if(loginDto != null && loginDto.getPw().equals(pwText.getText())) {
			        CommonService.Msg("로그인 성공");
			        return loginDto;
			        
			     }else if(loginDto != null&& !loginDto.getPw().equals(pwText.getText())){
			        CommonService.Msg("로그인 실패, 아이디 혹은 비밀번호가 맞지 않습니다.");
			        idText.clear();
			        pwText.clear();
			        idText.requestFocus();
			        
			        return null;
			       
			     }
			return null;
		} catch (Exception e) {
			System.out.println("해당 아이디 로그인 불가");
		}
	      return null;
	   }
	
	
	

}
