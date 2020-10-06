package world.ucode.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import world.ucode.controller.ControllerGamePlay;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Character {
    final private String name;
    final private CharacterType type;
    final private int maxHealth;
    private double health;
    private double happiness;
    private double hunger;
    private double thirst;
    private double cleanliness;
    public Timeline timelineScore;
    private final Map<CharacterAction, Method> actions = new HashMap<CharacterAction, Method>() {{
        try {
            put(CharacterAction.PLAY, Character.class.getDeclaredMethod("play"));
            put(CharacterAction.FEED, Character.class.getDeclaredMethod("feed"));
            put(CharacterAction.GIVE_WATER, Character.class.getDeclaredMethod("giveWater"));
            put(CharacterAction.GIVE_MEDICINE, Character.class.getDeclaredMethod("giveMedicine"));
            put(CharacterAction.CLEAN_UP, Character.class.getDeclaredMethod("cleanUp"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }};
    public Character(String characterName, CharacterType characterType) {
        name = characterName;
        type = characterType;
        maxHealth = 100;
        health = maxHealth;
        happiness = 1;
        hunger = 1;
        thirst = 1;
        cleanliness = 1;
    }
    public Character(String characterName, CharacterType characterType,
                     double health, double happiness, double hunger, double thirst, double cleanliness) {
        name = characterName;
        type = characterType;
        maxHealth = 100;
        this.health = health;
        this.happiness = happiness;
        this.hunger = hunger;
        this.thirst = thirst;
        this.cleanliness = cleanliness;
    }
    public void ActionHandler(CharacterAction action, Character character) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(character);
    }
    public void play() {
        if (happiness < 1)
            happiness += 0.05;
    }
    private void feed() {
        if (hunger < 1)
            hunger+= 0.05;
    }
    private void giveWater() {
        if (thirst < 1)
            thirst += 0.05;
    }
    private void giveMedicine() {
        if (health < 100)
            health += 5;
        if (health > 100)
            health = 100;
    }
    private void cleanUp() {
        if (cleanliness < 10)
            cleanliness++;
    }

    public double getHealth() {
        return health;
    }
    public double getHappiness() {
        return happiness;
    }
    public double getHunger() {
        return hunger;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public double getThirst() {
        return thirst;
    }
    public double getCleanliness() {
        return cleanliness;
    }
    public CharacterType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }
    public void setHunger(double hunger) {
        this.hunger = hunger;
    }
    public void setThirst(double thirst) {
        this.thirst = thirst;
    }
    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void startLiveCycle() {
        timelineScore = new Timeline();
        timelineScore.setCycleCount(Timeline.INDEFINITE);

        timelineScore.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (hunger > 0.1 || happiness > 0.1
                                || cleanliness > 0.1 || thirst > 0.1){
                            health -= 0.1;
                            if (hunger > 0.1)
                                hunger -= 0.005;
                            if (happiness > 0.1)
                                happiness -= 0.002;
                            if (cleanliness > 0.1)
                                cleanliness -= 0.003;
                            if (thirst > 0.1)
                                thirst -= 0.002;
                        }
                        else {
                            health -= 0.5;
                        }
                        if (health < 0) {
                            try {
                                timelineScore.stop();
                                ControllerGamePlay.setGameOverScene();
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }));
    }

}
