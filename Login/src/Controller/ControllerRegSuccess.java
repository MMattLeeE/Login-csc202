package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matt on 6/4/2017.
 */
public class ControllerRegSuccess implements Initializable {

    @FXML
    private Button okBtn;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        okBtn.setOnAction(e -> {
            try {
                LoadPage.loadLoginPage(e);
            } catch (IOException ex) {
                System.err.println("Issue going back to login page");
            }
        });
    }

}
