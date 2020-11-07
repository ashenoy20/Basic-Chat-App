package layouts;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import app.Login;

public class LoginLayoutController {

    @FXML
    private TextField userNameField;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passWordField;

    @FXML
    private Button registerBtn;
    
    
    
    
    public void loginBtnAction(ActionEvent e) throws IOException {
    	Stage stage = (Stage) loginBtn.getScene().getWindow();
    	
    	Pane newParent = FXMLLoader.load(Login.class.getResource("/layouts/ChatLayout.fxml"));
    	
    	Scene scene = new Scene(newParent);
    	
    	stage.setScene(scene);
    	
    	stage.show();
    }

}
