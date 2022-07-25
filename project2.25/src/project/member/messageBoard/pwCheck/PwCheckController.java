package project.member.messageBoard.pwCheck;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.member.messageBoard.Review;
import project.member.messageBoard.edit.EditController;

public class PwCheckController implements Initializable{
	private Parent PwCheck;
	private CheckService checkService;
	private Controller controller;
	private Review p2;
	

	public void setP2(Review p2) {
		this.p2 = p2;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
    @FXML
    void checkProc(ActionEvent event) {
    	
    	TextField pwtext = (TextField)PwCheck.lookup("#pwText");
    	String pw = pwtext.getText();
    	if(controller.getLoginDto().getPw().equals(pw)){ 
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/edit/EditForm.fxml"));
		Parent EditForm;
		
		try {
			
			EditForm =loader.load();
			
			EditController editController = loader.getController();
			editController.setEditForm(EditForm);
			
			ComboBox<String> treatment = (ComboBox<String>)EditForm.lookup("#treatment");
			if(treatment != null) {
				treatment.getItems().addAll("전체클리링(올빡)", "부분미용+목욕+얼굴컷", "몸클리핑+부분가위컷", "전체가위컷");
			}
			
			TextField title = (TextField)EditForm.lookup("#editTitle");
		       title.setText(p2.getTitle());
		       
		    Label labelId = (Label)EditForm.lookup("#idLabel");
		    labelId.setText(p2.getId());
		       
		    TextArea text = (TextArea)EditForm.lookup("#editText");
		       text.setText(p2.getContent());
			
		       
		       
			Stage stage = new Stage();
			stage.setScene(new Scene(EditForm));
			stage.setTitle("EditForm");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		}else {
			CommonService.Msg("비밀번호를 확인해주세요.");
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		checkService = new CheckService();
		
	}
	
	
	public void CheckcancelProc() {
		CommonService.WindowClose(PwCheck);
		controller.getMemberController().messageOpenProc();
	}
	
	public void setPwCheck(Parent pwCheck) {
		this.PwCheck = pwCheck;
	}

}
