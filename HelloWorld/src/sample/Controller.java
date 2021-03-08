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
    private TableColumn tc1;
    @FXML
    private TableColumn tc2;
    @FXML
    private TableColumn tc3;


    //private TableView<StudentRecord> marks;

    @FXML
    public void initialize(){
        tc1.setCellValueFactory(new PropertyValueFactory<>("sid"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("assig"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("midt"));

        //tableView.setItems(DataSource.getAllMarks());
    }
}
