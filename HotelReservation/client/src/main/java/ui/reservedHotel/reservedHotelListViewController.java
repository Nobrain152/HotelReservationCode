package ui.reservedHotel;

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

public class reservedHotelListViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private TableView<hotelItem> tv_hotel;
	
	@FXML
	private TableColumn<?, ?> tc_name;	
	@FXML
	private TableColumn<?, ?> tc_star;
	@FXML
	private TableColumn<?, ?> tc_score;
	@FXML
	private TableColumn<?, ?> tc_condition;
	@FXML
	private TableColumn<?, ?> tc_price;
	
	private ObservableList<hotelItem> data;
	
	@FXML
	private Button btn_Info;
	
	
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_InfoAction(ActionEvent ev){
		application.gotoreservedHotelInfo();
	}
	
	
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data = FXCollections.observableArrayList(new hotelItem("Sun Hotel", 5, 10, "正常订单",1500),
				new hotelItem("Sun Hotel", 5, 10, "异常订单",1500),
				new hotelItem("Sun Hotel", 5, 10, "撤销订单",1500)
				);
		tc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc_star.setCellValueFactory(new PropertyValueFactory<>("star"));
		tc_score.setCellValueFactory(new PropertyValueFactory<>("score"));
		tc_condition.setCellValueFactory(new PropertyValueFactory<>("condition"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tv_hotel.setItems(data);
	}
	
	public static class hotelItem{
		private SimpleStringProperty name;
		private SimpleIntegerProperty star;
		private SimpleIntegerProperty score;
		private SimpleStringProperty condition;
		private SimpleIntegerProperty price;
		
		private hotelItem(String name,int star,int score,String condition,int price){
			this.name=new SimpleStringProperty(name);
			this.star=new SimpleIntegerProperty(star);
			this.score=new SimpleIntegerProperty(score);
			this.condition=new SimpleStringProperty(condition);
			this.price=new SimpleIntegerProperty(price);
		}
		
		public String getName(){
			return name.get();
		}
		
		public void setName(String str){
			name.set(str);
		}
		
		public int getStar(){
			return star.get();
		}
		
		public void setStar(int n){
			star.set(n);
		}
		
		public int getScore(){
			return score.get();
		}
		
		public void setScore(int n){
			score.set(n);
		}
		
		public String getCondition(){
			return condition.get();
		}
		
		public void setCondition(String str){
			condition.set(str);
		}
		
		public int getPrice(){
			return price.get();
		}
		
		public void setPrice(int n){
			price.set(n);
		}
		
		
	}


}
