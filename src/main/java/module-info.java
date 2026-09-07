module my.myjavafx20mvcplus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;

    exports my;
    exports my.models;
    exports my.controllers;

    opens my to javafx.fxml;
    opens my.models to javafx.fxml;
    opens my.controllers to javafx.fxml;
}