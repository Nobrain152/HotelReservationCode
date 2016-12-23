package ui.hotelReserve;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelbl.RoomAddController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import vo.RoomInfoVO;

public class hotelReserveViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private RoomAddController roomController;
	
	
	
	@FXML
	private TableView<roomItem> tv_room;
	@FXML
	private TableColumn<?, ?> tc_ID;
	@FXML
	private TableColumn<?, ?> tc_type;
	@FXML
	private TableColumn<?, ?> tc_price;
	private ObservableList<roomItem> data;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent event){
		application.gotohotelSearchList();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		roomController=new RoomAddController();
		ArrayList<RoomInfoVO> room_list=roomController.getEmptyRoom(helper.getHotelID());
		ArrayList<roomItem> data_list=new ArrayList<roomItem>();
		int size=room_list.size();
		for(int i=0;i<size;i++){
			RoomInfoVO tempRoomVO=room_list.get(i);
			data_list.add(new roomItem(tempRoomVO.getRoomID(),tempRoomVO.getState().toString(),tempRoomVO.getPrice()));
		}
		
		data = FXCollections.observableArrayList(data_list);
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_type.setCellValueFactory(new PropertyValueFactory<>("type"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tv_room.setItems(data);
	}
	
	
	public static class roomItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty type;
		private SimpleDoubleProperty price;
		
		
		private roomItem(String ID,String type,double price){
			this.ID=new SimpleStringProperty(ID);
			this.type=new SimpleStringProperty(type);
			this.price=new SimpleDoubleProperty(price);
			
			
		}
		
		public String getID(){
			return ID.get();
		}
		
		public void setID(String str){
			ID.set(str);
		}
		
		public String getType(){
			return type.get();
		}
		
		public void setType(String str){
			type.set(str);
		}
		
		public double getPrice(){
			return price.get();
		}
		
		public void setPrice(double n){
			price.set(n);
		}
		
		
	}


}
