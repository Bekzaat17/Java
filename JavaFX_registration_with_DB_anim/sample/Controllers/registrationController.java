package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;
import sample.Controllers.Controller;

public class registrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lastnameField;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField countryField;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    void initialize() {

        registrationButton.setOnAction(event -> {
            registerNewUser();
            openNewScene(registrationButton,"/sample/View/sample.fxml");
        });

    }

    private void registerNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = nameField.getText();
        String lastname = lastnameField.getText();
        String username = loginField.getText();
        String password = passwordField.getText();
        String location = countryField.getText();
        String gender = "";
        if(radioMale.isSelected())
            gender = "Male";
        else
            gender = "Female";

        User user = new User(name, lastname, username, password, location, gender);

        dbHandler.registerUser(user);
    }

    public void openNewScene(Button buttonName, String window){

        buttonName.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
