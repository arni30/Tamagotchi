package world.ucode.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.animation.AnimationCharacter;
import world.ucode.charaacter.Character;
import world.ucode.charaacter.CharacterAction;
import world.ucode.charaacter.CharacterType;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGamePlay implements Initializable {
    public Timeline timelineScore;
    public AnimationCharacter animationCharacter;

    final private Character character;
    public ControllerGamePlay(Character character) {
        this.character = character;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProgress();
        startLiveCycle();
        timelineScore.play();
        if (this.character.getType() == CharacterType.SPONGEBOB) {
            characterView.setImage(new Image("/spongebobStatic.png"));
        }
        else if (this.character.getType() == CharacterType.PATRICK)
            characterView.setImage(new Image("/patrickStatic.png"));
        else if (this.character.getType() == CharacterType.SQUIDWARD)
            characterView.setImage(new Image("/squidwardStatic.png"));
        animationCharacter = new AnimationCharacter(animation);
    }

    @FXML
    public void setProgress() {
        barHealth.setProgress(character.getHealth()/character.getMaxHealth());
        barCleanliness.setProgress(character.getCleanliness());
        barHappines.setProgress(character.getHappiness());
        barHunger.setProgress(character.getHunger());
        barThirst.setProgress(character.getThirst());
    }
    @FXML
    private ImageView characterView;
    @FXML
    private Button play;
    @FXML
    private Button feed;
    @FXML
    private Button giveWater;
    @FXML
    private Button giveMedicine;
    @FXML
    private Button cleanUp;
    @FXML
    private ProgressBar barHealth;
    @FXML
    private ProgressBar barHappines;
    @FXML
    private ProgressBar barHunger;
    @FXML
    private ProgressBar barThirst;
    @FXML
    private ProgressBar barCleanliness;
    @FXML
    public ImageView animation;

    @FXML
    public void playAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.PLAY, character);
        barHappines.setProgress(character.getHappiness());

    }
    @FXML
    public void feedAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.FEED, character);
        animationCharacter.feedAnimation();
        barHunger.setProgress(character.getHunger());
    }
    @FXML
    public void cleanUpAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.CLEAN_UP, character);
        barCleanliness.setProgress(character.getCleanliness());
    }
    @FXML
    public void giveWaterAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.GIVE_WATER, character);
        animationCharacter.drinkWaterAnimation();
        barThirst.setProgress(character.getThirst());
    }
    @FXML
    public void giveMedicineAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.GIVE_MEDICINE, character);
        barHealth.setProgress(character.getHealth()/character.getMaxHealth());
    }
    public void startLiveCycle() {
        timelineScore = new Timeline();
        timelineScore.setCycleCount(Timeline.INDEFINITE);

        timelineScore.getKeyFrames().add(
                new KeyFrame(Duration.millis(3*60000), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setProgress();
                        System.out.println("pizda");
                    }
                }));
    }
}
