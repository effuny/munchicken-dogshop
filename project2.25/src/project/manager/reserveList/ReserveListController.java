package project.manager.reserveList;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.login.LoginDAO;
import project.login.LoginDTO;
import project.main.Controller;
import project.manager.ManagerDAO;
import project.manager.ManagerDTO;

public class ReserveListController implements Initializable {
	
	 	private Parent reserveList;
	 	private Controller controller;
	
	 	@FXML
	    private TableView<ReserveDTO> reserveTable;

	    @FXML
	    private TableColumn<ReserveDTO, String> col_name;

	    @FXML
	    private TableColumn<ReserveDTO, String> col_date;

	    @FXML
	    private TableColumn<ReserveDTO, String> col_hour;

	    @FXML
	    private TableColumn<ReserveDTO, String> col_service;
	    
	    @FXML
	    private TableColumn<ReserveDTO, String> col_id;
	
	
	    public void setReserveList(Parent reserveList) {
		this.reserveList = reserveList;
	}
	 
	
	
	public void setController(Controller controller) {
			this.controller = controller;
		}






	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("serviceDate"));
		col_hour.setCellValueFactory(new PropertyValueFactory<>("serviceHour"));
		col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

		reserveTable.setItems(getReserveList());
	}

	ObservableList<ReserveDTO> getReserveList() {
		ReserveDAO reservedao = new ReserveDAO();
		return reservedao.SelectAll();
	} 
	
	@FXML
    void deleteReserveProc(ActionEvent event) {
		

	     ReserveDTO reserveDto = reserveTable.getItems().get(reserveTable.getSelectionModel().getSelectedIndex());
	     ManagerDAO mdao = new ManagerDAO();
//	     System.out.println("매니져로접속하면 로긴디티오는? : " + controller.getLoginDto().getId());
	     ManagerDTO mdto = mdao.SelectId(controller.getLoginDto().getId());
//	     LoginDAO lDao = new LoginDAO();
//	     LoginDTO loginDto = lDao.SelectId(controller.getLoginDto().getId());
	     
	     
	     if(controller.getLoginDto().getId().equals(reserveDto.getId()) || mdto != null) {
	     ReserveDAO reservedao = new ReserveDAO();
			reservedao.delete(reserveDto);
		reserveTable.getItems().removeAll(reserveTable.getSelectionModel().getSelectedItems());
	     }
    }
	
	

	
	
	
	
	



	

}



