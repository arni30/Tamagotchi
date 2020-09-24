package world.ucode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
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

public class MainMenuScene {
    private Scene scene;

    public void setScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tamagotchi.fxml"));
        loader.setController(new ControllerMainMenu());
//        loaderSetController(loader, new ControllerMainMenu());
        Parent root = loader.load();
        scene = new Scene(root);
        Tamagotchi.getPrimaryStage().setScene(scene);
    }
//    private void loaderSetController(FXMLLoader loader, Object controller) {
//        loader.setController(controller);
//    }
}
