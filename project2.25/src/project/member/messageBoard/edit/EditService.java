package project.member.messageBoard.edit;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import project.common.CommonService;
import project.member.messageBoard.writing.WritingDAO;
import project.member.messageBoard.writing.WritingDTO;

public class EditService {

	public void edit(Parent editForm) {
		TextField titleText = (TextField)editForm.lookup("#editTitle");
		String title = titleText.getText();
		
		Label labelId = (Label)editForm.lookup("#idLabel");
		String id = labelId.getText();
		
		ComboBox<String> combotreat = (ComboBox<String>)editForm.lookup("#treatment");
		String treatment = combotreat.getValue();
		
		TextArea contentText = (TextArea)editForm.lookup("#editText");
		String content = contentText.getText();
		
		WritingDAO writDao = new WritingDAO();
		WritingDTO writDto = writDao.SelectTitle(title);
			writDto = new WritingDTO();
			writDto.setTitle(title);
			writDto.setId(id);
			writDto.setTreatment(treatment);
			writDto.setContent(content);
			
			writDao.update(writDto);
			CommonService.Msg(title + "의 글이 수정되었습니다.");
			CommonService.WindowClose(editForm);
		
		
	}

}
