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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
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
	
	private static int itemsPerPage=4;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
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
		return p;
	}
	
	public GridPane createPage(int PageIndex){
		GridPane gp=new GridPane();
		RowConstraints row1 = new RowConstraints();
	    row1.setPercentHeight(20);
	    RowConstraints row2 = new RowConstraints();
	    row2.setPercentHeight(20);
	    RowConstraints row3 = new RowConstraints();
	    row3.setPercentHeight(20);
	    RowConstraints row4 = new RowConstraints();
	    row4.setPercentHeight(20);
	    Button btn[]=new Button[4];
	    for(int i=1;i<=4;i++){
	    	btn[i-1]=new Button("Button"+i);
	    }
	    Pane p = null;
		try {
			p = createPane();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gp.getRowConstraints().addAll(row1, row2,row3,row4); 
	    
	    gp.add(p, 0,0);
	    
	    gp.add(btn[1], 0, 1);
	    gp.add(btn[2], 0, 2);
	    gp.add(btn[3], 0, 3);
	    
	    
	   
		return gp;
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		pagination.setStyle("-fx-border-color:blue;");
		pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
		
		
		
		
	}

}
