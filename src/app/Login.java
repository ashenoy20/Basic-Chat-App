package app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login extends Application{

	public static void main(String[] args) {
		try {
			new Client();
			launch(args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void start(Stage arg0) throws Exception {
		Pane parent = FXMLLoader.load(getClass().getResource("/layouts/LoginLayout.fxml"));
		Scene scene = new Scene(parent); 
		arg0.setScene(scene);
		arg0.show();
		
	}

}
