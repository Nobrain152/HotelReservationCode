package ui.vip;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import ui.UILaunch;

public class vipRegisterViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private ChoiceBox<String> cb_VipType;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cb_VipType.setItems(FXCollections.observableArrayList("普通会员","企业会员"));
		}

}
