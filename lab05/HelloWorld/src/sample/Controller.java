package sample;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javax.xml.crypto.Data;

public class Controller {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn sid;
    @FXML
    private TableColumn assig;
    @FXML
    private TableColumn midt;
    @FXML
    private TableColumn finale;
    @FXML
    private TableColumn finalm;
    @FXML
    private TableColumn grade;

    private TableView<StudentRecord> marks;

    @FXML
    public void initialize(){
        sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        assig.setCellValueFactory(new PropertyValueFactory<>("assig"));
        midt.setCellValueFactory(new PropertyValueFactory<>("midt"));
        finale.setCellValueFactory(new PropertyValueFactory<>("finale"));
        finalm.setCellValueFactory(new PropertyValueFactory<>("finalm"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.setItems(DataSource.getAllMarks());
    }
}
