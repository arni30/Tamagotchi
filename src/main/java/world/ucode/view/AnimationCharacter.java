package world.ucode.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.model.CharacterType;

import java.util.HashMap;
import java.util.Map;

public class AnimationCharacter {
    final private Map<CharacterType, Image> characterType = new HashMap<>();
    private ImageView animation;
    private Timeline timeline;
    private CharacterType type;
    public AnimationCharacter(ImageView animationView, CharacterType type) {
        this.animation = animationView;
        this.type = type;
        timeline = new Timeline(new KeyFrame(Duration.millis(4000), actionEvent -> animation.setVisible(false)));
    }
    private void fillAnimationMap(String action) {
        characterType.put(CharacterType.SPONGEBOB,
                new Image("/SpongeBob/" + action + "Spongebob.gif", 600, 410, false, false));
        characterType.put(CharacterType.PATRICK,
                new Image("/Patrick/" + action + "Patrick.gif", 600, 410, false, false));
        characterType.put(CharacterType.SQUIDWARD,
                new Image("/Squidward/" + action +"Squidward.gif",600, 410, false, false));
    }
    public void playAnimation(String action) {
        fillAnimationMap(action);
        startAnimation();
    }
    private void startAnimation() {
        animation.setImage(characterType.get(type));
        animation.setVisible(true);
        timeline.play();
    }

}
