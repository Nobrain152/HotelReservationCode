package ui.customerInfoManage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class customerInfoByMController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Modify;
	
	public void setApp(UILaunch application){
		this.application= application;
	}

	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoInquireByM();
	}
	
	@FXML
	private void btn_ModifyAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoModifyByM();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}