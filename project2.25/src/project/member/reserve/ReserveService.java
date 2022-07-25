package project.member.reserve;

import java.time.LocalDate;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import project.main.Controller;
import project.manager.reserveList.ReserveDTO;

public class ReserveService {
	
	private  DatePicker datePicker;
	private  Controller controller;
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setDatePicker(DatePicker datePicker) {
		this.datePicker = datePicker;
	}



	public void reserveRegister(Parent reserveForm) {
		

		TextField reserveName = (TextField)reserveForm.lookup("#name");
		String name = reserveName.getText();
		
		ComboBox<String> serviceHour = (ComboBox<String>)reserveForm.lookup("#serviceHour");
		String hourPick = serviceHour.getValue();
		
		ComboBox<String> service = (ComboBox<String>)reserveForm.lookup("#service");
		String servicePick = service.getValue();
		
		LocalDate serviceDate = datePicker.getValue();
		
		ReserveDTO reserveDto = new ReserveDTO(name, servicePick, serviceDate.toString(), hourPick, controller.getLoginDto().getId());
		
		
		
	}

}
