package world.ucode.animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimationCharacter {
    private ImageView animation;
    private Timeline timeline;
    public AnimationCharacter(ImageView animationView) {
        animation = animationView;
        timeline = new Timeline(new KeyFrame(Duration.millis(6000), actionEvent -> animation.setVisible(false)));
    }

    public void playAnimation() {
    }
    public void feedAnimation() {
        animation.setImage(new Image("/eatingSpongebob.gif"));
        animation.setVisible(true);
        timeline.play();

    }
    public void cleanAnimation() {
        timeline.play();
    }
    public void eatPillowAnimation() {
        timeline.play();
    }
    public void drinkWaterAnimation() {
        animation.setImage(new Image("/drinkingSpongebob.gif"));
        animation.setVisible(true);
        timeline.play();
    }

}
