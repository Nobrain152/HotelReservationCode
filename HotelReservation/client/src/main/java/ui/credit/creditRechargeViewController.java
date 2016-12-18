package ui.credit;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebStuffWebsiteManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ui.UILaunch;
import util.ResultMsg;

public class creditRechargeViewController implements Initializable{
	private UILaunch application;
	private WebStuffWebsiteManagementController recharge;
	
	@FXML
	private TextField tf_userID;
	
	@FXML
	private TextField tf_recharge;
	
	@FXML
	private Button btn_Confirm;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_ConfirmAction(ActionEvent ev){
		ResultMsg msg=recharge.UserCreditModification(tf_userID.getText(), Integer.parseInt(tf_recharge.getText()));
		//TODO ��ʾ
		application.gotowebSalesmanGuide();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotowebSalesmanGuide();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		recharge=new WebStuffWebsiteManagementController();
	}

}
