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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javax.xml.crypto.Data;
import java.io.File;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button asgm = new Button("Assignment");
        //Scene scene = new Scene(asgm);

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("D:\\Chrome\\WordCounter"));
        File mainDirectory = directoryChooser.showDialog(stage);

        File[] listfile = mainDirectory.listFiles();

        TableView table = new TableView();
        table.setEditable(true);

        TableColumn tc1 = new TableColumn("File");
        TableColumn tc2 = new TableColumn("Actual Class");
        TableColumn tc3 = new TableColumn("Spam Probability");

        table.getColumns().addAll(tc1, tc2, tc3);

        //table.getItems().add(new TestFile("dsafdsa", 32.23, "fdsa"));

        VBox vbox = new VBox(table);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.show();
    }
}

