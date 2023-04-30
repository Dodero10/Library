package com.example.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage Stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        //Stage.initStyle(StageStyle.TRANSPARENT);

        Stage.setScene(scene);
        Stage.show();
    }
}
