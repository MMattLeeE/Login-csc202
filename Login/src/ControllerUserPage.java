import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
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

    public String usernameLogin;
    public User user;

    public Button logoutBtn;

    @Override
    public void initialize(URL location, ResourceBundle resource) {

        logoutBtn.setOnAction(event -> {
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

        stage = (Stage) logoutBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setUserInfo(String loginUsername) {
        this.usernameLogin = loginUsername;
        username.setText(usernameLogin);

        for (int i = 0; i < UserDB.getUsersArrayList().size(); i++) {
            if (username.getText().equals(UserDB.getUsersArrayList().get(i).getUsername())) {
                this.user = UserDB.getUsersArrayList().get(i);
            }
        }

        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        ssn.setText(user.getSsn());
        dob.setText(user.getDob());
        gender.setText(user.getGender());
        password.setText(user.getPassword());
        email.setText(user.getEmail());
        phoneNumber.setText(user.getPhoneNumber());
        profilePhoto.setText(user.getProfilePhoto());
    }
}
