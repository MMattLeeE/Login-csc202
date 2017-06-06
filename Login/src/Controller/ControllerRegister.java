package Controller;

import Model.User;
import Model.UserDB;
import Model.UserIO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


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
    public Label emailLabel;
    public Label ssnLabel;
    public Label phoneNumberLabel;
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

    public String photoPath = "";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerBtn.setOnAction(event -> {
            if(validateInputs()) {
                addUser();
                try {
                    loadRegisterSuccess();
                } catch (IOException e) {
                    System.err.println("problem loading registration success page");
                }
            }
        });

        backLogin.setOnAction(e -> {
            try {
                loadLoginPage();

            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        });

        addPhotoBtn.setOnAction(event -> {
            photoPath = addPhoto();
        });

    }

    private boolean validateInputs() {
        boolean output = false;
        if (!isMissingInput()) {
            boolean UsernameCheck = checkUsername();
            boolean EmailCheck = checkEmail();
            boolean PasswordCheck = checkPassword();
            boolean DOBCheck = checkDOB();
            boolean phoneNumberCheck = checkPhoneNumber();
            boolean SSNcheck = checkSSN();

            if (UsernameCheck && EmailCheck && PasswordCheck && DOBCheck && phoneNumberCheck && SSNcheck) {
                output = true;
            }
        }
        return output;
    }

    private void addUser() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String ssn = ssnInput.getText();
        String dob = dateInput.getText();
        String gender = getRadio();
        String username = newUsernameInput.getText();
        String password = newPasswordInput.getText();
        String email = emailInput.getText();
        String phoneNumber = phoneNumberInput.getText();

        User newUser = new User(firstName,lastName,ssn,dob,gender,username,password,email,phoneNumber,photoPath);
        UserDB.getUsersArrayList().add(newUser);

        try {
            UserIO.writeUsers(UserDB.getUsersArrayList());
        } catch (IOException e) {
            System.err.println("can't write new user to dat file");
        }

    }

    private boolean checkSSN() {
        boolean output = true;
        if (!ssnInput.getText().isEmpty()) {
            Pattern ssnPattern = Pattern.compile("^(?!000|666)[0-8][0-9]{2}(?!00)[0-9]{2}(?!0000)[0-9]{4}$");
            if (!ssnPattern.matcher(ssnInput.getText()).matches()) {
                output = false;
                errorsLabel.setTextFill(Color.RED);
                ssnLabel.setTextFill(Color.RED);
                errorsLabel.setText(errorsLabel.getText() + "\n" + "+The ssn needs to be 10 digits no spaces.");
                errorsLabel.setVisible(true);
            } else {
                ssnLabel.setTextFill(Color.BLACK);

            }
        }
        return output;
    }
    private boolean checkEmail() {
        boolean output = true;

        if (!emailInput.getText().isEmpty()) {

            Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@\\Qmail\\E[a-zA-Z0-9.-]+$");

            if (patternEmail.matcher(emailInput.getText()).matches()) {
                emailLabel.setTextFill(Color.BLACK);
                output = true;

            } else {
                errorsLabel.setText(errorsLabel.getText() + "\n" + "+Email must be of format xxxx@mail.xxx, for example Msl2420@mail.vccs.edu.");
                errorsLabel.setVisible(true);
                emailLabel.setTextFill(Color.RED);
            }
        }
        return output;
    }
    private boolean checkDOB() {

        SimpleDateFormat dobFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dt = null;

        try {
            dt = dobFormat.parse(dateInput.getText());
            dobLabel.setTextFill(Color.BLACK);
            return true;

        } catch (ParseException e) {
            errorsLabel.setTextFill(Color.RED);
            dobLabel.setTextFill(Color.RED);
            errorsLabel.setText(errorsLabel.getText() + "\n" + "+The date must be of format mm/dd/yyyy separated by slashes.");
            errorsLabel.setVisible(true);
            return false;
        }

    }
    private boolean checkPassword() {
        boolean output = false;

        if (!newPasswordInput.getText().isEmpty()) {
            Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");
            if (patternPassword.matcher(newPasswordInput.getText()).matches()) {
                newPasswordLabel.setTextFill(Color.BLACK);
                if (!newPasswordInput.getText().equals(confirmNewPasswordInput.getText())) {
                    errorsLabel.setText(errorsLabel.getText() + "\n" + "+Passwords do not match.");
                    errorsLabel.setVisible(true);
                    newPasswordLabel.setTextFill(Color.RED);
                    confirmPasswordLabel.setTextFill(Color.RED);
                } else {
                    output = true;

                }
            } else {
                errorsLabel.setText(errorsLabel.getText() + "\n" + "+Password needs one: uppercase letter, lowercase letter, special character, number, and at least 8 characters in length.");
                errorsLabel.setVisible(true);
                newPasswordLabel.setTextFill(Color.RED);
            }
        }
        return output;
    }
    private boolean checkUsername() {
        boolean output = true;

        for (int i = 0; i < UserDB.getUsersArrayList().size(); i++) {
            if (newUsernameInput.getText().equals(UserDB.getUsersArrayList().get(i).getUsername())) {
                errorsLabel.setText(errorsLabel.getText() + "\n" + "+" + newUsernameInput.getText() + " already exists. Pick another username.");
                errorsLabel.setVisible(true);
                newUsernameLabel.setTextFill(Color.RED);
                output = false;
            }
        }
        return output;
    }
    private boolean checkPhoneNumber() {
        boolean output = true;
        if (!phoneNumberInput.getText().isEmpty()) {
            Pattern phoneNumberPattern = Pattern.compile("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$");
            if (!phoneNumberPattern.matcher(phoneNumberInput.getText()).matches()) {
                output = false;
                errorsLabel.setTextFill(Color.RED);
                phoneNumberLabel.setTextFill(Color.RED);
                errorsLabel.setText(errorsLabel.getText() + "\n" + "+The phone number must be ten digits with the area code.");
                errorsLabel.setVisible(true);
            } else {
                phoneNumberLabel.setTextFill(Color.BLACK);

            }
        }
        return output;
    }
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
        errorsLabel.setText("");

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

    private String getRadio() {
        if (radioMale.isSelected()) {
            return radioMale.getText();
        } else {
            return radioFemale.getText();
        }
    }

    private String addPhoto() {
        String photoLocation="";
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog((Stage) addPhotoBtn.getScene().getWindow());
        if(file!= null) {
            photoLocation = file.getAbsolutePath();
        }
        return photoLocation;
    }

    private void errorMessageBlankFields() {
        errorsLabel.setText("Required information in red");
        errorsLabel.setVisible(true);
    }

    private void loadRegisterSuccess() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) registerBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View/registrationSuccess.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void loadLoginPage() throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) backLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View/loginPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
