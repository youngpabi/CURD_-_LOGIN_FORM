package com.example.new_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Scene1 {
    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;



    private final ObservableList<User> userList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Configure the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Set the data for the table
        tableView.setItems(userList);

        // Add listeners for table selection
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nameField.setText(newSelection.getName());
                emailField.setText(newSelection.getEmail());
            }
        });
    }

    // Add a new user
    @FXML
    private void addUser() {
        int newId = userList.size() + 1;
        userList.add(new User(newId, nameField.getText(), emailField.getText()));
        clearFields();
    }

    // Update the selected user
    @FXML
    private void updateUser() {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            selectedUser.setName(nameField.getText());
            selectedUser.setEmail(emailField.getText());
            tableView.refresh();
            clearFields();
        }
    }

    // Delete the selected user
    @FXML
    private void deleteUser() {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            userList.remove(selectedUser);
            clearFields();
        }
    }

    // Clear input fields
    @FXML
    private void clearFields() {
        nameField.clear();
        emailField.clear();
        tableView.getSelectionModel().clearSelection();
    }
}

