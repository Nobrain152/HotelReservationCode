package ui;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.customerGuide.customerGuideController;
import ui.login.loginController;

public class UILaunch extends Application{
	private Stage stage;
	private final int  MINIMUM_WINDOW_WIDTH =600;
	private final int  MINIMUM_WINDOW_HEIGHT =400;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getResource("customerGuide/customerGuide.fxml"));
		
		//Scene scene= new Scene(root,MINIMUM_WINDOW_WIDTH,MINIMUM_WINDOW_HEIGHT);
		//stage.setTitle("Welcome");
		//stage.setScene(scene);
		//stage.show();
		
		stage = primaryStage;
		stage.setTitle("DIMENSION");
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		gotologin();	
		stage.show();
	}
	
	
	public void gotologin(){
		try{
			loginController login=(loginController) replaceSceneContent("login/login.fxml");
			login.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotocustomerGuide(){
		try{
			customerGuideController customerGuide=(customerGuideController) replaceSceneContent("customerGuide/customerGuide.fxml");
			customerGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
    private Initializable replaceSceneContent(String fxml) throws Exception{
    	FXMLLoader loader = new FXMLLoader();
		InputStream in = UILaunch.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(UILaunch.class.getResource(fxml));
		AnchorPane page;
		try{
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page,MINIMUM_WINDOW_WIDTH,MINIMUM_WINDOW_HEIGHT);
		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable)loader.getController();
	}
    
	public static void main(String[] args){
		launch(args);
	}
	

}