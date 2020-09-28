package world.ucode.charaacter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Character {
    final private String name;
    final private CharacterType type;
    final private int maxHealth;
    private int health;
    private int happiness;
    private int hunger;
    private int thirst;
    private int cleanliness;
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
        name = characterType + " " + characterName;
        type = characterType;
        maxHealth = 100;
        health = maxHealth;
        happiness = 10;
        hunger = 10;
        thirst = 10;
        cleanliness = 10;
    }
    public void ActionHandler(CharacterAction action, Character character) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(character);
    }
    public void play() {
        if (happiness < 10)
            happiness++;
    }
    private void feed() {
        if (hunger < 10)
            hunger++;
    }
    private void giveWater() {
        if (thirst < 10)
            thirst++;
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

    public int getHealth() {
        return health;
    }
    public int getHappiness() {
        return happiness;
    }
    public int getHunger() {
        return hunger;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getThirst() {
        return thirst;
    }
    public int getCleanliness() {
        return cleanliness;
    }

}
