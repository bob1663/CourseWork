package sample.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.coursework.database.DBHandler;
import sample.coursework.toy.Toy;

import java.io.IOException;
import java.util.List;

public class ShowController {

    private Stage stage;
    private Scene scene;

    private Parent root;

    @FXML
    static private Label actionLabel;

    @FXML
    private TextArea infoField;

    @FXML
    private Button menuButton;

    @FXML
    private Button showButton;

    @FXML
    void menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void show(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        List<Toy> list = DBHandler.getToys();
        for (Toy e : list) {
            sb.append(e.getInfo() + "\n");
        }
        infoField.setText(sb.toString());
    }

}
