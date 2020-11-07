package layouts;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import app.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatLayoutController implements Initializable {

    @FXML
    private TextField msgField;

    @FXML
    private Button sendBtn;
    
    @FXML
    private TextArea displayArea;
    
    @FXML
    private TextField nameField;
    
    @FXML
    private Label nameLabel;
    
   

	
	
	public void sendAction(ActionEvent e) {
		Socket ref = Client.mySocket;
		String text = msgField.getText().trim();
		if(!text.isEmpty()) {
			try {
				PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(ref.getOutputStream()), true);
				if(!nameField.getText().isEmpty()) {
					String name =  nameField.getText().trim() + ":";
					String fullMsg = name+ " "+text;
					out_socket.println(fullMsg);
				}else {
					out_socket.println(text);
				}
				msgField.setText("");
			} catch (IOException e1) {	
				e1.printStackTrace();
			}
			
			
		}
	}
	
	public void update(){
		Thread service = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(Client.mySocket.getInputStream()));
					while(true) {
						if(in.ready()) {
							String msg = in.readLine();
							Platform.runLater(()->{
								displayArea.appendText(msg+"\n");
							});
						}	
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		service.start();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		displayArea.setDisable(true);
		displayArea.setStyle("-fx-opacity: 1;");
		update();
	}
	
	




}



