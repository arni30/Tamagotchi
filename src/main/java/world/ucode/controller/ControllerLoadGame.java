package world.ucode.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import world.ucode.Tamagotchi;
import world.ucode.character.Character;
import world.ucode.character.CharacterType;
import world.ucode.scenes.GamePlayScene;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerLoadGame extends Controller {
    private Map<String, CharacterType> characterType = new HashMap<>();
    @FXML
    private ListView<String> gameList;
    private Character character = null;
    public ControllerLoadGame(Stage stage) {
        super(stage);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        ResultSet rs = Tamagotchi.db.selectAll();
        ResultSet rs1 = rs;
        try {
            while (rs1.next()) {
                gameList.getItems().addAll(rs.getString("type") + " " + rs.getString("name"));
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void startLoadedGame() throws IOException, SQLException {
        characterType.put(CharacterType.SPONGEBOB.toString(), CharacterType.SPONGEBOB);
        characterType.put(CharacterType.PATRICK.toString(), CharacterType.PATRICK);
        characterType.put(CharacterType.SQUIDWARD.toString(), CharacterType.SQUIDWARD);

            ResultSet rs = Tamagotchi.db.selectAll();
            try {
                while (rs.next()) {
                    if (rs.getRow() - 1 == gameList.getSelectionModel().getSelectedIndex()) {
                        setStats(rs);
                        character.startLiveCycle();
                        character.timelineScore.play();
                    }
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        if (gameList.getSelectionModel().isSelected(gameList.getSelectionModel().getSelectedIndex())) {
            character.timelineScore.play();
            GamePlayScene gamePlayScene =
                    new GamePlayScene("/gamePlay.fxml",
                            new ControllerGamePlay(character, primaryStage), primaryStage, character);
            gamePlayScene.setScene();
        }
    }
    private void setStats(ResultSet rs) throws SQLException {
        character = new Character(
                rs.getString("name"),
                characterType.get(rs.getString("type")),
                rs.getDouble("health"),
                rs.getDouble("hunger"),
                rs.getDouble("thrist"),
                rs.getDouble("cleanlines"),
                rs.getDouble("happiness")
        );
    }

}
