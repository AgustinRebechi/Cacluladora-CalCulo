package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController {
    @FXML private ImageView closeButtom, minimizeButtom;
    @FXML private Pane titlePane;

    private double x,y;

    public void init(Stage stage) {

        // evento cerrar y minimizar

        closeButtom.setOnMouseClicked(mouseEvent -> stage.close());

        minimizeButtom.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

        // arrastrar la ventana

        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        // cambio de graficos en botones
        closeButtom.setOnMouseEntered(event -> {
            closeButtom.setImage(new Image(getClass().getResource("/assets/icons/Close-hover.png").toExternalForm()));
        });

        closeButtom.setOnMouseExited(event -> {
            closeButtom.setImage(new Image(getClass().getResource("/assets/icons/Close.png").toExternalForm()));
        });

        minimizeButtom.setOnMouseEntered(event -> {
            minimizeButtom.setImage(new Image(getClass().getResource("/assets/icons/Minimize-hover.png").toExternalForm()));
        });

        minimizeButtom.setOnMouseExited(event -> {
            minimizeButtom.setImage(new Image(getClass().getResource("/assets/icons/Minimize.png").toExternalForm()));
        });



    }
}
