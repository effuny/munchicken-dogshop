package project.member.notice;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.manager.noticeBoard.Notice;
import project.manager.noticeBoard.NoticeDAO;
import project.member.notice.selet.NoticeMemController;

public class NoticeMemberController implements Initializable{
	private Parent NoticeMember;
	private NoticeMemberService noticeMemSvc;
	private Controller controller;
	private Notice notice;
	

    @FXML
    private Button exitButton;

    @FXML
    private TableView<Notice> noticeMemTable;

    @FXML
    private TableColumn<Notice, String> col_title;

    @FXML
    private TableColumn<Notice, String> col_date;

	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setNoticeMember(Parent noticeMember) {
		NoticeMember = noticeMember;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		noticeMemSvc = new NoticeMemberService();
		
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("noticedate"));
		noticeMemTable.setItems(getNoticeList());
		
	}
	ObservableList<Notice> getNoticeList() {
		NoticeDAO noticedao = new NoticeDAO();
		return noticedao.SelectAll();
		
	}
	
	@FXML
    void seletTitle(MouseEvent event) {
		Notice p1 = noticeMemTable.getItems().get(noticeMemTable.getSelectionModel().getSelectedIndex());
		System.out.println(p1.getTitle());
		System.out.println(p1.getContent());
		System.out.println(p1.getNoticedate());
		
		if(event.getClickCount() == 2 ) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/notice/selet/NotMSelectForm.fxml"));
			Parent NotMSelectForm;
			try {
				
				NotMSelectForm = loader.load();	
				
				
				NoticeMemController noticeMemController = loader.getController();
				noticeMemController.setNotMSeletForm(NotMSelectForm);
				
				TextField title = (TextField)NotMSelectForm.lookup("#selectTitle");
					title.setText(p1.getTitle());
				Label date = (Label)NotMSelectForm.lookup("#dateLabel");
				date.setText(p1.getNoticedate());
				TextArea text = (TextArea)NotMSelectForm.lookup("#selectText");
				text.setText(p1.getContent());
				
				
				Stage stage = new Stage();
				stage.setScene(new Scene(NotMSelectForm));
				stage.setTitle("NotMSelectForm");
				stage.show();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	}
	
	  @FXML
	    void exitPro(ActionEvent event) {
		  CommonService.WindowClose(NoticeMember);
		  
		  

	    }
	
	
}
