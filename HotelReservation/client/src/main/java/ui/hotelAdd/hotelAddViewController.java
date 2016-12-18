package ui.hotelAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebManagerHotelOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ui.UILaunch;
import util.Adress;
import util.Area;
import vo.HotelInfoVO;

public class hotelAddViewController implements Initializable{
	private UILaunch application;
	private WebManagerHotelOperationController addHotel;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private ChoiceBox<Integer> cb_star;
	
	@FXML
	private TextField tf_price;
	
	@FXML
	private ChoiceBox<Adress> cb_address;
	
	@FXML
	private ChoiceBox<Area> cb_area;
	
	@FXML
	private TextArea ta_facility;
	
	@FXML
	private TextArea ta_introduction;
	
	@FXML
	private Button btn_Add;
	
	@FXML
	private Button btn_Cancel;
		
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event) throws Exception{
		HotelInfoVO newHotel=new HotelInfoVO(tf_name.getText(),cb_address.getValue(),cb_area.getValue(),cb_star.getValue(),
				ta_introduction.getText(),ta_facility.getText(),false,null,10,Integer.parseInt(tf_price.getText()));
		String ID= addHotel.HotelAdd(newHotel);//TODO 显示注册成功的ID；
		System.out.println(ID);
		application.gotowebManagerGuide();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		addHotel=new WebManagerHotelOperationController();
	}

}
