package sample.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.coursework.database.DBHandler;
import sample.coursework.toy.Toy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindController {
    static List<Toy> found = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button findButton;
    @FXML
    private Button menuButton;
    @FXML
    private Button priceButton;
    @FXML
    private TextField priceField;
    @FXML
    private Button sizeButton;
    @FXML
    private TextField sizeField;
    @FXML
    private Button typeButton;
    @FXML
    private TextField typeField;

    @FXML
    void find(ActionEvent event) {

    }

    @FXML
    void menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void price(ActionEvent event) throws IOException {
        int price = Integer.parseInt(priceField.getText());
        List<Toy> temp = DBHandler.findToysByPrice(price);
        for (Toy i : temp) {
            found.add(i);
        }
        openFindWindow(event);
    }

    @FXML
    void size(ActionEvent event) throws IOException {
        String size = sizeField.getText();
        List<Toy> temp = DBHandler.findToysBySize(size);
        for (Toy i : temp) {
            found.add(i);
        }
        openFindWindow(event);
    }

    @FXML
    void type(ActionEvent event) throws IOException {
        String type = typeField.getText();
        List<Toy> temp = DBHandler.findToysByType(type);
        for (Toy i : temp) {
            found.add(i);
        }
        openFindWindow(event);
    }

    public void openFindWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("findedElements.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static List<Toy> getFound() {
        return found;
    }
}