package ui.hotelSearch;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import ui.UILaunch;

public class hotelSearchListController implements Initializable{
	private UILaunch application;
	
	
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Pagination pagination;
	
	
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
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
	
	 */
	
	public Pane createPane() throws IOException{
		Pane p ;
				
		FXMLLoader loader = new FXMLLoader();
		InputStream in = hotelSearchListController.class.getResourceAsStream("hotelPane.fxml");
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(hotelSearchListController.class.getResource("hotelPane.fxml"));
		
		try{
			p = (Pane) loader.load(in);
		} finally {
			in.close();
		}
		
		hotelPaneController hotelPaneController=loader.getController();
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
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
		pagination.setStyle("-fx-border-color:blue;");
		
		
	}
	
	

}
