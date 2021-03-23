package midterm2021;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.*;
import javafx.scene.text.Text
;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;

public class Main extends Application {
    private Canvas canvas;
    private double screenWidth = 800;
    private double screenHeight = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("CSCI2020U - Midterm");



        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


//      Creating the menu buttons
        Button btApp1 = new Button("Animation");
        btApp1.setPrefWidth(200);
        Button btApp2 = new Button("2D Graphics");
        btApp2.setPrefWidth(200);
        Button btApp3 = new Button("About");
        btApp3.setPrefWidth(200);

        grid.add(btApp1, 0,1);
        grid.add(btApp2, 0,2);
        grid.add(btApp3, 0,3);

        // main App Scene
        Scene mainScene = new Scene(grid, 300, 275);

        primaryStage.setScene(mainScene);
        primaryStage.show();


//        setting the Event handlers for each buttonsroot
        btApp1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                      Display the "Animation" in the CENTER,
//                      and a "Back to Main" on the TOP
                Group root = new Group();
                Scene scene1 = new Scene(root, 130, 130);
                canvas = new Canvas();
                canvas.widthProperty().bind(primaryStage.widthProperty());
                canvas.heightProperty().bind(primaryStage.heightProperty());
                root.getChildren().add(canvas);

                Hyperlink link = new Hyperlink("Back to Main");
                link.setOnAction((ActionEvent e) -> {
                    primaryStage.setScene(mainScene);
                    primaryStage.show();
                        });
                root.getChildren().addAll(link);

                primaryStage.setScene(scene1);
                primaryStage.show();
                drawAnimation(root);



                 System.out.println("Clicked on Animation button");
            }
        });

        btApp2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                    Display the "2D Drawing" in the CENTER,
//                    and a "Back to Main" on the TOP
                Group root = new Group();
                Scene scene2 = new Scene(root, 300, 250);
                canvas = new Canvas();
                canvas.widthProperty().bind(primaryStage.widthProperty());
                canvas.heightProperty().bind(primaryStage.heightProperty());
                root.getChildren().add(canvas);

                Hyperlink link = new Hyperlink("Back to Main");
                link.setOnAction((ActionEvent e) -> {
                    primaryStage.setScene(mainScene);
                    primaryStage.show();
                });
                root.getChildren().addAll(link);

                primaryStage.setScene(scene2);
                primaryStage.show();
                draw(root);
                System.out.println("Clicked on Graphics 2D button");
            }
        });

        btApp3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                TODO: Replace the scene or the root
//                    Display the "About" in the CENTER,
//                    and a "Back to Main" on the TOP
                GridPane grid2 = new GridPane();
                grid2.setAlignment(Pos.CENTER);
                grid2.setHgap(0);
                grid2.setVgap(0);

                Hyperlink link = new Hyperlink("Back to Main");
                link.setOnAction((ActionEvent e) -> {
                    primaryStage.setScene(mainScene);
                    primaryStage.show();
                });
                grid2.add(link, 0, 0);

                Element element = null;
                File f = new File("./resources/info.xml");
                DocumentBuilder db = null;
                DocumentBuilderFactory dbf = null;
                try{
                    dbf = DocumentBuilderFactory.newInstance();
                    db = dbf.newDocumentBuilder();
                    Document dt = db.parse(f);
                    element = dt.getDocumentElement();
                    //System.out.println(element.getNodeName());
                    NodeList childNodes = element.getChildNodes();
                    Node node1 = childNodes.item(1);
                    Node node2 = childNodes.item(3);

                    Text t = new Text();
                    t.setText("id:" + node1.getAttributes().getNamedItem("id").getNodeValue());
                    grid2.add(t, 0, 1);
                    NodeList nodeDetail = node1.getChildNodes();
                    for (int i = 0; i < nodeDetail.getLength(); i++){
                        Node detail = nodeDetail.item(i);
                        if ("name".equals(detail.getNodeName())) {
                            Text t1 = new Text();
                            t1.setText("name: " + detail.getTextContent());
                            grid2.add(t1, 0, 2);
                        }
                        else if ("email".equals(detail.getNodeName())) {
                            Text t2 = new Text();
                            t2.setText("email: " + detail.getTextContent());
                            grid2.add(t2, 0, 3);
                        }
                    }
                    //Node node2 = childNodes.item(2);
                    //System.out.println(node2.getNodeName());
                    Text t3 = new Text();
                    t3.setText("Software description: " + node2.getTextContent());
                    grid2.add(t3, 0, 4);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("Clicked on About button");


                Scene Scene3 = new Scene(grid2, 300, 275);

                primaryStage.setScene(Scene3);
                primaryStage.show();
            }
        });
    }

    private int frameWidth = 32;
    private int frameHeight = 36;
    private int numFrameswidth = 3;
    private int numFramesheight = 8;
    private int sourceHeightOffset = 0;
    private int sourceWidthOffset = 0;
    private int frameIndexwidth = 0;
//    private int frameIndexheight = 0;
    private int widthIndex = 0;
    private int heightIndex = 0;

    private void drawAnimation(Group root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
//loading image sprite using relative path
        Image image = new Image(getClass().getClassLoader().getResource("ducks.png").toString());

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1333.3333), new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent actionEvent) {
//                background rect fpr the characters
                gc.setFill(Color.BLACK);
                gc.fillRect(50, 50, frameWidth, frameHeight);


                widthIndex = 9 + frameIndexwidth;
//                calculating the offset height based on the frameIndex
                sourceWidthOffset = frameWidth*widthIndex;

                gc.drawImage(image, sourceWidthOffset, sourceHeightOffset, frameWidth, frameHeight, 50, 50, frameWidth, frameHeight);
//                we want to vary frameIndex from 9 to 11 (not included) using the %
                frameIndexwidth = (frameIndexwidth+1) % numFrameswidth;
//                we want to vary frameIndex from 0 to 2 (not included) using the %
                if(frameIndexwidth == 0){
                    heightIndex = (heightIndex + 1) % numFramesheight;
                }
//                calculating the offset height based on the frameIndex
                sourceHeightOffset = frameHeight*heightIndex;

            }
        }));

//      Starting the timeline
        timeline.playFromStart();



    }

    private void draw(Group root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        Drawing 3 lines(Y)
        gc.setStroke(Color.RED);
        gc.strokeLine(100,100,60,60);

        gc.setStroke(Color.GREEN);
        gc.strokeLine(100,100,140,60);

        gc.setStroke(Color.BLUE);
        gc.strokeLine(100,100,100,170);

//        Drawing 3 lines(Y)
        gc.setStroke(Color.RED);
        gc.strokeLine(200,100,160,60);

        gc.setStroke(Color.GREEN);
        gc.strokeLine(200,100,240,60);

        gc.setStroke(Color.BLUE);
        gc.strokeLine(200,100,200,170);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
