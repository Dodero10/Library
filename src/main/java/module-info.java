module com.example.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql.rowset;


    opens com.example.library to javafx.fxml;
    exports com.example.library;
    exports com.example.library.Controllers;
}