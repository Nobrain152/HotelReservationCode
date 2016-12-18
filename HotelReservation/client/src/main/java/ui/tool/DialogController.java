package ui.tool;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DialogController  extends AnchorPane{
    @FXML
    Label Message;
    @FXML
    TitledPane TitledPane;
    
    private static DialogController wiAlertDialog;
    private static Stage  newAlertDialog ;
    
    private  DialogController(String message) {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        fXMLLoader.setRoot(DialogController.this);
        fXMLLoader.setController(DialogController.this);
        try {
            fXMLLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        TitledPane.setFocusTraversable(false);
        Message.setText(message);
    }
    
    public static void showAlertDialog(String message) {
        newAlertDialog = new Stage(StageStyle.TRANSPARENT);
        newAlertDialog.setResizable(false);
        wiAlertDialog = new DialogController(message);
        newAlertDialog.setScene(new Scene(wiAlertDialog));
        newAlertDialog.show();
    }
    
    public static void hideAlertDialog() {
        if(newAlertDialog != null) {
            newAlertDialog.hide();
        }
    }

    @FXML
    private void onAlertOKClick(ActionEvent event) {
    	DialogController.hideAlertDialog();
    }
}
