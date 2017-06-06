package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Matt on 6/6/2017.
 *
 *  Centralize page loading functions as static functions.
 *  Helps to put all the .fxml file paths in one place.
 *  Takes a button click event and determines the stage by finding the source(i.e. button) of the event and
 *  getting the stage of that source.
 */
public class LoadPage {

    public static void loadLoginPage(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Control) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(ControllerLogin.class.getResource("/View/loginPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void loadRegistrationPage(ActionEvent event) throws IOException{

        Stage stage = (Stage) ((Control) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(ControllerRegister.class.getResource("/View/registerPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void loadRegSuccessPage(ActionEvent event) throws IOException{

        Stage stage = (Stage) ((Control) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(ControllerRegSuccess.class.getResource("/View/registrationSuccess.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void loadUserPage(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Control) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(ControllerRegSuccess.class.getResource("/View/userPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
