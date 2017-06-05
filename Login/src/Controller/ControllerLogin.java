package Controller;

import Model.UserDB;
import Model.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matt on 5/27/2017.
 */
public class ControllerLogin implements Initializable {


    @FXML
    private Button registerBtn;
    @FXML
    private Button login;
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Label errorLabel;

    public String username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set the action for logging in
        login.setOnAction(e -> {
            authenticate();
        });

        //set action listener for the register button; takes you to registration page
        registerBtn.setOnAction(e -> {
            try {
                loadRegisterPage();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void loadRegisterPage() throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) registerBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View/registerPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }//end of loadRegisterPage method

    @FXML
    private void authenticate() {
        //check to see if the username and password fields are not empty
        if (usernameInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
            displayMessage("Please enter a username and password", Color.RED);
        } else {
            //Iterates through the array list database
            for (int i = 0; i < UserDB.getUsersArrayList().size(); i++) {
                //check to see if a username user inputs exists
                if (usernameInput.getText().equals(UserDB.getUsersArrayList().get(i).getUsername())) {
                    //if a username exists, check to see user input password is correct
                    if (passwordInput.getText().equals(UserDB.getUsersArrayList().get(i).getPassword())) {
                        //if password for the given username matches output successful login message
                        displayMessage("Login Successful. Welcome " + usernameInput.getText(), Color.GREEN);
                        try {
                            loadUserPage();
                        } catch (IOException ex) {
                            System.err.println("problem loading user page");
                        }
                    } else {
                        //if the password does not match for the given username:
                        displayMessage("password for " + usernameInput.getText() + " does not match", Color.RED);
                    }
                } else {
                    //if a username is not found:
                    displayMessage("Username not found",Color.RED);
                }
            }
        }
    }//end of authenticate method

    //used to display messages to user on login screen. Can specify a Color to display message font
    private void displayMessage(String message, Color fontColor){
        errorLabel.setText(message);
        errorLabel.setVisible(true);
        errorLabel.setTextFill(fontColor);
    }

    private void loadUserPage() throws IOException{
        Stage stage;
        Parent root;

        username = usernameInput.getText();

        stage = (Stage) login.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userPage.fxml"));
        root = fxmlLoader.load();

        ControllerUserPage controller = fxmlLoader.<ControllerUserPage>getController();
        controller.setUserInfo(username);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}//end of controllerLogin class
