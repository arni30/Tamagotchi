package world.ucode.scenes;

import javafx.stage.Stage;
import world.ucode.character.Character;

public class GamePlayScene extends Scenes {
    final private Character character;
    public GamePlayScene(String fxml, Object controller, Stage stage, Character character) {
        super(fxml, controller, stage);
        this.character = character;
    }
}
