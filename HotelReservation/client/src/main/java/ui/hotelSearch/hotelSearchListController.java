package ui.hotelSearch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		pagination.setStyle("-fx-border-color:blue;");
		pagination.setPageFactory(new Callback<Integer, Node>() {
			public Node call(Integer pageIndex) {
				return createPage(pageIndex);
			}
		});
		
		
		
		
	}

}
