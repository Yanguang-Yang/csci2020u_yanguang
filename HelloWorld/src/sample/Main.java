package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javax.xml.crypto.Data;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Scene scene = new Scene(new Group());
        //stage.setTitle("Table View Sample");
        //stage.setWidth(1000);
        //stage.setHeight(500);


        //final Label label = new Label("Address Book");
        //label.setFont(new Font("Arial", 20));


        TableView table = new TableView();
        table.setEditable(true);

        TableColumn c1 = new TableColumn("SID");
        TableColumn c2 = new TableColumn("Assignment");
        TableColumn c3 = new TableColumn("Midterm");
        TableColumn c4 = new TableColumn("Final Exam");
        TableColumn c5 = new TableColumn("Final Mark");
        TableColumn c6 = new TableColumn("Letter Grade");

        table.getColumns().addAll(c1, c2, c3, c4, c5, c6);

        table.getItems().addAll(c1, c2, c3, c4, c5, c6);
        //table.getItems().add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));

        VBox vbox = new VBox(table);
        //vbox.setSpacing(5);
        //vbox.setPadding(new Insets(0, 0, 0, 0));
        //vbox.getChildren().addAll(table);

        //((Group) scene.getRoot()).getChildren().addAll(vbox);

        //stage.setScene(scene);
        //stage.show();

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }
}

