package ui.promotionWeb;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ui.UILaunch;

public class promotionWebViewController implements Initializable {
	private UILaunch application;

	// 会员等级优惠策略
	@FXML
	private TableView<PromotionVIP> promotion_vip;
	@FXML
	private TableColumn<?, ?> promotion_vip_level;
	@FXML
	private TableColumn<?, ?> promotion_vip_discount;
	private ObservableList<PromotionVIP> data_vip;

	// 特定商圈优惠策略
	@FXML
	private TableView<PromotionArea> promotion_area;
	@FXML
	private TableColumn<?, ?> promotion_area_name;
	@FXML
	private TableColumn<?, ?> promotion_area_discount;
	private ObservableList<PromotionArea> data_area;

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
		application.gotowebSalesmanGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public static class PromotionVIP{
		private SimpleStringProperty level;
		private SimpleStringProperty discount;
		
		private PromotionVIP(String level,String discount){
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
	
	public static class PromotionArea {
		private SimpleStringProperty name;
		private SimpleStringProperty discount;
		
		private PromotionArea(String name,String discount){
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
