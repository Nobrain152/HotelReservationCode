package ui.hotelSearch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import ui.UILaunch;

public class hotelSearchController implements Initializable{
	private UILaunch application;
	
	@FXML
	private ChoiceBox<String> cb_Price;
	
	@FXML
	private ChoiceBox<Integer> cb_Star;
	
	@FXML
	private ChoiceBox<String> cb_Score;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Search;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
		application.gotocustomerGuide();
	}
	
	@FXML
	public void btn_SearchAction(ActionEvent ev) throws Exception{
		application.gotohotelSearchList();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cb_Price.setItems(FXCollections.observableArrayList("从高到低", "从低到高"));
		cb_Star.setItems(FXCollections.observableArrayList(1, 2,3,4,5));
		cb_Score.setItems(FXCollections.observableArrayList("0~2", "3~5","6~8","9~10"));
	}

}
