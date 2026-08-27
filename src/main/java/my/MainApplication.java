package my;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {

    private double dragOffsetX, dragOffsetY;

    @Override
    public void start(Stage stage) throws IOException {

        /*URL fxmlUrl = getClass().getResource("/my/persons_ui-view.fxml");
        HBox root = new FXMLLoader(fxmlUrl).load();*/

        URL fxmlUrl = getClass().getResource("/my/persons_ui-view.fxml");
        AnchorPane root = FXMLLoader.<AnchorPane>load(fxmlUrl);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

        scene.setOnMousePressed(event -> {
            dragOffsetX = event.getScreenX() - stage.getX();
            dragOffsetY = event.getScreenY() - stage.getY();
        });

        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - dragOffsetX);
            stage.setY(event.getScreenY() - dragOffsetY);
        });
    }
}