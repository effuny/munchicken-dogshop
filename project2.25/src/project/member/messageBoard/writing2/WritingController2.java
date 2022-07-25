package project.member.messageBoard.writing2;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import project.common.CommonService;
import project.main.Controller;

public class WritingController2 implements Initializable{
	private Parent BoardService2;
	private WritingService2 writingService2;
	private Controller controller;
	
	@FXML 
	private AnchorPane anchorpane;
	private Window win;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		writingService2 = new WritingService2();
		
		
	}

	
	  @FXML
	    void uploadImgProc(ActionEvent event) {
		  	FileChooser fc = new FileChooser();
			fc.setTitle("이미지 선택");
			fc.setInitialDirectory(new File("../"));
			
			ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png");
			fc.getExtensionFilters().add(imgType);
	
			ExtensionFilter txtType = new ExtensionFilter("text file", "*.txt", "*.doc");
	        fc.getExtensionFilters().addAll(imgType, txtType);
//	        sys
	        Stage stage = new Stage();
	        stage.setWidth(250);
	        File selectedFile =  fc.showOpenDialog(stage);
	        writingService2.setSelectedFile(selectedFile);
	       
	    }
	
//	
//    public void uploadImgProc() {
//    	
//		FileChooser fc = new FileChooser();
//		fc.setTitle("이미지 선택");
//		fc.setInitialDirectory(new File("../"));
//		
//		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png");
//		fc.getExtensionFilters().add(imgType);
//
//		ExtensionFilter txtType = new ExtensionFilter("text file", "*.txt", "*.doc");
//        fc.getExtensionFilters().addAll(imgType, txtType);
//
//        Stage stage = (Stage)anchorpane.getScene().getWindow();
//        
//        File selectedFile =  fc.showOpenDialog(stage);
//        writingService2.setSelectedFile(selectedFile);
//       
//    }
	
	public void setBoardService2(Parent BoardService2) {
		this.BoardService2 = BoardService2;
	}
	
	public void uploadProc() {
		writingService2.upload(BoardService2);
		controller.getMemberController().messageOpenProc();
		
	}
	
	public void cancelProc() {
		CommonService.WindowClose(BoardService2);
	}
}
