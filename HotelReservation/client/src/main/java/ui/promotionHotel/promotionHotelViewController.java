package ui.promotionHotel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ui.UILaunch;

public class promotionHotelViewController implements Initializable {
	private UILaunch application;

	// 会员生日优惠策略
	@FXML
	private TableView<PromotionBirthday> promotion_birthday;
	@FXML
	private TableColumn<?, ?> promotion_birthday_level;
	@FXML
	private TableColumn<?, ?> promotion_birthday_discount;
	private ObservableList<PromotionBirthday> data_birthday;

	// 三间以上优惠策略
	@FXML
	private TableView<PromotionThreeRoom> promotion_threeroom;
	@FXML
	private TableColumn<?, ?> promotion_threeroom_number;
	@FXML
	private TableColumn<?, ?> promotion_threeroom_discount;
	private ObservableList<PromotionThreeRoom> data_threeroom;

	// 合作企业优惠策略
	@FXML
	private TableView<PromotionEnterprise> promotion_enterprise;
	@FXML
	private TableColumn<?, ?> promotion_enterprise_name;
	@FXML
	private TableColumn<?, ?> promotion_enterprise_discount;
	private ObservableList<PromotionEnterprise> data_enterprise;

	// 自定义优惠策略
	@FXML
	private TableView<PromotionDiy> promotion_diy;
	@FXML
	private TableColumn<?, ?> promotion_diy_startTime;
	@FXML
	private TableColumn<?, ?> promotion_diy_endTime;
	@FXML
	private TableColumn<?, ?> promotion_diy_discount;
	private ObservableList<PromotionDiy> data_diy;
	

	@FXML
	private Button btn_Cancel;

	public void setApp(UILaunch application) {
		this.application = application;
	}

	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotohotelStuffGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public static class PromotionBirthday {
		private SimpleStringProperty level;
		private SimpleStringProperty discount;
		
		private PromotionBirthday(String level,String discount){
			this.level=new SimpleStringProperty(level);
			this.discount=new SimpleStringProperty(discount);
		}
		
		public String getLevel(){
			return level.get();
		}
		
		public void setLevel(String str){
			level.set(str);
		}
		
		public String getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(String str){
			discount.set(str);
		}
	}
	
	public static class PromotionThreeRoom {
		private SimpleIntegerProperty number;
		private SimpleStringProperty discount;
		
		private PromotionThreeRoom(int number,String discount){
			this.number=new SimpleIntegerProperty(number);
			this.discount=new SimpleStringProperty(discount);
		}
		
		public int getNumber(){
			return number.get();
		}
		
		public void setNumber(int n){
			number.set(n);
		}
		
		public String getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(String str){
			discount.set(str);
		}
	}
	
	public static class PromotionEnterprise {
		private SimpleStringProperty name;
		private SimpleStringProperty discount;
		
		private PromotionEnterprise(String name,String discount){
			this.name=new SimpleStringProperty(name);
			this.discount=new SimpleStringProperty(discount);
		}
		
		public String getName(){
			return name.get();
		}
		
		public void setName(String str){
			name.set(str);
		}
		
		public String getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(String str){
			discount.set(str);
		}
	}
	
	public static class PromotionDiy{
		private SimpleStringProperty startTime;
		private SimpleStringProperty endTime;
		private SimpleStringProperty discount;
		
		private PromotionDiy(String startTime,String endTime,String discount){
			this.startTime=new SimpleStringProperty(startTime);
			this.endTime=new SimpleStringProperty(endTime);
			this.discount=new SimpleStringProperty(discount);
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
		
		public String getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(String str){
			discount.set(str);
		}
	}

}
