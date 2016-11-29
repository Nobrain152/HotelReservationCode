package ui;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class abcController implements Initializable{
	
	@FXML
	private Button button;
	
	@FXML
	private void buttonAction(ActionEvent event){
		System.out.println("WTF!!!");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
