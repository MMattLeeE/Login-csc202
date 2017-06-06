package Controller;

import Model.User;
import Model.UserCurrent;
import Model.UserDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set the action for logging in
        login.setOnAction(e -> {
            authenticate(e);
        });

        //set action listener for the register button; takes you to registration page
        registerBtn.setOnAction(e -> {
            try {
                LoadPage.loadRegistrationPage(e);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    /**
     *  Authenticate checks if the username exists in the database
     *  and checks if the password matches the corresponding username
     *
     *  It then sets the authenticated user as the current user in UserCurrent.java
     *
     *  Finally the User page is loaded using LoadPage.loadUserPage(event)
     */
    @FXML
    private void authenticate(ActionEvent event) {
        User user = null;
        //check to see if the username and password fields are not empty
        if (usernameInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
            displayMessage("Please enter a username and password", Color.RED);
        } else {

            //Iterates through the array list database
            for (int i = 0; i < UserDB.getUsersArrayList().size(); i++) {
                //check to see if a username user inputs exists
                if (usernameInput.getText().equals(UserDB.getUsersArrayList().get(i).getUsername())) {
                    user = UserDB.getUsersArrayList().get(i);
                }
            }

            //if a username is not found:
            if (user==null) {
                displayMessage("Username not found", Color.RED);
                //if a username exists, check to see user input password is correct
            } else if (passwordInput.getText().equals(user.getPassword())) {
                //if password for the given username matches output, successful login message
                displayMessage("Login Successful. Welcome " + usernameInput.getText(), Color.GREEN);
                //set the current user in UserCurrent.java so that the user data can be read by ControllerUserPage.java
                UserCurrent.setCurrentUser(user);
                try {
                    LoadPage.loadUserPage(event);
                } catch (IOException ex) {
                    System.err.println("problem loading user page");
                }
            } else {
                //if the password does not match for the given username:
                displayMessage("password for " + usernameInput.getText() + " does not match", Color.RED);
            }
        }
    }

    //used to display messages to user on login screen.
    // Specify Color of display message font.
    private void displayMessage(String message, Color fontColor){
        errorLabel.setText(message);
        errorLabel.setVisible(true);
        errorLabel.setTextFill(fontColor);
    }

}