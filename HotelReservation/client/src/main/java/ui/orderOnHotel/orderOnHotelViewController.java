package ui.orderOnHotel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
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
import util.OrderState;
import vo.OrderVO;

public class orderOnHotelViewController implements Initializable {
	private UILaunch application;
	private UIhelper helper;
	private StuffInfoManagementController stuffInfo;
	private String hotelID;
	private HotelStuffHotelOperationController stuffHotelOperation;
	

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
		helper=UIhelper.getInstance();
		stuffInfo=new StuffInfoManagementController();
		stuffHotelOperation=new HotelStuffHotelOperationController();
		hotelID=stuffInfo.IndividualBaseInfolnquiry(helper.getUserID()).getHotel();
		
		
		ArrayList<OrderVO> order_allList=stuffHotelOperation.OrderScan(hotelID);
		ArrayList<OrderInTable> data_allList=new ArrayList<OrderInTable>();
		int size_all=order_allList.size();
		for(int i=0;i<size_all;i++){
			OrderVO tempOrderVO=order_allList.get(i);
			String userName=tempOrderVO.getInitiator().getUsername();
			data_allList.add(new OrderInTable(tempOrderVO.getOrderID(),userName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_all=FXCollections.observableArrayList(data_allList);		
		order_all_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_all_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_all_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_all_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_all.setItems(data_all);
		
		ArrayList<OrderVO> order_executedList=stuffHotelOperation.specialOrderScan(hotelID, OrderState.EXECUTED);
		ArrayList<OrderInTable> data_executedList=new ArrayList<OrderInTable>();
		int size_executed=order_executedList.size();
		for(int i=0;i<size_executed;i++){
			OrderVO tempOrderVO=order_executedList.get(i);
			String userName=tempOrderVO.getInitiator().getUsername();
			data_executedList.add(new OrderInTable(tempOrderVO.getOrderID(),userName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_executed=FXCollections.observableArrayList(data_executedList);		
		order_executed_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_executed_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_executed_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_executed_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_executed.setItems(data_executed);
		
		ArrayList<OrderVO> order_waitingList=stuffHotelOperation.specialOrderScan(hotelID, OrderState.UNEXECUTED);
		ArrayList<OrderInTable> data_waitingList=new ArrayList<OrderInTable>();
		int size_waiting=order_waitingList.size();
		for(int i=0;i<size_waiting;i++){
			OrderVO tempOrderVO=order_waitingList.get(i);
			String userName=tempOrderVO.getInitiator().getUsername();
			data_waitingList.add(new OrderInTable(tempOrderVO.getOrderID(),userName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_waiting=FXCollections.observableArrayList(data_waitingList);		
		order_waiting_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_waiting_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_waiting_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_waiting_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_waiting.setItems(data_waiting);
		
		ArrayList<OrderVO> order_canceledList=stuffHotelOperation.specialOrderScan(hotelID, OrderState.CANCELLED);
		ArrayList<OrderInTable> data_canceledList=new ArrayList<OrderInTable>();
		int size_canceled=order_canceledList.size();
		for(int i=0;i<size_canceled;i++){
			OrderVO tempOrderVO=order_canceledList.get(i);
			String userName=tempOrderVO.getInitiator().getUsername();
			data_canceledList.add(new OrderInTable(tempOrderVO.getOrderID(),userName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_canceled=FXCollections.observableArrayList(data_canceledList);		
		order_canceled_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_canceled_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_canceled_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_canceled_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_canceled.setItems(data_canceled);
		
		ArrayList<OrderVO> order_abnormalList=stuffHotelOperation.specialOrderScan(hotelID, OrderState.ABNORMAL);
		ArrayList<OrderInTable> data_abnormalList=new ArrayList<OrderInTable>();
		int size_abnormal=order_abnormalList.size();
		for(int i=0;i<size_abnormal;i++){
			OrderVO tempOrderVO=order_abnormalList.get(i);
			String userName=tempOrderVO.getInitiator().getUsername();
			data_abnormalList.add(new OrderInTable(tempOrderVO.getOrderID(),userName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_abnormal=FXCollections.observableArrayList(data_abnormalList);		
		order_abnormal_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_abnormal_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_abnormal_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_abnormal_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_abnormal.setItems(data_abnormal);
	}

	/**
	 * 内部类，为了显示列表中的订单信息
	 */
	public static class OrderInTable {

		private SimpleStringProperty ID;
		private SimpleStringProperty userName;
		private SimpleStringProperty time;
		private SimpleDoubleProperty price;

		private OrderInTable(String ID, String userName, String time, double price) {
			this.ID = new SimpleStringProperty(ID);
			this.userName = new SimpleStringProperty(userName);
			this.time = new SimpleStringProperty(time);
			this.price = new SimpleDoubleProperty(price);
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

		public double getPrice() {
			return price.get();
		}

		public void setPrice(double n) {
			price.set(n);
		}
	}

}
