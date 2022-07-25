package project.main;

import java.io.File;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import project.login.LoginController;

public class Main extends Application{

	public static void main(String[] args) throws Exception {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/login/ProjectLoginPage.fxml"));
		Parent ProjectLoginPage = loader.load();
		
		Controller controller = new Controller();
		
		Button button = new Button("Browser");
		
		FileChooser fc = new FileChooser();
		Window win = button.getScene().getWindow();
		File file = fc.showOpenDialog(win);
		
		controller.setLoginController(loader.getController());
		
		LoginController loginController = controller.getLoginController();
		loginController.setProjectLoginPage(ProjectLoginPage);
		
		
		Scene scene = new Scene(ProjectLoginPage);
		primaryStage.setTitle("MainLoginPage");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				switch(event.getCode()) {
				case ENTER:
					 loginController.loginProc();
					 break;
				default:
					  break;
				}
			}
		});

		
	}

}
