package world.ucode;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ButtonControler {

    @FXML
    // The reference of inputText will be injected by the FXML loader
    private Button newGame;
    @FXML
    public void sayHallo(ActionEvent event) {
        System.out.println("HALLO");
    }

}
