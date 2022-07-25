package project.member.messageBoard.writing2;

import java.io.File;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import project.common.CommonService;


public class WritingService2 {
	private File selectedFile;
	
	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	public void upload(Parent boardService2) {
		TextField titleText = (TextField)boardService2.lookup("#titleText");
		String title = titleText.getText();
		
		Label labelId = (Label)boardService2.lookup("#idLabel");
		String id = labelId.getText();
		
		ComboBox<String> comboproduct = (ComboBox<String>)boardService2.lookup("#product");
		String product = comboproduct.getValue();
		
		TextArea contentText = (TextArea)boardService2.lookup("#contentText");
		String content = contentText.getText();
		
		 
		String img = selectedFile.toString();
		
		WritingDAO2 writDao2 = new WritingDAO2();
		WritingDTO2 writDto2 = writDao2.SelectTitle(title);
			writDto2 = new WritingDTO2();
			writDto2.setTitle(title);
			writDto2.setId(id);
			writDto2.setProduct(product);
			writDto2.setContent(content);
			writDto2.setImg(img);
			
			
			writDao2.insert(writDto2);
			CommonService.Msg(title + "의 글이 게재되었습니다.");
			CommonService.WindowClose(boardService2);
		
	}

	

	

}
