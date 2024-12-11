package com.example.new_javafx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label statusLabel;

    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("oboy") && password.equals("passboy")) {
            statusLabel.setText("Login successful!");
            statusLabel.setStyle("-fx-text-fill: green;");

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Success");
            alert.setHeaderText(null);
            alert.setContentText("Welcome " + username + "!");
            alert.showAndWait();

            switchToScene();
        } else {
            statusLabel.setText("Invalid username or password");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private void switchToScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Stage stage = (Stage) statusLabel.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
