package project.member.dogItem.bucket;

import java.net.URL; 
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.common.CommonService;
import project.login.LoginController;
import project.main.Controller;
import project.member.dogItem.DogShopDAO;

public class bucketListController implements Initializable {
	@FXML
	private Label totaltxt;
	@FXML
	private Button goout;
	@FXML
	private Label loginidtxt;
	
	private Parent bucketList;
	
//	private DogShopDAO dogShopDao;
	
	
	
//	
//	 public void setDogShopDao(DogShopDAO dogShopDao) {
//		this.dogShopDao = dogShopDao;
//	}

	    @FXML
	    private TableView<BucketDTO> tableview2;
	 
	    @FXML
	    private TableColumn<BucketDTO, String> bucketName;

	    @FXML
	    private TableColumn<BucketDTO, String> bucketInfor;

	    @FXML
	    private TableColumn<BucketDTO, String> bucketPrice;

	    private Controller controller;
	    
	    
	    
	    
	
	public void setController(Controller controller) {
			this.controller = controller;
		}

	public void setBucketList(Parent bucketList) {
		this.bucketList = bucketList;
//		System.out.println("여기??? : " + controller.getLoginDto().getId());
	}

	@FXML
	public void goout(ActionEvent event) {
		
		CommonService.WindowClose(bucketList);
	}
	
	public void show() {
		bucketName.setCellValueFactory(new PropertyValueFactory<>("name"));
		bucketInfor.setCellValueFactory(new PropertyValueFactory<>("infor"));
		bucketPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		tableview2.setItems(getProductList());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//		bucketName.setCellValueFactory(new PropertyValueFactory<>("name"));
//		bucketInfor.setCellValueFactory(new PropertyValueFactory<>("infor"));
//		bucketPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
//		
//		tableview2.setItems(getProductList());
		
	}
	
	ObservableList<BucketDTO> getProductList() {
		
		DogShopDAO dogShopDao = new DogShopDAO();
		dogShopDao.setController(controller);
	
		
		return dogShopDao.SelectIdList();
	}
	
	
}
