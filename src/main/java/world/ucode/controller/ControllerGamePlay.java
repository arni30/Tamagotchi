package world.ucode.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import world.ucode.charaacter.Character;
import world.ucode.charaacter.CharacterAction;

import java.lang.reflect.InvocationTargetException;

public class ControllerGamePlay {
    final private Character character;
    public ControllerGamePlay(Character character) {
        this.character = character;
    }
    @FXML
    public void setProgress() {
        barHealth.setProgress(0.0);
    }
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
    public void playAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.PLAY, character);
        setProgress();
    }
    @FXML
    public void feedAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.FEED, character);
    }
    @FXML
    public void cleanUpAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.CLEAN_UP, character);
    }
    @FXML
    public void giveWaterAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.GIVE_WATER, character);
    }
    @FXML
    public void giveMedicineAction() throws InvocationTargetException, IllegalAccessException {
        character.ActionHandler(CharacterAction.GIVE_MEDICINE, character);
    }


}
