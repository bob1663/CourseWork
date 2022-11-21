package sample.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.coursework.database.DBHandler;
import sample.coursework.toy.Manager;

import java.io.IOException;

public class AddController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button addElement;
    @FXML
    private TextField priceField = new TextField();
    @FXML
    private TextField sizeField = new TextField();
    @FXML
    private TextField typeField = new TextField();
    @FXML
    private Label budgetField = new Label();

    @FXML
    void addElement(ActionEvent event) throws IOException {
        DBHandler dbHandler = new DBHandler();
        Manager.checkBudget(Integer.parseInt(priceField.getText()));
        if (!Manager.isBudgetCheck()) {
            openBudgetError(event);
        } else {
            budgetField.setText("Budget: " + Manager.getBudget());
            dbHandler.addToy(typeField.getText(), sizeField.getText(),
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
}