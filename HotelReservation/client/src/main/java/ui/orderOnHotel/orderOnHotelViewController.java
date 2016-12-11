package ui.orderOnHotel;

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

public class orderOnHotelViewController implements Initializable {
	private UILaunch application;

	// 全部订单
	@FXML
	private TableView<OrderInTable> order_all;
	@FXML
	private TableColumn<?, ?> order_all_ID;
	@FXML
	private TableColumn<?, ?> order_all_userName;
	@FXML
	private TableColumn<?, ?> order_all_time;
	@FXML
	private TableColumn<?, ?> order_all_price;
	private ObservableList<OrderInTable> data_all;
	@FXML
	private Button btn_all_info;

	// 已执行订单
	@FXML
	private TableView<OrderInTable> order_executed;
	@FXML
	private TableColumn<?, ?> order_executed_ID;
	@FXML
	private TableColumn<?, ?> order_executed_userName;
	@FXML
	private TableColumn<?, ?> order_executed_time;
	@FXML
	private TableColumn<?, ?> order_executed_price;
	private ObservableList<OrderInTable> data_executed;
	@FXML
	private Button btn_executed_info;

	// 未执行订单
	@FXML
	private TableView<OrderInTable> order_waiting;
	@FXML
	private TableColumn<?, ?> order_waiting_ID;
	@FXML
	private TableColumn<?, ?> order_waiting_userName;
	@FXML
	private TableColumn<?, ?> order_waiting_time;
	@FXML
	private TableColumn<?, ?> order_waiting_price;
	private ObservableList<OrderInTable> data_waiting;
	@FXML
	private Button btn_waiting_info;

	// 已撤销订单
	@FXML
	private TableView<OrderInTable> order_canceled;
	@FXML
	private TableColumn<?, ?> order_canceled_ID;
	@FXML
	private TableColumn<?, ?> order_canceled_userName;
	@FXML
	private TableColumn<?, ?> order_canceled_time;
	@FXML
	private TableColumn<?, ?> order_canceled_price;
	private ObservableList<OrderInTable> data_canceled;
	@FXML
	private Button btn_canceled_info;

	// 异常订单
	@FXML
	private TableView<OrderInTable> order_abnormal;
	@FXML
	private TableColumn<?, ?> order_abnormal_ID;
	@FXML
	private TableColumn<?, ?> order_abnormal_userName;
	@FXML
	private TableColumn<?, ?> order_abnormal_time;
	@FXML
	private TableColumn<?, ?> order_abnormal_price;
	private ObservableList<OrderInTable> data_abnormal;
	@FXML
	private Button btn_abnormal_info;

	@FXML
	private Button btn_Cancel;

	public void setApp(UILaunch application) {
		this.application = application;
	}
	
	@FXML
	public void btn_all_infoAction(ActionEvent ev) throws Exception {
		application.gotoorderOnHotelInfo();
	}

	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception {
		application.gotohotelStuffGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data_all = FXCollections.observableArrayList(new OrderInTable("123", "GYF", "2016-10-01", "1000"),
				new OrderInTable("123", "GYF", "2016-10-01", "1000"),
				new OrderInTable("123", "GYF", "2016-10-01", "1000"),
				new OrderInTable("123", "GYF", "2016-10-01", "1000"));
		order_all_ID.setCellValueFactory(new PropertyValueFactory<Object, Object>("ID"));
		order_all_userName.setCellValueFactory(new PropertyValueFactory<Object, Object>("userName"));
		order_all_time.setCellValueFactory(new PropertyValueFactory<Object, Object>("time"));
		order_all_price.setCellValueFactory(new PropertyValueFactory<Object, Object>("price"));
		order_all.setItems(data_all);
	}

	/**
	 * 内部类，为了显示列表中的订单信息
	 */
	public static class OrderInTable {

		private SimpleStringProperty ID;
		private SimpleStringProperty userName;
		private SimpleStringProperty time;
		private SimpleStringProperty price;

		private OrderInTable(String ID, String userName, String time, String price) {
			this.ID = new SimpleStringProperty(ID);
			this.userName = new SimpleStringProperty(userName);
			this.time = new SimpleStringProperty(time);
			this.price = new SimpleStringProperty(price);
		}

		public String getID() {
			return ID.get();
		}

		public void setID(String str) {
			ID.set(str);
		}

		public String getUserName() {
			return userName.get();
		}

		public void setUserName(String str) {
			userName.set(str);
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
