package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.function.UnaryOperator;

import static java.awt.Font.*;
import static javafx.scene.text.Font.font;

public class Main extends Application {
    private DatePicker checkInDatePicker;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 04");

//        Creating layout gridpane
        GridPane myGrid = new GridPane();
        myGrid.setAlignment(Pos.CENTER);
        myGrid.setHgap(10);
        myGrid.setVgap(10);
        myGrid.setPadding(new Insets(25, 25, 25, 25));



//        Create login UI controls
//        --- Title Welcome
        //Text sceneTitle = new Text("Welcome");
        //sceneTitle.setFont(font("Tahoma", FontWeight.NORMAL, 20));
        checkInDatePicker = new DatePicker();                               //date
// -- labels
        Label lbUserName = new Label("Username:");
        Label lbPassword = new Label("Password:");
        Label lbfullname = new Label("Full Name:");
        Label lbemail = new Label("E-mail:");
        Label lbphone = new Label("phone:");
        Label checkInlabel = new Label("Check-In Date:");

        //Label psPassword = new Label("Psss:");
// -- inputs
        TextField txUserName = new TextField();
        PasswordField psPassword = new PasswordField();
        TextField psfullname = new TextField();
        TextField psemail = new TextField();
        TextField psphone = new TextField();

        txUserName.setPromptText("Enter your username.");
        psPassword.setPromptText("Enter your password.");
        psfullname.setPromptText("Enter your fullname.");
        psemail.setPromptText("Enter your email.");
        psphone.setPromptText("Enter your phone.");
//        -- Button
        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
//        -- link
        final Text actionTarget = new Text();



//        Add the components onto the myGrid pane
        //myGrid.add(sceneTitle, 0,0,2,1);

        myGrid.add(lbUserName, 0,1);
        myGrid.add(txUserName, 1,1);

        myGrid.add(lbPassword, 0,2);
        myGrid.add(psPassword, 1,2);

        myGrid.add(lbfullname, 0,3);
        myGrid.add(psfullname, 1,3);

        myGrid.add(lbemail, 0,4);
        myGrid.add(psemail, 1,4);

        myGrid.add(lbphone, 0,5);
        myGrid.add(psphone, 1,5);

        myGrid.add(checkInlabel,0,6);
        myGrid.add(checkInDatePicker,1,6);

        myGrid.add(hbBtn, 1, 8);
        myGrid.add(actionTarget, 1, 10);

        //psphone.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
        //    @Override
        //    public TextFormatter.Change apply(TextFormatter.Change change) {
       //         String value = change.getText();
        //        if(value.contains("[0-9]{3}-[0-9]{3}-[0-9]{4}"))
        //        {
        //            return change;
        //        }
        //        return null;
        //    }
        //}));

//        Setting the btn event
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                if(txUserName.getText() != null && psfullname.getText() != null && psemail.getText() != null && psphone.getText() != null && checkInDatePicker.getValue() != null)
                {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText(psfullname.getText() + "\n" + psemail.getText() + "\n" + psphone.getText() + "\n" + checkInDatePicker.getValue());
                }
                else
                {
                    actionTarget.setText("Not finished");
                }
            }
        });


//        Creating myScene with custom layout
        Scene myScene = new Scene(myGrid, 500,700);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
