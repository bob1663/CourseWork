package sample.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.coursework.database.DBHandler;
import sample.coursework.toy.Toy;

import java.io.IOException;
import java.util.List;

public class SortController {

    @FXML
    private TextArea infoField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button menuButton;

    @FXML
    private Button sortButton;

    @FXML
    void menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sort(ActionEvent event) {
        List<Toy> temp = DBHandler.sortToys();
        StringBuilder sb = new StringBuilder();
        for (Toy e : temp) {
            sb.append(e.getInfo() + "\n");
        }
        infoField.setText(sb.toString());
    }
}


