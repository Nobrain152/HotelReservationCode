package ui.customerGuide;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class customerGuideController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button button_Order;
	
	@FXML
	private Button button_Hotel;
	
	@FXML
	private Button button_Info;
	
	@FXML
	private Button button_Vip;
	
	@FXML
	private Button button_Cancel;
	
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void button_OrderAction(ActionEvent event) throws Exception{
		application.gotoorderOnUser();		
	}
	
	@FXML
	private void button_HotelAction(ActionEvent event) throws Exception{
				
	}
	
	@FXML
	private void button_InfoAction(ActionEvent event) throws Exception{
				
	}
	
	@FXML
	private void button_VipAction(ActionEvent event) throws Exception{
				
	}
	
	@FXML
	private void button_CancelAction(ActionEvent event) throws Exception{
				
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
