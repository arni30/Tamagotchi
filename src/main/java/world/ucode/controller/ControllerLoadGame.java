package world.ucode.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import world.ucode.Tamagotchi;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerLoadGame extends Controller {
    @FXML
    private ListView<String> gameList;

    public ControllerLoadGame(Stage stage) {
        super(stage);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        ResultSet rs = Tamagotchi.db.selectAll();
        try {
            while (rs.next()) {
                gameList.getItems().addAll(rs.getString("type") + " " + rs.getString("name"));
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



}
