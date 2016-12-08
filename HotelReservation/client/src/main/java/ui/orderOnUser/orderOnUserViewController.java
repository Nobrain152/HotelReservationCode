package ui.orderOnUser;

import java.net.URL;
import java.util.ResourceBundle;

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

public class orderOnUserViewController implements Initializable{
	private UILaunch application;
	
	//全部订单
	@FXML
	private TableView<OrderInTable> order_all;	
	@FXML
	private TableColumn<?, ?> order_all_ID;
	@FXML
	private TableColumn<?, ?> order_all_hotelName;
	@FXML
	private TableColumn<?, ?> order_all_time;
	@FXML
	private TableColumn<?, ?> order_all_price;
	private ObservableList<OrderInTable> data_all;
	
	//已执行订单
	@FXML
	private TableView<OrderInTable> order_executed;	
	@FXML
	private TableColumn<?, ?> order_executed_ID;
	@FXML
	private TableColumn<?, ?> order_executed_hotelName;
	@FXML
	private TableColumn<?, ?> order_executed_time;
	@FXML
	private TableColumn<?, ?> order_executed_price;
	private ObservableList<OrderInTable> data_executed;
	
	//未执行订单
	@FXML
	private TableView<OrderInTable> order_waiting;	
	@FXML
	private TableColumn<?, ?> order_waiting_ID;
	@FXML
	private TableColumn<?, ?> order_waiting_hotelName;
	@FXML
	private TableColumn<?, ?> order_waiting_time;
	@FXML
	private TableColumn<?, ?> order_waiting_price;
	private ObservableList<OrderInTable> data_waiting;
	
	//已撤销订单
	@FXML
	private TableView<OrderInTable> order_canceled;	
	@FXML
	private TableColumn<?, ?> order_canceled_ID;
	@FXML
	private TableColumn<?, ?> order_canceled_hotelName;
	@FXML
	private TableColumn<?, ?> order_canceled_time;
	@FXML
	private TableColumn<?, ?> order_canceled_price;
	private ObservableList<OrderInTable> data_canceled;
	
	//异常订单
	@FXML
	private TableView<OrderInTable> order_abnormal;	
	@FXML
	private TableColumn<?, ?> order_abnormal_ID;
	@FXML
	private TableColumn<?, ?> order_abnormal_hotelName;
	@FXML
	private TableColumn<?, ?> order_abnormal_time;
	@FXML
	private TableColumn<?, ?> order_abnormal_price;
	private ObservableList<OrderInTable> data_abnormal;
	
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotocustomerGuide();
		//OrderInTable result= order_all.getSelectionModel().getSelectedItem();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data_all=FXCollections.observableArrayList(new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000"),
				new OrderInTable("123","A Hotel","2016-10-01","1000")
				);
		order_all_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_all_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_all_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_all_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_all.setItems(data_all);
	}
	
	/**
	 * 内部类，为了显示列表中的订单信息
	 */
	public static class OrderInTable {
		
		private SimpleStringProperty ID;
		private SimpleStringProperty hotelName;
		private SimpleStringProperty time;
		private SimpleStringProperty price;
		
		private OrderInTable(String ID,String hotelName,String time,String price){
			this.ID=new SimpleStringProperty(ID);
			this.hotelName=new SimpleStringProperty(hotelName);
			this.time=new SimpleStringProperty(time);
			this.price=new SimpleStringProperty(price);
		}
		
		public String getID(){
			return ID.get();
		}
		
		public void setID(String str){
			ID.set(str);
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

		public String getPrice() {
			return price.get();
		}

		public void setPrice(String str) {
			price.set(str);
		}
	}

}


