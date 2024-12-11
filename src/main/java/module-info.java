module com.example.new_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.new_javafx to javafx.fxml;
    exports com.example.new_javafx;
}