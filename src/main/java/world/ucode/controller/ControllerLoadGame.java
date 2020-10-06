package world.ucode.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import world.ucode.Tamagotchi;
import world.ucode.model.Character;
import world.ucode.model.CharacterType;
import world.ucode.view.GamePlayScene;
import world.ucode.view.MainMenuScene;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerLoadGame extends Controller {
    private Map<String, CharacterType> characterType = new HashMap<>();
    @FXML
    private ListView<String> gameList;
    @FXML
    private Button back;
    @FXML
    private Button selectGame;
    private Character character = null;
    public ControllerLoadGame(Stage stage) {
        super(stage);
    }
    @Override
    void buttonsSetStyle() {
        buttonSetStyleHover(selectGame);
        buttonSetStyleHover(back);
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
    private void back() throws IOException {
        MainMenuScene mainMenuScene = new MainMenuScene("/Tamagotchi.fxml", new ControllerMainMenu(primaryStage), primaryStage);
        mainMenuScene.setScene();
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
