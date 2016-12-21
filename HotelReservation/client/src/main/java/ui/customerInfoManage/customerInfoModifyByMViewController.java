package ui.customerInfoManage;

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

public class customerInfoModifyByMViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	private CustomerInfoVO customer;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private TextField tf_contact;
	
	@FXML
	private Button btn_Save;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_SaveAction(ActionEvent event){
		customer.setUsername(tf_name.getText());
		customer.setContact(tf_contact.getText());
		customerInfo.IndividualBaseInfoModification(helper.getCustomerIDbyManager(), customer);//TODO �жϽ��
		application.gotocustomerInfoByM();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event){
		application.gotocustomerInfoByM();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customerInfo=new CustomerInfoManagementController();
		customer=customerInfo.IndividualBaseInfolnquiry(helper.getCustomerIDbyManager());
		tf_name.setText(customer.getUsername());
		tf_contact.setText(customer.getContact());
	}

}
