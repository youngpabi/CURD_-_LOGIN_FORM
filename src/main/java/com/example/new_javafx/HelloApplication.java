package com.example.new_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Use FXMLLoader to load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Load the FXML into an AnchorPane
        AnchorPane root = fxmlLoader.load();

        // Set up the Scene with the specified width and height
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Set the stage properties
        stage.setTitle("Login Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
