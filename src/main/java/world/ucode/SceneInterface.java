package world.ucode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SceneInterface {
    private Stage primaryStage = null;
    Scene scene = null;
    FXMLLoader loader;
    SceneInterface(String fxml, Object controller, Stage stage) {
        loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setController(controller);
        primaryStage = stage;
    }
    public void setScene() throws IOException {
        Parent root = loader.load();
        Scene scene = new Scene(root);
        if (primaryStage != null) {
            primaryStage.setScene(scene);
        }
    }
    Scene getScene() {
        return scene;
    }
}
