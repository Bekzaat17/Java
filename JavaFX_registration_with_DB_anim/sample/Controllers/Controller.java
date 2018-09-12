package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;
import sample.animations.shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registrationButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void initialize() {

        loginButton.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String passwordText = passwordField.getText().trim();

            if(!loginText.equals("") && !passwordText.equals("")){
                loginUser(loginText, passwordText);
            } else {
                shake userLoginAnim = new shake(loginField);
                shake userPasswordAnim = new shake(passwordField);
                userLoginAnim.playAnim();
                userPasswordAnim.playAnim();
            }
        });


        registrationButton.setOnAction(event -> {
           openNewScene(registrationButton,"/sample/View/registration.fxml");

        });
    }

    private void loginUser(String loginText, String passwordText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        try{
        while(result.next()){
            counter++;
        }}catch(SQLException e){
           e.printStackTrace();
        }
        if(counter >= 1){
            openNewScene(registrationButton, "/sample/View/app.fxml");
        } else {
            shake userLoginAnim = new shake(loginField);
            shake userPasswordAnim = new shake(passwordField);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();
        }
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
