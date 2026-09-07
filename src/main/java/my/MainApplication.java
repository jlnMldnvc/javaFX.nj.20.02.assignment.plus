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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/my/netpackage_view.fxml"));
        AnchorPane root = fxmlLoader.load();
        //
        Scene scene = new Scene(root, 1100, 600);

        // load CSS from resources/my/style.css
        URL css = getClass().getResource("/my/style.css");
        if (css != null) scene.getStylesheets().add(css.toExternalForm());

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Net Package Registration System");
        stage.setScene(scene);

        // min window size
        stage.setMinWidth(1000);
        stage.setMinHeight(500);

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