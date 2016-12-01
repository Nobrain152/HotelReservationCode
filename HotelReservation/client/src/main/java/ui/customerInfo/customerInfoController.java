package ui.customerInfo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class customerInfoController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button button_Modify;
	
	@FXML
	private Button button_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void button_ModifyAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoModify();
	}
	
	@FXML
	private void button_CancelAction(ActionEvent event) throws Exception{
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
