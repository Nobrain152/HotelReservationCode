package ui.vip;

import java.net.URL;
import java.util.ResourceBundle;

import bl.vipbl.VipController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ui.UILaunch;
import ui.UIhelper;
import util.VipType;

public class vipRegisterViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private VipController vipController;
	
	@FXML
	private ChoiceBox<String> cb_VipType;
	
	@FXML
	private DatePicker dp_birthday;
	
	@FXML
	private TextField tf_enterprise;
	
	@FXML
	private Button btn_Register;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_RegisterAction(ActionEvent ev){
		String type=cb_VipType.getValue();
		if(type.equals("��ͨ��Ա")){			
			vipController.registerVip(helper.getUserID(), VipType.COMMON_VIP, dp_birthday.getValue().toString());
		}
		else if(type.equals("��ҵ��Ա")){
			vipController.registerVip(helper.getUserID(), VipType.COMPANY_VIP, tf_enterprise.getText());
		}
		else{
			//TODO ��ʾ����ѡ��
		}
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("��ʾ");
		alert.setHeaderText(null);
		alert.setContentText("ע��ɹ� ");
		alert.showAndWait();
		application.gotocustomerGuide();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		vipController=new VipController();
		cb_VipType.setItems(FXCollections.observableArrayList("��ͨ��Ա","��ҵ��Ա"));
		}

}
