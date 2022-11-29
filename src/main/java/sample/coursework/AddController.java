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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.coursework.database.DBHandler;
import sample.coursework.toy.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    private String typeAnswer;

    private String sizeAnswer;

    private Stage stage;
    private Scene scene;
    @FXML
    private Button addElement;

    @FXML
    private TextField priceField = new TextField();
    @FXML
    private ChoiceBox<String> sizeField = new ChoiceBox();
    @FXML
    private ChoiceBox<String> typeField = new ChoiceBox();

    @FXML
    private Label budgetField = new Label();

    private final String[] typeArr = {"ball","car","doll","plane"};

    private final String[] sizeArr = {"big","medium","small"};

    @FXML
    void addElement(ActionEvent event) throws IOException {
        DBHandler dbHandler = new DBHandler();
        Manager.checkBudget(Integer.parseInt(priceField.getText()));
        if (!Manager.isBudgetCheck()) {
            openBudgetError(event);
        } else {
            budgetField.setText("Budget: " + Manager.getBudget());
            dbHandler.addToy(typeAnswer, sizeAnswer,
                    Integer.parseInt(priceField.getText()));
        }
    }

    public void menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openBudgetError(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("budgetCheck.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeField.getItems().addAll(typeArr);
        typeField.setOnAction(this::getType);
        sizeField.getItems().addAll(sizeArr);
        sizeField.setOnAction(this::getSize);
        budgetField.setText("Budget: " + Manager.getBudget());
    }

    private void getType(ActionEvent actionEvent) {
        typeAnswer = typeField.getValue();
    }

    private void getSize(ActionEvent actionEvent) {
        sizeAnswer = sizeField.getValue();
    }
}

