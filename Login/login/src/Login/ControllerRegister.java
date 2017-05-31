package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matt on 5/27/2017.
 */
public class ControllerRegister implements Initializable {

    public Label firstNameLabel;
    public Label lastNameLabel;
    public Label dobLabel;
    public Label genderLabel;
    public Label newUsernameLabel;
    public Label newPasswordLabel;
    public Label confirmPasswordLabel;
    public Label errorsLabel;
    @FXML
    private TextField dateInput;//required
    @FXML
    private TextField ssnInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField phoneNumberInput;
    @FXML
    private TextField firstNameInput;//required
    @FXML
    private TextField lastNameInput;//required
    @FXML
    private TextField newUsernameInput;//required
    @FXML
    private TextField newPasswordInput;//required
    @FXML
    private TextField confirmNewPasswordInput;//required
    @FXML
    private Button registerBtn;
    @FXML
    private Button addPhotoBtn;
    @FXML
    private Button backLogin;
    @FXML
    private RadioButton radioMale;//required
    @FXML
    private RadioButton radioFemale;//required


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerBtn.setOnAction(event -> {
            validateInputs();
        });

        backLogin.setOnAction(e -> {
            try {
                loadRegisterPage();

            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        });
    }

    @FXML
    private void validateInputs() {
        if (!isMissingInput()) {
            if (checkUsername() && checkEmail() && checkPassword() && checkDOB()) {

            }
        }
    }

    private boolean checkEmail() {
        boolean output = false;
        if (!emailInput.getText().isEmpty()) {

        }
        return output;
    }

    private boolean checkDOB() {
        boolean output = false;

        return output;
    }

    private boolean checkPassword() {
        boolean output = false;

        return output;
    }

    private boolean checkUsername() {
        boolean output = false;

        return output;
    }

    @FXML
    private void loadRegisterPage() throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) backLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private boolean isMissingInput() {
        boolean output=false;

        firstNameLabel.setTextFill(Color.BLACK);
        lastNameLabel.setTextFill(Color.BLACK);
        newUsernameLabel.setTextFill(Color.BLACK);
        newPasswordLabel.setTextFill(Color.BLACK);
        confirmPasswordLabel.setTextFill(Color.BLACK);
        genderLabel.setTextFill(Color.BLACK);
        dobLabel.setTextFill(Color.BLACK);
        errorsLabel.setVisible(false);

        errorsLabel.setTextFill(Color.RED);

        if (firstNameInput.getText().isEmpty()) {
            firstNameLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        if (lastNameInput.getText().isEmpty()) {
            lastNameLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        if (newUsernameInput.getText().isEmpty()) {
            newUsernameLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        if (newPasswordInput.getText().isEmpty()) {
            newPasswordLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        if (confirmNewPasswordInput.getText().isEmpty()) {
            confirmPasswordLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        if (!radioMale.isSelected() && !radioFemale.isSelected()) {
            genderLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        if (dateInput.getText().isEmpty()) {
            dobLabel.setTextFill(Color.RED);
            errorMessageBlankFields();
            output = true;
        }
        return output;
    }

    @FXML
    private void errorMessageBlankFields() {
        errorsLabel.setText("Required information in red");
        errorsLabel.setVisible(true);
    }
}
