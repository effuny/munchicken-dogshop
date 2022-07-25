package project.manager.memberList;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.main.Controller;
import project.manager.ManagerService;
import project.manager.Product;
import project.manager.ProductDAO;
import project.manager.memberList.addBoard.AddController;
import project.manager.memberList.updatedeleteBoard.UpdateDeleteController;

public class MemberListController implements Initializable {
	
	private Parent ManagerOfficial;
	private ManagerService managerService;
	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}
	 //1
	    @FXML
	    private TableView<Product> memberTable;

	    @FXML
	    private TableColumn<Product, String> col_id;
	    @FXML
	    private TableColumn<Product, String> col_password;
	    @FXML
	    private TableColumn<Product,String> col_number;
	    @FXML
	    private TextField id_Txt;
	    @FXML
	    private PasswordField pw_Txt;
	    @FXML
	    private Button addButton;

	    @FXML
	    private Button updateButton;

	    @FXML
	    private Button deleteButton;

	    
	    public void MemberAddProc() {
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/addBoard/ProjectAddBoard.fxml"));
			Parent ProjectAddBoard;
			
			try {
				ProjectAddBoard=loader.load();
				
				controller.setAddController(loader.getController());
				AddController addController = controller.getAddController();
				addController.setProjectAddBoard(ProjectAddBoard);
				
				ComboBox<String> comboage = (ComboBox<String>)ProjectAddBoard.lookup("#ageCombo");
				if(comboage != null) {
					comboage.getItems().addAll("10대", "20대", "30대", "40대", "50대");
				}
				
				ComboBox<String> combocode = (ComboBox<String>)ProjectAddBoard.lookup("#countryCode");
				if(combocode != null) {
					combocode.getItems().addAll("+1(미국)", "+44(영국)", "+81(일본)", "+82(대한민국)", "+86(중국)");
				}
				ComboBox<String> comboPetAge = (ComboBox<String>)ProjectAddBoard.lookup("#petAge");
		         if(comboPetAge != null) {
		            
		        	 comboPetAge.getItems().addAll("1~3","4~7","7~9","10세이상");
		         }
		         ComboBox<String> comboPetBreed = (ComboBox<String>)ProjectAddBoard.lookup("#petBreed");
		         if(comboPetBreed != null) {
		            
		        	 comboPetBreed.getItems().addAll("토이푸들","보스턴테리어","말티즈","닥스훈트","요크셔테리어","비숑");
		         }	
		         
				Stage stage = new Stage();
				stage.setScene(new Scene(ProjectAddBoard));
				stage.setTitle("ProjectAddBord");
				stage.show();
				
			}catch(IOException e) {
				e.printStackTrace();
			}

	    }
	    
	    public void MemberUpdateDeleteProc() {
	    	

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

//	    public void MemberUpdateProc() {
//	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/updateBoard/ProjectUpdateBoard.fxml"));
//			Parent ProjectUpdateBoard;
//			
//			try {
//				ProjectUpdateBoard=loader.load();
//				
//				
//				UpdateController updateController = loader.getController();
//				updateController.setProjectUpdateBoard(ProjectUpdateBoard);
//				
//				Stage stage = new Stage();
//				stage.setScene(new Scene(ProjectUpdateBoard));
//				stage.setTitle("ProjectUpdateBoard");
//				stage.show();
//				
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//
//	    }
//	    public void MemberDeleteProc() {
//	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/Delete/ProjectUpdateBoard.fxml"));
//			Parent ProjectDeleteBoard;
//			
//			try {
//				ProjectDeleteBoard=loader.load();
//				
//				
//				DeleteController deleteController = loader.getController();
//				updateController.setProjectDeleteBoard(ProjectDeleteBoard);
//				
//				Stage stage = new Stage();
//				stage.setScene(new Scene(ProjectDeleteBoard));
//				stage.setTitle("ProjectUpdateBoard");
//				stage.show();
//				
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//
//	    }
	   
  
	@Override
	//창이 떳을때 딱 보이는
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.managerService = new ManagerService();
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
		col_number.setCellValueFactory(new PropertyValueFactory<>("number"));
//		ObservableList<Product> list = getProductList();
//		System.out.println("list : " + list);
		memberTable.setItems(getProductList());
	}
//	ObservableList<Product> getProductInsert(){
//		ManagerDAO dao = new ManagerDAO();
//		
//		return dao.insert();
//	}
	//3
	ObservableList<Product> getProductList() {
		ProductDAO productdao = new ProductDAO();
		return productdao.SelectAll();
	}
	public void setManagerOfficial(Parent ManagerOfficial) {
		this.ManagerOfficial = ManagerOfficial;
	} 

	
	
//	ObservableList<Product> products = FXCollections.observableArrayList();	
//			products.add(new Product("가가가","나나나"));
//			products.add(new Product("다다다","바바바"));
//			products.add(new Product("룰루","랄라"));
//			products.add(new Product("아아","아아아"));
	
//			return products;


	

}



