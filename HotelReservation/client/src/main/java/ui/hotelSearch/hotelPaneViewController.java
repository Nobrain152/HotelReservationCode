package ui.hotelSearch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.UILaunch;

public class hotelPaneViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Info;
	
	@FXML
	private Label hotelName;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	public void setInfo(){
		//TODO 调用bl层获取信息
	}
	
	@FXML
	public void btn_InfoAction(ActionEvent ev){
		application.gotohotelInfoSearched();
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setInfo();
	}

}
