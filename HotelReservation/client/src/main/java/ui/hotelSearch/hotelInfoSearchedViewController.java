package ui.hotelSearch;

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
import ui.orderOnHotel.orderOnHotelViewController.OrderInTable;

public class hotelInfoSearchedViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Reserve;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private TableView<orderItem> order;
	@FXML
	private TableColumn<?, ?> order_ID;
	@FXML
	private TableColumn<?, ?> order_time;
	@FXML
	private TableColumn<?, ?> order_condition;
	@FXML
	private TableColumn<?, ?> order_price;
	private ObservableList<orderItem> data;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_ReserveAction(ActionEvent ev){
		application.gotohotelReserve();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotohotelSearchList();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data = FXCollections.observableArrayList(new orderItem("123", "2016-10-01","正常订单", 1000),
				new orderItem("123", "2016-10-01","异常订单", 1000),
				new orderItem("123", "2016-10-01","撤销订单", 1000)
				);
		order_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		order_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_condition.setCellValueFactory(new PropertyValueFactory<>("condition"));
		order_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order.setItems(data);
	}

	public static class orderItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty time;
		private SimpleStringProperty condition;
		private SimpleIntegerProperty price;
		
		private orderItem(String ID,String time,String condition,int price){
			this.ID = new SimpleStringProperty(ID);			
			this.time = new SimpleStringProperty(time);
			this.condition = new SimpleStringProperty(condition);
			this.price = new SimpleIntegerProperty(price);
		}
		
		public String getID() {
			return ID.get();
		}

		public void setID(String str) {
			ID.set(str);
		}

		

		public String getTime() {
			return time.get();
		}

		public void setTime(String str) {
			time.set(str);
		}
		
		public String getCondition() {
			return condition.get();
		}

		public void setCondition(String str) {
			condition.set(str);
		}

		public int getPrice() {
			return price.get();
		}

		public void setPrice(int n) {
			price.set(n);
		}
	}
}
