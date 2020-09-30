package world.ucode.character;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

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

    public void startLiveCycle() {
        timelineScore = new Timeline();
        timelineScore.setCycleCount(Timeline.INDEFINITE);

        timelineScore.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(cleanliness > 0 && hunger > 0 && happiness > 0 && thirst > 0) {
                            cleanliness -= 0.003;
                            health -= 0.1;
                            happiness -= 0.002;
                            thirst -= 0.001;
                            hunger -= 0.005;
                        }
                        else {
                            health -= 0.2;
                        }
                        if (health < 0)
                            System.out.println("gameOver");
                    }
                }));
    }

}
