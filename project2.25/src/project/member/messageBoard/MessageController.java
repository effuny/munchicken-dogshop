package project.member.messageBoard;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.member.messageBoard.pwCheck.PwCheckController;
import project.member.messageBoard.select.SelectController;
import project.member.messageBoard.select2.SelectController2;
import project.member.messageBoard.writing.WritingController;
import project.member.messageBoard.writing2.WritingController2;

public class MessageController implements Initializable{
	private Parent ProjectMessageBoard;
	private MessageService messageService;
	private Controller controller;
	private Review review;

	  @FXML
	    private TabPane tabPane;
	  
	  @FXML
	    private Tab gReviews;
	
	@FXML
    private Button writingButton;

    @FXML
    private TableView<Review> beautyTable;

    @FXML
    private TableColumn<Review, String> col_title;
    
    @FXML
    private TableColumn<Review, String> col_id;

    @FXML
    private TableColumn<Review, String> col_treatment;

    @FXML
    private TableColumn<Review, String> col_content;
    

    @FXML
    private TableView<Review2> productTable;

    @FXML
    private TableColumn<Review2, String> pcol_title;

    @FXML
    private TableColumn<Review2, String> pcol_id;

    @FXML
    private TableColumn<Review2, String> pcol_product;

    @FXML
    private TableColumn<Review2, String> pcol_content;
    
   

 
	public Controller getController() {
		return controller;
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messageService = new MessageService();
		
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
		col_content.setCellValueFactory(new PropertyValueFactory<>("content"));
		
		beautyTable.setItems(getReviewList());
		
		pcol_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		pcol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		pcol_product.setCellValueFactory(new PropertyValueFactory<>("product"));
		pcol_content.setCellValueFactory(new PropertyValueFactory<>("content"));
		
		productTable.setItems(getReviewList2());
	}
	
	
	ObservableList<Review> getReviewList() {
		MessageDAO messagedao = new MessageDAO();
		return messagedao.SelectAll();
	}
	
	ObservableList<Review2> getReviewList2() {
		MessageDAO messagedao = new MessageDAO();
		return messagedao.SelectAll2();
	}
	
	public void setProjectMessageBoard(Parent ProjectMessageBoard) {
		this.ProjectMessageBoard = ProjectMessageBoard;
	}
	
	
	
	 @FXML
     public void selectTitle(MouseEvent event) {
		 
  
     Review p1 = beautyTable.getItems().get(beautyTable.getSelectionModel().getSelectedIndex());
     
     if (event.getClickCount() == 2  ) {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/select/SelectForm.fxml"));
    	 Parent SelectForm;
    
		    try {
		    	SelectForm =loader.load();
		       
		    	
		    	controller.setSelectController(loader.getController());
		    	
		       SelectController selectController = controller.getSelectController();
		       selectController.setSelectForm(SelectForm);
		       
		       TextField title = (TextField)SelectForm.lookup("#selectTitle");
		       title.setText(p1.getTitle());
		       
		       TextArea text = (TextArea)SelectForm.lookup("#selectText");
		       text.setText(p1.getContent());
		       
		       Label labelId = (Label)SelectForm.lookup("#idLabel");
				labelId.setText(p1.getId());
				
				ComboBox<String> treatment = (ComboBox<String>)SelectForm.lookup("#selectService");
		         if(treatment != null) {
		            treatment.setValue(p1.getTreatment());
		         }
		       
		       Stage stage = new Stage();
		       stage.setScene(new Scene(SelectForm));
		       stage.setTitle("selectForm");
		       stage.show();
		       
		    }catch(IOException e) {
		       e.printStackTrace();
		    }
     }
 }
	 
