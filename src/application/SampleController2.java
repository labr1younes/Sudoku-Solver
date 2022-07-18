package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SampleController2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  TextArea idResult;

    @FXML
    void initialize() {
        assert idResult != null : "fx:id=\"idResult\" was not injected: check your FXML file 'Result.fxml'.";

    }
    
    public  void setidResult(String tmp) {
		
    	try {
			idResult.setText(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
