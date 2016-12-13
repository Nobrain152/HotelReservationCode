package ui.customerGuide;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.UILaunch;
import ui.UIhelper;

public class customerGuideViewController implements Initializable{
	private UILaunch application;
	
	
	
	@FXML
	private Button button_Search;
	
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
	private void button_SearchAction(ActionEvent event) throws Exception{
		application.gotohotelSearch();
	}
	
	@FXML
	private void button_OrderAction(ActionEvent event) throws Exception{
		application.gotoorderOnUser();		
	}
	
	@FXML
	private void button_HotelAction(ActionEvent event) throws Exception{
		application.gotoreservedHotelList();	
	}
	
	@FXML
	private void button_InfoAction(ActionEvent event) throws Exception{
		
		application.gotocustomerInfo();	
	}
	
	@FXML
	private void button_VipAction(ActionEvent event) throws Exception{
		application.gotovipRegister();	
	}
	
	@FXML
	private void button_CancelAction(ActionEvent event) throws Exception{
		application.gotologin();
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}

}
