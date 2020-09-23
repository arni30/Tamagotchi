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
    public Parent root;
    public FXMLLoader loader;
    @Override
    public void start(Stage primaryStage) {
        try {
            loader = new FXMLLoader(getClass().getResource("/Tamagotchi.fxml"));
            loader.setController(new ButtonControler());
            root = loader.load();
            NewGameScene scene = new NewGameScene();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch (Exception e) {
            System.err.println("error");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
