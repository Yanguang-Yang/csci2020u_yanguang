package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 06");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    try {
        //(文件完整路径),编码格式
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Coli\\Desktop\\csv文件.csv"), "utf-8"));

        String line = null;
        while((line=reader.readLine())!=null){
            String item[] = line.split(",");
            String last = item[item.length-1];
            System.out.println(last);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }


    public static void main(String[] args) {
        launch(args);
    }
}