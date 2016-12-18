package ui.hotelEvaluate;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.CustomerHotelOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import vo.HotelEvaluateVO;

public class hotelEvaluateViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerHotelOperationController eval;
	
	@FXML
	private TextField tf_score;
	
	@FXML
	private TextArea ta_comment;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Submit;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotoreservedHotelInfo();
	}
	
	@FXML
	public void btn_SubmitAction(ActionEvent ev) {
		int score=Integer.parseInt(tf_score.getText());
		HotelEvaluateVO evaluation=new HotelEvaluateVO(helper.getUserID(),helper.getHotelID(),score,ta_comment.getText(),true,null);
		eval.HotelEvaluate(evaluation);
		application.gotoreservedHotelInfo();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		eval=new CustomerHotelOperationController();
	}

}
