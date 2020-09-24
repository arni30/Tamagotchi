package world.ucode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Tamagotchi extends Application {
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        try {
            MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.setScene();
            stage.show();
        }
        catch (Exception e) {
            System.err.println("error");
        }
    }
    static public Stage getPrimaryStage() {
        return stage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
