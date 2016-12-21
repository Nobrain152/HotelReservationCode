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
import util.UserType;
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public class registerViewController implements Initializable{
	private UILaunch application;
	
	private LoginInputController register;
	
	
	
	@FXML
	private PasswordField password;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField contact;
	
	@FXML
	private Button btn_cancel;
	
	@FXML
	private Button btn_register;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_cancelAction(ActionEvent event){
		application.gotologin();
	}
	
	@FXML
	public void btn_registerAction(ActionEvent event){
		CustomerInfoVO user=new CustomerInfoVO(null,name.getText(),contact.getText(),password.getText(),300,false,null);
		user.setType(UserType.Customer);
		String id=register.Register(user);//TODO �жϽ��������ֵ��ע���ID����ı���棬������ID����ϵͳ�Զ�����
		System.out.println(id);
		application.gotologin();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		register=new LoginInputController();
		
	}

}
