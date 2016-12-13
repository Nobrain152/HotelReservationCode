package ui.customerInfo;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import vo.CustomerInfoVO;

public class customerInfoModifyViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	private CustomerInfoVO customer;
	
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField contact;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Save;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event){
		application.gotocustomerInfo();
	}
	
	@FXML
	private void btn_SaveAction(ActionEvent event){
		customer.setUsername(name.getText());
		customer.setContact(contact.getText());
		customerInfo.IndividualBaseInfoModification(helper.getUserID(), customer);//TODO еп╤о╫А╧Ш
		application.gotocustomerInfo();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customer=customerInfo.IndividualBaseInfolnquiry(helper.getUserID());
		name.setText(customer.getUsername());
		contact.setText(customer.getContact());
	}

}
