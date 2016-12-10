package ui.orderOnWeb;

import java.net.URL;
import java.util.ResourceBundle;

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
import ui.orderOnUser.orderOnUserViewController.OrderInTable;

public class abnormalOrderViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private TableView<OrderInTable> order_waiting;	
	@FXML
	private TableColumn<?, ?> order_waiting_ID;
	@FXML
	private TableColumn<?, ?> order_waiting_userName;
	@FXML
	private TableColumn<?, ?> order_waiting_hotelName;
	@FXML
	private TableColumn<?, ?> order_waiting_time;
	@FXML
	private TableColumn<?, ?> order_waiting_price;
	private ObservableList<OrderInTable> data_waiting;
	@FXML
	private Button btn_waiting_info;
	
	@FXML
	private TableView<OrderInTable> order_abnormal;	
	@FXML
	private TableColumn<?, ?> order_abnormal_ID;
	@FXML
	private TableColumn<?, ?> order_abnormal_userName;
	@FXML
	private TableColumn<?, ?> order_abnormal_hotelName;
	@FXML
	private TableColumn<?, ?> order_abnormal_time;
	@FXML
	private TableColumn<?, ?> order_abnormal_price;
	private ObservableList<OrderInTable> data_abnormal;
	@FXML
	private Button btn_abnormal_info;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_waiting_infoAction(ActionEvent ev){
		application.gotoabnormalOrderInfo();
	}
	
	@FXML
	public void btn_abnormal_infoAction(ActionEvent ev){
		application.gotoabnormalOrderInfo();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotowebSalesmanGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data_waiting=FXCollections.observableArrayList(new OrderInTable("123","GYF","A Hotel","2016-10-01",1599),
				new OrderInTable("123","GYF","A Hotel","2016-10-01",1599),
				new OrderInTable("123","GYF","A Hotel","2016-10-01",1599)
				);
		order_waiting_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_waiting_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_waiting_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_waiting_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_waiting_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_waiting.setItems(data_waiting);
	}
	
public static class OrderInTable {
		
		private SimpleStringProperty ID;
		private SimpleStringProperty userName;
		private SimpleStringProperty hotelName;
		private SimpleStringProperty time;
		private SimpleDoubleProperty price;
		
		private OrderInTable(String ID,String userName,String hotelName,String time,double price){
			this.ID=new SimpleStringProperty(ID);
			this.userName=new SimpleStringProperty(userName);
			this.hotelName=new SimpleStringProperty(hotelName);
			this.time=new SimpleStringProperty(time);
			this.price=new SimpleDoubleProperty(price);
		}
		
		public String getID(){
			return ID.get();
		}
		
		public void setID(String str){
			ID.set(str);
		}
		
		public String getUserName() {
			return userName.get();
		}

		public void setUserName(String str) {
			userName.set(str);
		}

		public String getHotelName() {
			return hotelName.get();
		}

		public void setHotelName(String str) {
			hotelName.set(str);
		}

		public String getTime() {
			return time.get();
		}

		public void setTime(String str) {
			time.set(str);
		}

		public double getPrice() {
			return price.get();
		}

		public void setPrice(double n) {
			price.set(n);
		}
	}

}
