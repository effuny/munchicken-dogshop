package project.manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.main.Controller;
import project.manager.dogItemset.DogitemController;
import project.manager.memberList.MemberListController;
import project.manager.reserveList.ReserveListController;

public class ManagerController{
	private Parent ProjectAdmin;
	private ManagerService managerService;
	private Controller controller;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	
	
	public void setProjectAdmin(Parent ProjectAdmin) {
		this.ProjectAdmin = ProjectAdmin;
	}

	
	public void memberOpenProc() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/memberList/ManagerOfficial.fxml"));
		Parent ManagerOfficial;
		

		try {
			ManagerOfficial = loader.load();
			
			controller.setMemberListController(loader.getController());
			MemberListController memberListController = controller.getMemberListController();
			memberListController.setManagerOfficial(ManagerOfficial);
			
			Scene scene = new Scene(ManagerOfficial);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("ManagerOfficial");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}catch(IOException e){
			e.printStackTrace();
		}

		
	}
	
	public void reserveListOpenProc() {
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
	public void DogItemsetProc() {
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
	
	public void noticeOpenProc() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/manager/noticeBoard/NoticeBoard.fxml"));
	      Parent NoticeBoard;
	      

	      try {
	         NoticeBoard = loader.load();
	         
	         controller.setNoticeBoardController(loader.getController());
	         controller.getNoticeBoardController().setNoticeBoard(NoticeBoard);
	         
	         Scene scene = new Scene(NoticeBoard);
	         Stage primaryStage = new Stage();
	         primaryStage.setTitle("NoticeBoard");
	         primaryStage.setScene(scene);
	         primaryStage.show();
	         
	         
	      }catch(IOException e){
	         e.printStackTrace();
	      }
	}

	
}
