package project.manager.memberList.updatedeleteBoard;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.manager.memberList.updatedeleteBoard.updateBoard.UpdateDAO;

public class UpdateDeleteController implements Initializable{
	private Parent ProjectUpdateDeleteBoard;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private Controller controller;

	  @FXML
	    private TableView<UserProduct> UserTable;

	@FXML
	private TableColumn<UserProduct,String> user_id;
	
    @FXML
    private TableColumn<UserProduct,String> user_password;

    @FXML
    private TableColumn<UserProduct,String> user_age;

    @FXML
    private TableColumn<UserProduct,String> user_gender;
    
    @FXML
    private TableColumn<UserProduct,String> user_countryCode;

    @FXML
    private TableColumn<UserProduct,String> user_number;

    @FXML
    private TableColumn<UserProduct,String> dog_name;

    @FXML
    private TableColumn<UserProduct,String> dog_sex;

    @FXML
    private TableColumn<UserProduct,String> dog_age;

    @FXML
    private TableColumn<UserProduct,String> dog_breed;

    @FXML
    private TextField id_Txt;
    
    @FXML
    private TextField pw_Txt;

    @FXML
    private TextField age_Txt;

    @FXML
    private TextField gender_Txt;
    
    @FXML
    private TextField countrycode_Txt;

    @FXML
    private TextField number_Txt;

    @FXML
    private TextField dogname_Txt;

    @FXML
    private TextField dogsex_Txt;

    @FXML
    private TextField dogage_Txt;

    @FXML
    private TextField dogbreed_Txt;

    
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCellValueFromTableTextField();

		user_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		user_password.setCellValueFactory(new PropertyValueFactory<>("password"));
		user_age.setCellValueFactory(new PropertyValueFactory<>("age"));
		user_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		user_countryCode.setCellValueFactory(new PropertyValueFactory<>("countryCode"));
		user_number.setCellValueFactory(new PropertyValueFactory<>("number"));

		dog_name.setCellValueFactory(new PropertyValueFactory<>("dogName"));
		dog_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
		dog_age.setCellValueFactory(new PropertyValueFactory<>("dogAge"));
		dog_breed.setCellValueFactory(new PropertyValueFactory<>("breed"));

		UserTable.setItems(getUserProductList());

	}
	
	private void setCellValueFromTableTextField() {
		UserTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				UserProduct userPro = UserTable.getItems().get(UserTable.getSelectionModel().getSelectedIndex());
				
				id_Txt.setText(userPro.getId());
				pw_Txt.setText(userPro.getPassword());
				gender_Txt.setText(userPro.getGender());
				age_Txt.setText(userPro.getAge());
				countrycode_Txt.setText(userPro.getCountryCode());
				number_Txt.setText(userPro.getNumber());
				dogname_Txt.setText(userPro.getDogName());
				dogsex_Txt.setText(userPro.getSex());
				dogage_Txt.setText(userPro.getAge());
				dogbreed_Txt.setText(userPro.getBreed());
				
//				userPro.setId(id_Txt.getText());
//				userPro.setPassword(pw_Txt.getText());
//				userPro.setGender(gender_Txt.getText());
//				userPro.setAge(age_Txt.getText());
//				userPro.setNumber(number_Txt.getText());
//				userPro.setDogName(dogsex_Txt.getText());
//				userPro.setSex(dogsex_Txt.getText());
//				userPro.setDogAge(dogage_Txt.getText());
//				userPro.setBreed(dogbreed_Txt.getText());
//				
//				gender_Txt.getText(userPro.getGender());
//				age_Txt.setText(userPro.getAge());
//				number_Txt.setText(userPro.getNumber());
//				dogname_Txt.setText(userPro.getDogName());
//				dogsex_Txt.setText(userPro.getSex());
//				dogage_Txt.setText(userPro.getAge());
//				dogbreed_Txt.setText(userPro.getBreed())
				
			
				
			}
		});
			
	
		}
	
