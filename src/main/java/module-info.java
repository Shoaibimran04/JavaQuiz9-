module com.example.javaquiz9 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javaquiz9 to javafx.fxml;
    exports com.example.javaquiz9;
}