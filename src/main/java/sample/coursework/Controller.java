package sample.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.coursework.toy.Manager;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;

    private Parent root;
    @FXML
    private Button makeButton;

    @FXML
    void make(ActionEvent event) throws IOException {
        Manager.setBudget(100);
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
