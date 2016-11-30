package ui.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class loginController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button login;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void loginAction(ActionEvent event){
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
