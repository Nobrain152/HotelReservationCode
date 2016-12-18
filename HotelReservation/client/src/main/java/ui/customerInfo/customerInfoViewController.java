package ui.customerInfo;

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
import vo.CustomerInfoVO;

public class customerInfoViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	
	@FXML
	private Label name;
	
	@FXML
	private Label userID;
	
	@FXML
	private Label contact;
	
	@FXML
	private Label credit;
	
	@FXML
	private Button button_Credit;
	
	@FXML
	private Button button_Modify;
	
	@FXML
	private Button button_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void button_CreditAction(ActionEvent event) throws Exception{
		application.gotocreditCheck();
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
		helper=UIhelper.getInstance();
		customerInfo=new CustomerInfoManagementController();
		String ID=helper.getUserID();
		CustomerInfoVO customer =customerInfo.IndividualBaseInfolnquiry(ID);
		name.setText(customer.getUsername());
		userID.setText(customer.getUserID());
		contact.setText(customer.getContact());
		credit.setText(String.valueOf(customer.getCredit()));
	}

}
