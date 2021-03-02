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

public class StudentRecord {
    private String sid;
    private String grade;
    private float assig;
    private float midt;
    private float finale;
    private double finalm = 2f;


    public StudentRecord(String sid, float assig, float midt, float finale) {
        this.sid = sid;
        this.assig = assig;
        this.midt = midt;
        this.finale = finale;
        //finalm = 0;
        //grade = "A";
    }

    public String getsid(){
        return sid;
    }

    public void setsid(String sid){
        this.sid = sid;
    }

    public float getassig(){
        return assig;
    }

    public float getmidt(){
        return midt;
    }

    public float getfinale(){
        return finale;
    }

    public double getfinalm(){
        return finalm;
    }

    public String getgrade(){
        return grade;
    }
}
