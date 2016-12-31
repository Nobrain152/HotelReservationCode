package ui.webSalesman;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebManagerWebsiteManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.UILaunch;
import vo.UserInfoVO;

public class webSalesmanAddViewController implements Initializable{
	private UILaunch application;
	private WebManagerWebsiteManagementController addSalesman;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private PasswordField pf_password;
	
	@FXML
	private TextField tf_contact;
	
	@FXML
	private Button btn_Add;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event) throws Exception{
		UserInfoVO newStuff=new UserInfoVO(null,tf_name.getText(),tf_contact.getText(),pf_password.getText());
		String salesmanID=addSalesman.addWebStuff(newStuff);
		System.out.println(salesmanID);//TODO Êä³ö
		application.gotowebManagerGuide();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		addSalesman=new WebManagerWebsiteManagementController();
	}

}
