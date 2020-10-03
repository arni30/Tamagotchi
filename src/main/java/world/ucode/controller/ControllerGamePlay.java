package world.ucode.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import world.ucode.Tamagotchi;
import world.ucode.animation.AnimationCharacter;
import world.ucode.character.Character;
import world.ucode.character.CharacterAction;
import world.ucode.character.CharacterType;
import world.ucode.scenes.MainMenuScene;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGamePlay extends Controller  {
    public Timeline timelineScore;
    public AnimationCharacter animationCharacter;
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
    private Button back;

    @FXML
    public ImageView animation;

    final private Character character;
    public ControllerGamePlay(Character character, Stage primaryStage) {
        super(primaryStage);
        this.character = character;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //setProgress();
        startLiveCycle();
        timelineScore.play();
        if (this.character.getType() == CharacterType.SPONGEBOB) {
            characterView.setImage(new Image("/SpongeBob/spongebobStatic.png"));
        }
        else if (this.character.getType() == CharacterType.PATRICK)
            characterView.setImage(new Image("/Patrick/patrickStatic.png"));
        else if (this.character.getType() == CharacterType.SQUIDWARD)
            characterView.setImage(new Image("/Squidward/squidwardStatic.png"));
        animationCharacter = new AnimationCharacter(animation, character.getType());
        super.initialize(url, resourceBundle);
        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::exitApplication);
    }

    @FXML
    public void exitApplication(WindowEvent event) {
        fillDB();
    }

    private void fillDB() {
        Tamagotchi.db.insert(character.getName(), character.getType().toString(), character.getHealth(), character.getHunger(),
                character.getThirst(), character.getCleanliness(), character.getHappiness());
    }

    @Override
    public void buttonsSetStyle() {
        buttonSetStyleHover(play);
        buttonSetStyleHover(feed);
        buttonSetStyleHover(giveMedicine);
        buttonSetStyleHover(giveWater);
        buttonSetStyleHover(cleanUp);
        buttonSetStyleHover(back);
    }

    @FXML
    public void setProgress() {
        barHealth.setProgress(character.getHealth());
        barCleanliness.setProgress(character.getCleanliness());
        barHappines.setProgress(character.getHappiness());
        barHunger.setProgress(character.getHunger());
        barThirst.setProgress(character.getThirst());
    }
    private void callAnimation(CharacterAction action, double progress, String img) throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(action, character);
        animationCharacter.playAnimation(img);
        barHappines.setProgress(progress);
    }
    @FXML
    public void playAction() throws InvocationTargetException, IllegalAccessException {
        callAnimation(CharacterAction.PLAY, character.getHappiness(), "playing");
    }

    @FXML
    public void feedAction() throws InvocationTargetException, IllegalAccessException {
        callAnimation(CharacterAction.FEED, character.getHunger(), "eating");
    }

    @FXML
    public void cleanUpAction() throws InvocationTargetException, IllegalAccessException {
        callAnimation(CharacterAction.CLEAN_UP, character.getCleanliness(), "cleaning");
    }

    @FXML
    public void giveWaterAction() throws InvocationTargetException, IllegalAccessException {
        callAnimation(CharacterAction.GIVE_WATER, character.getThirst(), "drinking");
    }

    @FXML
    public void giveMedicineAction() throws InvocationTargetException, IllegalAccessException {
        callAnimation(CharacterAction.GIVE_MEDICINE, character.getHealth()/character.getMaxHealth(), "eatingPillow");
    }

    public void startLiveCycle() {
        timelineScore = new Timeline();
        timelineScore.setCycleCount(Timeline.INDEFINITE);

        timelineScore.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setProgress();
                    }
                }));
    }

    @FXML
    public void mainMenu() throws IOException {
        fillDB();
        timelineScore.stop();
        MainMenuScene mainMenuScene = new MainMenuScene("/Tamagotchi.fxml", new ControllerMainMenu(primaryStage), primaryStage);
        mainMenuScene.setScene();
    }
}
