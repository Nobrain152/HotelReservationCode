package ui.roomAdd;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
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
import ui.promotionHotel.promotionHotelViewController.PromotionDiy;
import ui.reservedHotel.reservedHotelListViewController.hotelItem;

public class roomListViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private TableView<roomItem> tv_room;
	@FXML
	private TableColumn<?, ?> tc_ID;
	@FXML
	private TableColumn<?, ?> tc_type;
	@FXML
	private TableColumn<?, ?> tc_state;
	@FXML
	private TableColumn<?, ?> tc_price;
	@FXML
	private TableColumn<?, ?> tc_startTime;
	@FXML
	private TableColumn<?, ?> tc_endTime;
	private ObservableList<roomItem> data;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Add;
	
	@FXML
	private Button btn_Modify;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event){
		application.gotohotelStuffGuide();
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event){
		application.gotoroomAdd();
	}
	
	@FXML
	private void btn_ModifyAction(ActionEvent event){
		application.gotoroomModify();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data = FXCollections.observableArrayList(new roomItem("201", "标准房", "可用", 500,"2016-10-1 8:00","2016-10-2 8:00"),
				new roomItem("201", "标准房", "可用", 500,"2016-10-1 8:00","2016-10-2 8:00"),
				new roomItem("201", "标准房", "可用", 500,"2016-10-1 8:00","2016-10-2 8:00")
				);
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_type.setCellValueFactory(new PropertyValueFactory<>("type"));
		tc_state.setCellValueFactory(new PropertyValueFactory<>("state"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tc_startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
		tc_endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
		tv_room.setItems(data);
	}
	
	public static class roomItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty type;
		private SimpleStringProperty state;
		private SimpleIntegerProperty price;
		private SimpleStringProperty startTime;
		private SimpleStringProperty endTime;
		
		private roomItem(String ID,String type,String state,int price,String startTime,String endTime){
			this.ID=new SimpleStringProperty(ID);
			this.type=new SimpleStringProperty(type);
			this.state=new SimpleStringProperty(state);
			this.price=new SimpleIntegerProperty(price);
			this.startTime=new SimpleStringProperty(startTime);
			this.endTime=new SimpleStringProperty(endTime);
			
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
		
		public String getState(){
			return state.get();
		}
		
		public void setState(String str){
			state.set(str);
		}
		
		public int getPrice(){
			return price.get();
		}
		
		public void setPrice(int n){
			price.set(n);
		}
		
		public String getStartTime(){
			return startTime.get();
		}
		
		public void setStartTime(String str){
			startTime.set(str);
		}
		
		public String getEndTime(){
			return endTime.get();
		}
		
		public void setEndTime(String str){
			endTime.set(str);
		}
	}

}
