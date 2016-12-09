package ui.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class registerViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_cancel;
	
	@FXML
	private Button btn_register;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_cancelAction(ActionEvent event){
		application.gotologin();
	}
	
	@FXML
	public void btn_registerAction(ActionEvent event){
		application.gotologin();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
