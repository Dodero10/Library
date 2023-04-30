package com.example.library.Controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class dasboardController implements Initializable {


    public Circle circle_image;
    public Label studentNumber_lbl;
    public Button edit_btn;
    public Button availableBook_btn;
    public Button issueBook_btn;
    public Button returnBook_btn;
    public Button saveBook_btn;
    public Button signOut_btn;
    public AnchorPane availableBook_font;
    public ImageView availableBookImage;
    public Button take_btn;
    public Button save_btn;
    public Label availableBook_title;
    public TableView availableBooks_table;
    public TableColumn col_ab_bookTitle;
    public TableColumn col_ab_author;
    public TableColumn col_ab_bookType;
    public TableColumn col_ab_publicDate;
    public Button exit_btn;
    public Button bars_btn;
    public Button arrows_btn;
    public AnchorPane nav_form;
    public AnchorPane mainCenter_form;

    private double x = 0;
    private double y = 0;

    @FXML
    public void logout(ActionEvent event){

        try {
            if (event.getSource() == signOut_btn) {
                // TO swap from dashboard view to login view
                Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

//                root.setOnMouseDragged((MouseEvent mouseEvent) ->{
//                    stage.setX(mouseEvent.getScreenX() -x);
//                    stage.setY(mouseEvent.getScreenY() - y);
//                });
//                root.setOnMousePressed((MouseEvent event1) ->{
//                    x = event1.getClientX();
//                    y = event1.getClientX();
//                });

                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();

                signOut_btn.getScene().getWindow().hide();

            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void exit(){
        System.exit(0);
    }

    public void slideArrow(){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(-225);
//
//        TranslateTransition slide1 = new TranslateTransition();
//
//        slide1.setDuration(Duration.seconds(.5));
//        slide1.setNode(mainCenter_form);
//        mainCenter_form.setMinWidth(762);
//        slide1.setToX(-225);
//        slide1.play();

        slide.setOnFinished((ActionEvent event) ->{
            arrows_btn.setVisible(false);
            bars_btn.setVisible(true);
        });

        slide.play();
    }

    public void sliderBars(){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(0);

        slide.setOnFinished((ActionEvent event) ->{
            arrows_btn.setVisible(true);
            bars_btn.setVisible(false);
        });

        slide.play();


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
