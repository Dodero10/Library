package com.example.library.Controllers;

import com.example.library.SQL.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    public Button login_Btn;
    public TextField studentNumber;
    public PasswordField passWord;
    public Button close;
    public Button minimize;
// Datebase tools
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void login(){

        login_Btn.setOnMouseClicked(mouseEvent -> {

            String sql = "SELECT * FROM student WHERE studentNumber = ? and passwordStudent = ?";

            try{
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, studentNumber.getText());
                prepare.setString(2, passWord.getText());
                result = prepare.executeQuery();

                Alert alert;

                if(studentNumber.getText().isEmpty() || passWord.getText().isEmpty()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill the blank field");
                    alert.showAndWait();
                }else{
                    if(result.next()) {

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Admin Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfull Login");
                        alert.showAndWait();

                        // To hide login form
                        login_Btn.getScene().getWindow().hide();
                        // For Dasboard
                        Parent root = FXMLLoader.load(getClass().getResource("/FXML/dashboard.fxml"));

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();


                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Admin Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong username or password");
                        alert.showAndWait();
                    }
                }

            } catch (Exception e){e.printStackTrace();}
        });
//        String sql = "SELECT * FROM student WHERE studentNumber = ? and passwordStudent = ?";
//        DBConnect db = new DBConnect();
//
//        try{
//            prepare = connect.prepareStatement(sql);
//            prepare.setString(1, studentNumber.getText());
//            prepare.setString(2, passWord.getText());
//            result = prepare.executeQuery();
//
//            Alert alert;
//
//            if(studentNumber.getText().isEmpty() || passWord.getText().isEmpty()){
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Admin Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill the blank field");
//                alert.showAndWait();
//            }else{
//                if(result.next()) {
//
//                    alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Admin Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfull Login");
//                    alert.showAndWait();
//
//                    // For Dashboard
//                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/dashboard.fxml"));
//
//                    Stage stage = new Stage();
//
//                    Scene scene = new Scene(root);
//
//                    stage.setScene(scene);
//                    stage.show();
//
//                } else {
//                    alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Admin Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Wrong username or password");
//                    alert.showAndWait();
//                }
//            }
//
//        } catch (Exception e){e.printStackTrace();}
    }


    @FXML
    public void exit(){
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
