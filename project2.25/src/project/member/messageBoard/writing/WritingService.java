package project.member.messageBoard.writing;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.member.messageBoard.MessageController;

public class WritingService {
	private Controller controller;
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	
	public void upload(Parent boardService) {
		TextField titleText = (TextField)boardService.lookup("#titleText");
		String title = titleText.getText();
		
		Label labelId = (Label)boardService.lookup("#idLabel");
		String id = labelId.getText();
		
		
		ComboBox<String> combotreat = (ComboBox<String>)boardService.lookup("#treatment");
		String treatment = combotreat.getValue();
		
		TextArea contentText = (TextArea)boardService.lookup("#contentText");
		
		String content = contentText.getText();
		
		
		WritingDAO writDao = new WritingDAO();
		WritingDTO writDto = writDao.SelectTitle(title);
		if(writDto == null) {
			writDto = new WritingDTO();
			writDto.setTitle(title);
			writDto.setId(id);
			writDto.setTreatment(treatment);
			writDto.setContent(content);
			
			writDao.insert(writDto);
			CommonService.Msg(title + "의 글이 게재되었습니다.");
			CommonService.WindowClose(boardService);
		
			

		}
		
	}



	

//	public void open(Parent boardService) {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/ProjectMessageBoard.fxml"));
//		Parent ProjectMessageBoard;
//		
//		try {
//			
//			ProjectMessageBoard=loader.load();
//			
//			MessageController messageController = loader.getController();
//			messageController.setProjectMessageBoard(ProjectMessageBoard);
//			
//			
//			Stage stage = new Stage();
//			stage.setScene(new Scene(ProjectMessageBoard));
//			stage.setTitle("ProjectMessageBoard");
//			stage.show();
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//	}

	

}
