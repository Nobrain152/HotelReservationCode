package ui.hotelAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebManagerHotelOperationController;
import javafx.collections.FXCollections;
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
	private ChoiceBox<String> cb_address;
	
	@FXML
	private ChoiceBox<String> cb_area;
	
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
		Adress address = null;
		Area area = null;
		if(cb_address.getValue().equals("�Ͼ�")){
			address=Adress.NANJING;
		}
		else if(cb_address.getValue().equals("����")){
			address=Adress.BEIJING;
		}
		else if(cb_address.getValue().equals("�Ϻ�")){
			address=Adress.SHANGHAI;
		}
		else if(cb_address.getValue().equals("����")){
			address=Adress.WUXI;
		}
		else if(cb_address.getValue().equals("����")){
			address=Adress.XIAMEN;
		}
		if(cb_area.getValue().equals("����")){
			area=Area.EAST;
		}
		else if(cb_area.getValue().equals("����")){
			area=Area.WEST;
		}
		else if(cb_area.getValue().equals("����")){
			area=Area.SOUTH;
		}
		else if(cb_area.getValue().equals("����")){
			area=Area.NORTH;
		}
		
		HotelInfoVO newHotel=new HotelInfoVO(tf_name.getText(),address,area,cb_star.getValue(),
				ta_introduction.getText(),ta_facility.getText(),false,null,10,Integer.parseInt(tf_price.getText()));
		String ID= addHotel.hotelAdd(newHotel);//TODO ��ʾע��ɹ���ID��
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
		
		cb_address.setItems(FXCollections.observableArrayList("����","�Ϻ�","�Ͼ�","����","����"));
		cb_area.setItems(FXCollections.observableArrayList("����","����","����","����"));
		cb_star.setItems(FXCollections.observableArrayList(1, 2,3,4,5));
	}

}
