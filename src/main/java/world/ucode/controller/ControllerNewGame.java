package world.ucode.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import world.ucode.charaacter.Character;
import world.ucode.charaacter.CharacterType;
import world.ucode.scenes.GamePlayScene;
import world.ucode.scenes.MainMenuScene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControllerNewGame extends Controller {
    private int counter;
    @FXML
    private ImageView petImgView;
    ArrayList <Image> imgArr;
    public ControllerNewGame(Stage stage) {
        super(stage);
        imgArr = new ArrayList<Image>();
        imgArr.add(new Image("/spongChoose.gif"));
        imgArr.add(new Image("/patrickChoose.gif"));
        imgArr.add(new Image("/squidwardChoose.gif"));
        counter = 0;
    }

    @FXML
    public void rightArrow() {
        counter++;
        if (counter == 3)
            counter = 0;
        petImgView.setImage(imgArr.get(counter));
    }
    @FXML
    public void leftArrow() {
        counter--;
        if (counter == -1)
            counter = 2;
        petImgView.setImage(imgArr.get(counter));
    }
    @FXML
    public void back() throws IOException {
        MainMenuScene mainMenuScene = new MainMenuScene("/Tamagotchi.fxml", new ControllerMainMenu(primaryStage), primaryStage);
        mainMenuScene.setScene();
    }
    @FXML
    public void select() throws IOException {
        String name = "";
        Character character;
        Map<Integer, CharacterType> characterType = new HashMap<>();
        characterType.put(0, CharacterType.SPONGEBOB);
        characterType.put(1, CharacterType.PATRICK);
        characterType.put(2, CharacterType.SQUIDWARD);
        name = nameField.getText();
        if (name.length() > 0) {
            character = new Character(name, characterType.get(counter));
            character.startLiveCycle();
            character.timelineScore.play();
            System.out.println(characterType.get(counter).toString() + " " + name);
            GamePlayScene gamePlayScene = new GamePlayScene("/gamePlay.fxml", new ControllerGamePlay(character), primaryStage, character);
            gamePlayScene.setScene();
        }
        else
            nameField.setStyle("-fx-border-color: red; -fx-background-color: #00ff88");
    }
    //OnHoverEvents
    @FXML
    private Button select;
    @FXML
    private TextField nameField;
    @FXML
    private Button back;
    @FXML
    private Button rightArrow;
    @FXML
    private Button leftArrow;
    @FXML
    private void nameFieldEnter() {
        nameField.setStyle("-fx-border-color: none; -fx-background-color: #00ff88");
    }
    @FXML
    private void buttonBackEnter() {
        back.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonBackExit() {
        back.setStyle(onHoverExit);
    }

    @FXML
    private void buttonSelectEnter() {
        select.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonSelectExit() {
        select.setStyle(onHoverExit);
    }

    @FXML
    private void buttonRightArrowEnter() {
        rightArrow.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonRightArrowExit() {
        rightArrow.setStyle(onHoverExit);
    }
    @FXML
    private void buttonLeftArrowEnter() {
        leftArrow.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonLeftArrowExit() {
        leftArrow.setStyle(onHoverExit);
    }
}
