package world.ucode.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerNewGame extends Controller {
    private int counter;
    @FXML
    private ImageView petImgView;
    ArrayList <Image> imgArr;
    public ControllerNewGame(Stage stage) {
        super(stage);
        imgArr = new ArrayList<Image>();
        imgArr.add(new Image(""));
        imgArr.add(new Image(""));
        imgArr.add(new Image(""));
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
        System.out.println("hallo");
        if (counter == -1)
            counter = 2;
        petImgView.setImage(imgArr.get(counter));
    }
}
