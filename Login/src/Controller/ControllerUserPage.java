package Controller;

import Model.UserCurrent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matt on 6/4/2017.
 */
public class ControllerUserPage implements Initializable{

    public Label firstName;
    public Label lastName;
    public Label ssn;
    public Label dob;
    public Label gender;
    public Label username;
    public Label password;
    public Label email;
    public Label phoneNumber;
    public Label profilePhoto;

    public ImageView imageView;
    public Button logoutBtn;

    @Override
    public void initialize(URL location, ResourceBundle resource) {

        displayCurrentUserInfo();

        logoutBtn.setOnAction(e -> {
            try {
                LoadPage.loadLoginPage(e);
            } catch (IOException ex) {
                System.err.println("Issue going back to login page");
            }
        });
    }

    private void displayCurrentUserInfo() {

        firstName.setText(UserCurrent.getCurrentUserFirstName());
        lastName.setText(UserCurrent.getCurrentUserLastName());
        ssn.setText(UserCurrent.getCurrentUserSsn());
        dob.setText(UserCurrent.getCurrentUserDob());
        gender.setText(UserCurrent.getCurrentUserGender());
        username.setText(UserCurrent.getCurrentUserUsername());
        password.setText(UserCurrent.getCurrentUserPassword());
        email.setText(UserCurrent.getCurrentUserEmail());
        phoneNumber.setText(UserCurrent.getCurrentUserPhoneNumber());
        profilePhoto.setText(UserCurrent.getCurrentUserProfilePhoto());

        Image image = new Image("file:" + profilePhoto.getText(),333,263,true,false);
        imageView.setImage(image);
    }

}
