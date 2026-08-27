module my.myjavafx20mvcplus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    exports my;
    opens my to javafx.fxml;
}