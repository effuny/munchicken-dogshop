package project.member.reserve;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.common.CommonService;
import project.main.Controller;
import project.manager.reserveList.ReserveDAO;
import project.manager.reserveList.ReserveDTO;
import project.manager.reserveList.ReserveListController;

public class ReserveController implements Initializable {
	
	private Parent reserveForm;
	private ReserveService reserveService;
	private Controller controller;
	
    @FXML
    private DatePicker datePicker;
    
    public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

    

	public void setReserveForm(Parent reserveForm) {
		this.reserveForm = reserveForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		reserveService = new ReserveService();
		
	}
	
	 
	 public void addReserveProc() {
//		 reserveService.reserveRegister(reserveForm);
			ComboBox<String> serviceHour = (ComboBox<String>)reserveForm.lookup("#serviceHour");
			String hourPick = serviceHour.getValue();

			TextField reserveName = (TextField)reserveForm.lookup("#name");
			String name = reserveName.getText();
			
			
			ComboBox<String> service = (ComboBox<String>)reserveForm.lookup("#service");
			String servicePick = service.getValue();
			
			LocalDate serviceDate = datePicker.getValue();
			
			ReserveDTO reserveDto = new ReserveDTO(name, servicePick, serviceDate.toString(), hourPick, controller.getLoginDto().getId());
			
			ReserveDAO reserveDao = new ReserveDAO();
			reserveDao.addReserve(reserveDto);
			
			CommonService.Msg("등록완료");
		
	    }
	 
	   @FXML
	    void exitProc(ActionEvent event) {
		   CommonService.WindowClose(reserveForm);
	    }
	   
	   
	   @FXML
	    void reserveListopen(ActionEvent event) {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/reserveList/ReserveList.fxml"));
			Parent reserveList;
			

			try {
				reserveList = loader.load();
				
				controller.setReserveListController(loader.getController());
				ReserveListController reserveListController = controller.getReserveListController();
				reserveListController.setReserveList(reserveList);
				
				Scene scene = new Scene(reserveList);
				Stage primaryStage = new Stage();
				primaryStage.setTitle("ReserveList");
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
			}catch(IOException e){
				e.printStackTrace();
			}
	    }


	
	

}
