package ui.hotelManaged;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class hotelInfoMaintainViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Save;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
		application.gotohotelManagedInfo();
	}
	
	@FXML
	public void btn_SaveAction(ActionEvent ev) throws Exception{
		application.gotohotelManagedInfo();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