	 @FXML
	    void selectTable(MouseEvent event) {
			Review2 p3 = productTable.getItems().get(productTable.getSelectionModel().getSelectedIndex());
			if(event.getClickCount() == 2 ) {
				
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/select2/SelectForm2.fxml"));
			Parent SelectForm2;
			
			try {
				SelectForm2 =loader.load();
				
				SelectController2 selectController2 = loader.getController();
				selectController2.setSelectForm2(SelectForm2);
				
				ComboBox<String> product = (ComboBox<String>)SelectForm2.lookup("#selectService");
				if(product != null) {
					product.setValue(p3.getProduct());
				}

				FileInputStream fis = new FileInputStream(p3.getImg());
				BufferedInputStream bis = new BufferedInputStream(fis);
				
				Image image = new Image(bis);
				ImageView img = (ImageView)SelectForm2.lookup("#img");
				img.setImage(image);
				
				TextField title = (TextField)SelectForm2.lookup("#selectTitle");
			       title.setText(p3.getTitle());
			    Label labelId = (Label)SelectForm2.lookup("#selectId");
			    	labelId.setText(p3.getId());
			    TextArea text = (TextArea)SelectForm2.lookup("#selectText");
			       text.setText(p3.getContent());
			       
			       
				Stage stage = new Stage();
				stage.setScene(new Scene(SelectForm2));
				stage.setTitle("BoardService");
				stage.show();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			}
			
	    }
	
	
	
	//글쓰기 오픈 process
	@FXML
    void WritingProc(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/writing/BoardService.fxml"));
		Parent BoardService;
		
		try {
			BoardService=loader.load();
			
			controller.setWritingController(loader.getController());
			WritingController writingController = controller.getWritingController();
			writingController.setBoardService(BoardService);
			
		
			Label labelId = (Label)BoardService.lookup("#idLabel");
			labelId.setText(controller.getLoginDto().getId());
			
			ComboBox<String> treatment = (ComboBox<String>)BoardService.lookup("#treatment");
			if(treatment != null) {
				treatment.getItems().addAll("전체클리링(올빡)", "부분미용+목욕+얼굴컷", "몸클리핑+부분가위컷", "전체가위컷");
			}
			
		
			Stage stage = new Stage();
			stage.setScene(new Scene(BoardService));
			stage.setTitle("BoardService");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		CommonService.WindowClose(ProjectMessageBoard);

    }
	
	@FXML
    void Writing2Proc(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/writing2/BoardService2.fxml"));
		Parent BoardService2;
		
		try {
			BoardService2=loader.load();
			
			controller.setWritingController2(loader.getController());
			WritingController2 writingController2 = controller.getWritingController2();
			writingController2.setBoardService2(BoardService2);
			
			Label labelId = (Label)BoardService2.lookup("#idLabel");
			labelId.setText(controller.getLoginDto().getId());
			
			
			ComboBox<String> product = (ComboBox<String>)BoardService2.lookup("#product");
			if(product != null) {
				product.getItems().addAll("뽁뽁이", "코끼리 라텍스장난감", "코끼리 봉제인형", "긴팔 원숭이 인형", "봉제삑삑이 고추 장난감");
			}
			
			Stage stage = new Stage();
			stage.setScene(new Scene(BoardService2));
			stage.setTitle("BoardService2");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		CommonService.WindowClose(ProjectMessageBoard);
		
		
		
    }
	
	@FXML
	void DeleteProc(ActionEvent event) {
		
		
	     Review p2 = beautyTable.getItems().get(beautyTable.getSelectionModel().getSelectedIndex());
	     if(p2.getId().equals(controller.getLoginDto().getId())) {
	     MessageDAO messagedao = new MessageDAO();
			messagedao.delete(p2.getTitle());
		beautyTable.getItems().removeAll(beautyTable.getSelectionModel().getSelectedItems());
	     } else  {
	     	CommonService.Msg("다른 사용자의 글을 삭제할 수 없습니다");
	     }
	}
	
	@FXML
    void ProDeleteProc(ActionEvent event) {
		
		 Review2 p4 = productTable.getItems().get(productTable.getSelectionModel().getSelectedIndex());
	     if(controller.getLoginDto().getId().equals(p4.getId())) {
		 MessageDAO messagedao = new MessageDAO();
			messagedao.delete2(p4.getTitle());
			productTable.getItems().removeAll(productTable.getSelectionModel().getSelectedItems());
	     } else {
	     	CommonService.Msg("다른 사용자의 글을 삭제할 수 없습니다");
	     }
    }
	
	@FXML
    void EditProc(ActionEvent event) {
      Review p2 = beautyTable.getItems().get(beautyTable.getSelectionModel().getSelectedIndex());
      if(p2.getId().equals(controller.getLoginDto().getId())) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/messageBoard/pwCheck/PwCheck.fxml"));
      Parent pwCheck;
      
      try {
         pwCheck=loader.load();
         
         controller.setPwCheckController(loader.getController());
         PwCheckController pwCheckController = controller.getPwCheckController();
         pwCheckController.setPwCheck(pwCheck);
         pwCheckController.setP2(p2);
         

         Label labelId = (Label)pwCheck.lookup("#idLabel");
         labelId.setText(p2.getId());

         
         
         Stage stage = new Stage();
         stage.setScene(new Scene(pwCheck));
         stage.setTitle("pwCheck");
         stage.show();
         
      }catch(IOException e) {
         e.printStackTrace();
      }
      CommonService.WindowClose(ProjectMessageBoard);

    }else {
    	CommonService.Msg("다른 사용자의 글을 수정할 수 없습니다");
    }
	
	}
	

}
