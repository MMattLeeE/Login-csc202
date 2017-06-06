package View;

import Model.User;
import Model.UserDB;
import Model.UserIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Matt on 5/27/2017.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadUserDB();

        Parent root = FXMLLoader.load(getClass().getResource("/View/loginPage.fxml"));

        Scene scene = new Scene(root, 600, 530);

        primaryStage.setTitle("Matt Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadUserDB() {
        try{
            System.out.println("+before user.dat is loaded into arraylist");
            UserDB.printArrayList();
            UserDB.setUsersArrayList((ArrayList<User>) UserIO.readUsers());
            System.out.println("+after user.dat is loaded into arraylist");
            UserDB.printArrayList();
        } catch(IOException e) {
            System.err.print("Can't read/open users.dat file");
        } catch(ClassNotFoundException e) {
            System.err.print("Model.User class issue preventing reading or casting Model.UserDB");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
