package project.manager.dogItemset;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;

public class DogitemController implements Initializable{
	
	private Controller controller;
	private Parent dogItem;
	private DogitemController dogitemService;
	
    @FXML
    private TableView<DogitemDTO> showitem;
	@FXML
	private TableColumn<DogitemDTO, Integer> showNum;
	@FXML
	private TableColumn<DogitemDTO, String> showName;
	@FXML
	private TableColumn<DogitemDTO, String> showprice;
	@FXML
    private TextField newNumtxt;
	
	
	@FXML
	private Button exitbutton;
	@FXML
	private Button setitembutton;
	

	

	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	public void setDogitem(Parent dogitem) {
		dogItem = dogitem;
	}



	public void DogItemset() {
		
		TextField newNumtxt = (TextField)dogItem.lookup("#newNumtxt");
		String newNum = newNumtxt.getText();
		Integer.parseInt(newNum);
		
		TextField newNametxt = (TextField)dogItem.lookup("#newNametxt");
		String newName = newNametxt.getText();
		
		TextField newPricetxt = (TextField)dogItem.lookup("#newPricetxt");
		String newPrice = newPricetxt.getText();
		
		TextArea newInfortxt = (TextArea)dogItem.lookup("#newInfortxt");
		String newInfor = newInfortxt.getText();
		
		TextField newImgtxt = (TextField)dogItem.lookup("#newImgtxt");
		String newImg = newImgtxt.getText();
		
		DogitemDAO dogitemDAO = new DogitemDAO();
		DogitemProduct dogitemProduct = new DogitemProduct();
		
			dogitemProduct = new DogitemProduct();
			dogitemProduct.setNewnum(Integer.parseInt(newNum));
			dogitemProduct.setNewname(newName);
			dogitemProduct.setNewprice(newPrice);
			dogitemProduct.setNewinfor(newInfor);
			dogitemProduct.setNewtoyimg(newImg);
			
			dogitemDAO.insertItem(dogitemProduct);
			
			CommonService.Msg("등록이 완료되었습니다.");
			
			CommonService.WindowClose(dogItem);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/dogItemset/Dogitem.fxml"));
			Parent dogItem;
			
			try {
				dogItem = loader.load();
				
				controller.setDogitemController(loader.getController());
				 DogitemController dogitemController = controller.getDogitemController();
				 dogitemController.setDogitem(dogItem);
				
				Scene scene = new Scene(dogItem);
				Stage primaryStage = new Stage();
				primaryStage.setTitle("물품등록화면");
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
			}catch(IOException e){
				e.printStackTrace();
			}	
			
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.dogitemService = new DogitemController();
		DogitemDAO Dao = new DogitemDAO();
//		DogitemProduct dp = Dao.maxValue();
		newNumtxt.setText(Integer.toString(Dao.maxValue().getNewnum()));
		
		showNum.setCellValueFactory(new PropertyValueFactory<>("num"));
		showName.setCellValueFactory(new PropertyValueFactory<>("name"));
		showprice.setCellValueFactory(new PropertyValueFactory<>("price"));
		showitem.setItems(getDogitemDTOs());}
	
	
//		ObservableList<DogitemDTO> list = getDogitemDTOs();
		
		
		ObservableList<DogitemDTO> getDogitemDTOs(){
			DogitemDAO dao = new DogitemDAO();
			
			return dao.showNum();
			
	}
		  @FXML
		    void exitProc(ActionEvent event) {
			  CommonService.WindowClose(dogItem);

		    }



}
