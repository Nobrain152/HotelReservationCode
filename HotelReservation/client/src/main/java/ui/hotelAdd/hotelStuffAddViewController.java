package ui.hotelAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebManagerHotelOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.UILaunch;
import vo.StuffInfoVO;

public class hotelStuffAddViewController implements Initializable{
	private UILaunch application;
	private WebManagerHotelOperationController addHotelStuff;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private PasswordField pf_password;
	
	@FXML
	private TextField tf_contact;
	
	@FXML
	private TextField tf_hotelID;
	
	@FXML
	private Button btn_Add;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event) throws Exception{
		StuffInfoVO newStuff=new StuffInfoVO(null,tf_name.getText(),tf_contact.getText(),tf_hotelID.getText(),pf_password.getText());
		String stuffID=addHotelStuff.StuffAdd(newStuff);//TODO 用对话框显示
		System.out.println(stuffID);
		application.gotowebManagerGuide();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		addHotelStuff=new WebManagerHotelOperationController();
	}

}
