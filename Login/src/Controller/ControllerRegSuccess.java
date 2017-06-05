package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
        okBtn.setOnAction(event -> {
            try {
                loadLoginPage();
            } catch (IOException e) {
                System.err.println("Issue going back to login page");
            }
        });
    }

    private void loadLoginPage() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) okBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View/loginPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
