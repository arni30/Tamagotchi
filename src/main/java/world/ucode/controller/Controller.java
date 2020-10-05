package world.ucode.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class Controller implements Initializable {
    public String onHoverEnter;
    public String onHoverExit;
    public static Stage primaryStage;
    public Controller(Stage stage) {
        primaryStage = stage;
        this.onHoverEnter = "-fx-effect: dropshadow( gaussian , blue , 1,1,1,1 ); -fx-background-color: transparent";
        this.onHoverExit = "-fx-effect: dropshadow( gaussian , red , 1,1,1,1 ); -fx-background-color: transparent";
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonsSetStyle();
    }

    void buttonsSetStyle() {
    }

    void buttonSetStyleHover(Button button) {
        button.setOnMouseEntered(e -> button.setStyle(onHoverEnter));
        button.setOnMouseExited(e -> button.setStyle(onHoverExit));
    }
}
