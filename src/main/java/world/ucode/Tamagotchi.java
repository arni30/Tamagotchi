package world.ucode;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Tamagotchi extends Application {
    @Override
    public void start(Stage primaryStage) {
        System.out.println("hallo");
        String musicFile = "z_uk-pryzhki.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
