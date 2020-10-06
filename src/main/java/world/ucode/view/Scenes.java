package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Scenes {
    private Stage primaryStage = null;
    javafx.scene.Scene scene = null;
    FXMLLoader loader;
    Scenes(String fxml, Object controller, Stage stage) {
        loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setController(controller);
        primaryStage = stage;
    }
    public void setScene() throws IOException {
        Parent root = loader.load();
        javafx.scene.Scene scene = new javafx.scene.Scene(root);
        if (primaryStage != null) {
            primaryStage.setScene(scene);
        }
    }
    javafx.scene.Scene getScene() {
        return scene;
    }
}
