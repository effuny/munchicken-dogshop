package project.member.dogItem;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.member.dogItem.bucket.BucketDTO;
import project.member.dogItem.bucket.bucketListController;
import project.member.messageBoard.select.SelectController;



public class DogShopController implements Initializable{
	
	private DogShopService shopService;
	private Parent ProjectDogShop;
	
	@FXML
	private TableView<DogShopProduct> tableview1;
	@FXML
	private TableColumn<DogShopProduct, Integer> Num;
	@FXML
	private TableColumn<DogShopProduct, String> Name;
	@FXML
	private AnchorPane txtImage;
	@FXML
	private TextField txtprice;
	@FXML
	private TextArea txtInfor;
	@FXML
	private TextField txtname;
	@FXML
	private Button exit;
	@FXML
	private Button gobasket;
	@FXML
	private Button Steaming;
	@FXML
	private ImageView ItemImage;
	
	private Controller controller;
	
	private List<DogShopProduct> ListNum(){
		
		return list;
		
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	


	public void setProjectDogShop(Parent projectDogShop) {
		this.ProjectDogShop = projectDogShop;
	}
	
	
	    @FXML
	    void itemClick(MouseEvent event) {
		 try {
			DogShopProduct p1 = tableview1.getItems().get(tableview1.getSelectionModel().getSelectedIndex());
				txtname.setText(p1.getName());
				txtprice.setText(p1.getPrice());
				txtInfor.setText(p1.getInfor());
				Image image = new Image(getClass().getResourceAsStream(p1.getToyimg()));
//			System.out.println(" 이미지 값 : " + getClass().getResourceAsStream(p1.getToyimg()));
//			Image image = new Image(p1.getToyimg());
				ItemImage.setImage(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		 

	    }
	
	// Event Listener on Button[#exit].onAction
	@FXML
	public void exit(ActionEvent event) {
		
	}
	// Event Listener on Button[#gobasket].onAction
	
	  @FXML
	    void keepProc(ActionEvent event) {
		  DogShopProduct p1 = tableview1.getItems().get(tableview1.getSelectionModel().getSelectedIndex());
		  BucketDTO bucketDto = new BucketDTO();
		  bucketDto.setInfor(p1.getInfor());
		  bucketDto.setName(p1.getName());
		  bucketDto.setPrice(p1.getPrice());
		  bucketDto.setId(controller.getLoginDto().getId());
		  
		  DogShopDAO dogShopDao = new DogShopDAO();
		  dogShopDao.addBucket(bucketDto);
		  
		  CommonService.Msg("장바구니로 이동 되었습니다");
		  
		  

	    }
	  
	  
	  @FXML
	    void bucketMove(ActionEvent event) {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/member/dogItem/bucket/bucketList.fxml"));
			Parent bucketList;
			
			 try {
				 	bucketList = loader.load();
				 	
				 	System.out.println("여기2 : " + controller.getLoginDto().getId());
			       
			    	
			    	controller.setBucketListController(loader.getController());
			    	bucketListController bucketListController = controller.getBucketListController();
					bucketListController.setBucketList(bucketList);
			       
			       
					Label label = (Label)bucketList.lookup("#loginidtxt");
					label.setText(controller.getLoginDto().getId());
					
					bucketListController.show();
					
					
					
					
			       Stage stage = new Stage();
			       stage.setScene(new Scene(bucketList));
			       stage.setTitle("bucketList");
			       stage.show();
			       
			    }catch(IOException e) {
			       e.printStackTrace();
			    }
	     }
	  
	  @FXML
	    void cancelProc(ActionEvent event) {
		  CommonService.WindowClose(ProjectDogShop);

	    }
			
			
			

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.shopService = new DogShopService();
//		setCellValueFromTableTextField();
		
		Num.setCellValueFactory(new PropertyValueFactory<>("num"));
		Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		tableview1.setItems(getProductList());}
		ObservableList<DogShopProduct> list = getProductList();
		   ObservableList<DogShopProduct> getProductList() {
			   DogShopDAO dao = new DogShopDAO();
//			   dao.setController(controller);
			      return dao.selectNum();
			  


	}
}