//	private void setCellValueFromTableToTextField() {
//	
//		UserTable.setOnMouseClicked (e -> {
////			PreparedStatement ps;
//			UserProduct userPro = UserTable.getItems().get(UserTable.getSelectionModel().getSelectedIndex());
//			id_Txt.setText(userPro.getId());
//			pw_Txt.setText(userPro.getPassword());
//			gender_Txt.setText(userPro.getGender());
//			age_Txt.setText(userPro.getAge());
//			number_Txt.setText(userPro.getNumber());
//			dogname_Txt.setText(userPro.getDogName());
//			dogsex_Txt.setText(userPro.getSex());
//			dogage_Txt.setText(userPro.getAge());
//			dogbreed_Txt.setText(userPro.getBreed());
//		});
//		
//	}
		
	ObservableList<UserProduct> getUserProductList(){
		UserDAO userDao = new UserDAO();
		
		return userDao.SelectAll();
		
	}
	public void setProjectUpdateDeleteBoard(Parent projectUpdateDeleteBoard) {
		this.ProjectUpdateDeleteBoard = projectUpdateDeleteBoard;
	}
	//수정하기 버튼
	public void MemberUpdateProc() {
		
		UserProduct userPro = new UserProduct();
		userPro.setId(id_Txt.getText());
		userPro.setPassword(pw_Txt.getText());
		userPro.setGender(gender_Txt.getText());
		userPro.setAge(age_Txt.getText());
		userPro.setCountryCode(countrycode_Txt.getText());
		userPro.setNumber(number_Txt.getText());
		userPro.setDogName(dogname_Txt.getText());
		userPro.setSex(dogsex_Txt.getText());
		userPro.setDogAge(dogage_Txt.getText());
		userPro.setBreed(dogbreed_Txt.getText());
		
//		UserProduct userPro = UserTable.getItems().get(UserTable.getSelectionModel().getSelectedIndex());
		
		UpdateDAO updateDao = new UpdateDAO();
		updateDao.updateUpdate(userPro);
		CommonService.Msg("등록이 완료됬습니다.");
		CommonService.WindowClose(ProjectUpdateDeleteBoard);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/updatedeleteBoard/ProjectUpdateDeleteBoard.fxml"));
		Parent ProjectUpdateDeleteBoard;
		
		try {
			ProjectUpdateDeleteBoard=loader.load();
			
			controller.setUpdatedeleteController(loader.getController());
			UpdateDeleteController updatedeleteCotroller = controller.getUpdatedeleteController();
			updatedeleteCotroller.setProjectUpdateDeleteBoard(ProjectUpdateDeleteBoard);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(ProjectUpdateDeleteBoard));
			stage.setTitle("ProjectUpdateDeleteBoard");
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}
//	
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/updatedeleteBoard/updateBoard/ProjectUpdateBoard.fxml"));
//		Parent projectUpdateBoard;
//		try {
//			projectUpdateBoard = loader.load();
//			
//			controller.setUpdateController(loader.getController());
//			UpdateController updateController = loader.getController();
//			updateController.setProjectUpdateBoard(projectUpdateBoard);
//			
//			ComboBox<String> comboage = (ComboBox<String>)projectUpdateBoard.lookup("#ageCombo");
//			if(comboage != null) {
//				comboage.getItems().addAll("10대", "20대", "30대", "40대", "50대");
//			}
//			
//			ComboBox<String> combocode = (ComboBox<String>)projectUpdateBoard.lookup("#countryCode");
//			if(combocode != null) {
//				combocode.getItems().addAll("+1(미국)", "+44(영국)", "+81(일본)", "+82(대한민국)", "+86(중국)");
//			}
//			ComboBox<String> comboPetAge = (ComboBox<String>)projectUpdateBoard.lookup("#petAge");
//	         if(comboPetAge != null) {
//	            
//	        	 comboPetAge.getItems().addAll("1~3","4~7","7~9","10세이상");
//	         }
//	         ComboBox<String> comboPetBreed = (ComboBox<String>)projectUpdateBoard.lookup("#petBreed");
//	         if(comboPetBreed != null) {
//	            
//	        	 comboPetBreed.getItems().addAll("토이푸들","보스턴테리어","말티즈","닥스훈트","요크셔테리어","비숑");
//	         }	
//	         
//			
//			Scene scene = new Scene(projectUpdateBoard);
//			Stage primaryStage = new Stage();
//			primaryStage.setTitle("ProjectUpdateBoard");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//			
//			
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		
//
//	}
		
			

	// 삭제하기 버튼
//	public void MemberDeleteProc() {
//		 UserProduct p4 = UserTable.getItems().get(UserTable.getSelectionModel().getSelectedIndex());
//	     
//		 UserDAO userDao = new UserDAO();
//			userDao.delete(p4);
//			UserTable.getItems().removeAll(UserTable.getSelectionModel().getSelectedItems());
//	      
//
//	}
}
