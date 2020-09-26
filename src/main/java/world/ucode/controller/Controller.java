package world.ucode.controller;

import javafx.stage.Stage;

public abstract class Controller {
    public String onHoverEnter;
    public String onHoverExit;
    public Stage primaryStage;
    public Controller(Stage stage) {
        primaryStage = stage;
        onHoverEnter = "-fx-effect: dropshadow( gaussian , blue , 1,1,1,1 ); -fx-background-color: transparent";
        onHoverExit = "-fx-effect: dropshadow( gaussian , red , 1,1,1,1 ); -fx-background-color: transparent";
    }
}
