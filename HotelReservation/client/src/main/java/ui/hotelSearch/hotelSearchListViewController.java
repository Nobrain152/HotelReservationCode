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

public class hotelSearchListViewController implements Initializable{
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
	private TableColumn<?, ?> tc_isReserved;
	@FXML
	private TableColumn<?, ?> tc_price;
	
	private ObservableList<hotelItem> data;
	
	@FXML
	private Button btn_Info;
	
	@FXML
	private Button btn_Reserve;
	
	@FXML
	private Button btn_Cancel;
		
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_InfoAction(ActionEvent ev){
		application.gotohotelInfoSearched();
	}
	
	@FXML
	public void btn_ReserveAction(ActionEvent ev){
		application.gotohotelReserve();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotohotelSearch();
	}
	
	
	
	/**	
	public VBox createPage(int pageIndex) {
		VBox box = new VBox(4);
		int page = pageIndex * itemsPerPage;
		for (int i = page; i < page + itemsPerPage; i++) {
			VBox element = new VBox();
			Hyperlink link = new Hyperlink("Item " + (i+1));
			link.setVisited(true);
			Label text = new Label("Search results\nfor "+ link.getText());
			element.getChildren().addAll(link, text);
			box.getChildren().add(element);
			
		}
		return box;
	}
	
	 
	public Pane createPane() throws IOException{
		Pane p ;
				
		FXMLLoader loader = new FXMLLoader();
		InputStream in = hotelSearchListViewController.class.getResourceAsStream("hotelPane.fxml");
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(hotelSearchListViewController.class.getResource("hotelPane.fxml"));
		
		try{
			p = (Pane) loader.load(in);
		} finally {
			in.close();
		}
		
		hotelPaneViewController hotelPaneController=loader.getController();
		hotelPaneController.setApp(application);
		
		return p;
	}
	
	public GridPane createPage(int PageIndex){
		
		
		
		
		GridPane gp=new GridPane();
		RowConstraints row1 = new RowConstraints();
	    row1.setPercentHeight(30);
	    RowConstraints row2 = new RowConstraints();
	    row2.setPercentHeight(30);
	    RowConstraints row3 = new RowConstraints();
	    row3.setPercentHeight(30);
	    
	    
	    gp.getRowConstraints().addAll(row1, row2,row3); 
	   
	    Pane p[] =new Pane[3];
	    for(int i=0;i<3;i++){
	    	try {
				p[i] = createPane();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    	gp.add(p[i] , 0, i);
	    }	
	    
	    
		return gp;
	}
	*/
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		data = FXCollections.observableArrayList(new hotelItem("Sun Hotel", 5, 10, "预定过",1500),
				new hotelItem("Sun Hotel", 5, 10, "预定过",1500),
				new hotelItem("Sun Hotel", 5, 10, "预定过",1500),
				new hotelItem("Sun Hotel", 5, 10, "预定过",1500)
				);
		tc_name.setCellValueFactory(new PropertyValueFactory<Object, Object>("name"));
		tc_star.setCellValueFactory(new PropertyValueFactory<Object, Object>("star"));
		tc_score.setCellValueFactory(new PropertyValueFactory<Object, Object>("score"));
		tc_isReserved.setCellValueFactory(new PropertyValueFactory<Object, Object>("isReserved"));
		tc_price.setCellValueFactory(new PropertyValueFactory<Object, Object>("price"));
		tv_hotel.setItems(data);
	}
	
	
	public static class hotelItem{
		private SimpleStringProperty name;
		private SimpleIntegerProperty star;
		private SimpleIntegerProperty score;
		private SimpleStringProperty isReserved;
		private SimpleIntegerProperty price;
		
		private hotelItem(String name,int star,int score,String isReserved,int price){
			this.name=new SimpleStringProperty(name);
			this.star=new SimpleIntegerProperty(star);
			this.score=new SimpleIntegerProperty(score);
			this.isReserved=new SimpleStringProperty(isReserved);
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
		
		public String getIsReserved(){
			return isReserved.get();
		}
		
		public void setIsReserved(String str){
			isReserved.set(str);
		}
		
		public int getPrice(){
			return price.get();
		}
		
		public void setPrice(int n){
			price.set(n);
		}
		
		
	}

}
