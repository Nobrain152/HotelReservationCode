package ui.login;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.LoginInputController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import util.UserType;

public class loginViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	
	
	
	private LoginInputController login;
	
	@FXML
	private TextField userid;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button btn_login;
	
	@FXML
	private Button btn_register;
	
	
	
	
	
	public void setApp(UILaunch application){
		this.application= application;		
		
	}
	
	@FXML
	public void btn_loginAction(ActionEvent event){
		login=new LoginInputController();
		String id=userid.getText();
		String key=password.getText();
		if(login.LogIn(id, key)){
			helper.setUserID(id);
			UserType type=login.getType(id);
			switch(type){
			case Customer:    application.gotocustomerGuide();break;
			case HotelStuff:  application.gotohotelStuffGuide();break;
			case WebStuff:    application.gotowebSalesmanGuide();break;
			case WebManager:  application.gotowebManagerGuide();
			}
		}else{
			System.out.println("wrong");//TODO 对话框提示账户或密码错误
		}
		
		
	}
	
	@FXML
	public void btn_registerAction(ActionEvent event){
		application.gotoregister();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		
		
		

	}

}
