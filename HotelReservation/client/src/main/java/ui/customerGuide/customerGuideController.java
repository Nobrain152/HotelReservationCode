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
	private Button button1;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void button1Action(ActionEvent event) throws Exception{
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
