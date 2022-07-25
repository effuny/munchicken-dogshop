package project.manager.noticeBoard;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.manager.noticeBoard.writing.NoticeWritingController;
import project.manager.noticeBoard.writing.NoticeWritingService;



public class NoticeBoardController implements Initializable{
	private Parent NoticeBoard;
	private NoticeBoardService noticeBoardService;
	private Controller controller;	
	private Notice notice;
	
	
	
	@FXML
    private Button writingButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Notice> noticeTable;

    @FXML
    private TableColumn<Notice, String> col_title;

    @FXML
    private TableColumn<Notice, String> col_date;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	
	
	public void setNoticeBoard(Parent noticeBoard) {
		NoticeBoard = noticeBoard;
	}

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		noticeBoardService = new NoticeBoardService();
		
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("noticedate"));
		
		noticeTable.setItems(getNoticeList());
		
		
	}
	
	ObservableList<Notice> getNoticeList() {
		NoticeDAO noticedao = new NoticeDAO();
		return noticedao.SelectAll();
		
	}
	
	@FXML
    void WritingProc(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/noticeBoard/writing/NoticeWriting.fxml"));
		Parent NoticeWriting;
		
		try {
			NoticeWriting=loader.load();
			
			
			NoticeWritingService noticeWritingService = new NoticeWritingService();
			noticeWritingService.setController(controller);
			
			controller.setNoticeWritingController(loader.getController());
			NoticeWritingController noticeWritingController = controller.getNoticeWritingController();
			noticeWritingController.setNoticeWriting(NoticeWriting);
			
			
			
			
			Stage stage = new Stage();
			stage.setScene(new Scene(NoticeWriting));
			stage.setTitle("NoticeWriting");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		CommonService.WindowClose(NoticeBoard);
    }
		

    @FXML
    void DeleteProc(ActionEvent event) {
    	Notice p2 = noticeTable.getItems().get(noticeTable.getSelectionModel().getSelectedIndex());
    	NoticeDAO noticedao = new NoticeDAO();
    	noticedao.delete(p2.getTitle());
    	noticeTable.getItems().removeAll(noticeTable.getSelectionModel().getSelectedItems());
    	
    	
    }
	
	
	
	
	
}
	
	
	
	
	
	
	
