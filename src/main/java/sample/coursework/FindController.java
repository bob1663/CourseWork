package sample.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.coursework.database.DBHandler;
import sample.coursework.toy.Toy;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FindController implements Initializable {
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
    private ChoiceBox<String> sizeField;
    @FXML
    private Button typeButton;
    @FXML
    private ChoiceBox<String> typeField;

    @FXML
    void find(ActionEvent event) {

    }
    private String typeAnswer;

    private String sizeAnswer;

    private final String[] typeArr = {"ball","car","doll","plane"};

    private final String[] sizeArr = {"big","medium","small"};

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
        String size = sizeAnswer;
        List<Toy> temp = DBHandler.findToysBySize(size);
        for (Toy i : temp) {
            found.add(i);
        }
        openFindWindow(event);
    }

    @FXML
    void type(ActionEvent event) throws IOException {
        String type = typeAnswer;
        List<Toy> temp = DBHandler.findToysByType(type);
        for (Toy i : temp) {
            found.add(i);
        }
        openFindWindow(event);
    }

    public void openFindWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("foundElements.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static List<Toy> getFound() {
        return found;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeField.getItems().addAll(typeArr);
        typeField.setOnAction(this::getType);
        sizeField.getItems().addAll(sizeArr);
        sizeField.setOnAction(this::getSize);
    }

    private void getType(ActionEvent actionEvent) {
        typeAnswer = typeField.getValue();
    }

    private void getSize(ActionEvent actionEvent) {
        sizeAnswer = sizeField.getValue();
    }
}