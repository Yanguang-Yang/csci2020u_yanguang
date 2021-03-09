package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static double[] avgHousingPricesByYear = { 247381.0,264171.4,287715.3,294736.1,308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear = { 1121585.3,1219479.5,1246354.2,1295364.8, 1121585.3,1219479.5,1246354.2,1295364.8,};
    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    public static void main(String[] args) {
        launch(args);
    }



    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("avgHousingPricesByYear");
        series1.getData().add(new XYChart.Data("1", avgHousingPricesByYear[0]));
        series1.getData().add(new XYChart.Data("2", avgHousingPricesByYear[1]));
        series1.getData().add(new XYChart.Data("3", avgHousingPricesByYear[2]));
        series1.getData().add(new XYChart.Data("4", avgHousingPricesByYear[3]));
        series1.getData().add(new XYChart.Data("5", avgHousingPricesByYear[4]));
        series1.getData().add(new XYChart.Data("6", avgHousingPricesByYear[5]));
        series1.getData().add(new XYChart.Data("7", avgHousingPricesByYear[6]));
        series1.getData().add(new XYChart.Data("8", avgHousingPricesByYear[7]));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("avgCommercialPricesByYear");
        series2.getData().add(new XYChart.Data("1", avgCommercialPricesByYear[0]));
        series2.getData().add(new XYChart.Data("2", avgCommercialPricesByYear[1]));
        series2.getData().add(new XYChart.Data("3", avgCommercialPricesByYear[2]));
        series2.getData().add(new XYChart.Data("4", avgCommercialPricesByYear[3]));
        series2.getData().add(new XYChart.Data("5", avgCommercialPricesByYear[4]));
        series2.getData().add(new XYChart.Data("6", avgCommercialPricesByYear[5]));
        series2.getData().add(new XYChart.Data("7", avgCommercialPricesByYear[6]));
        series2.getData().add(new XYChart.Data("8", avgCommercialPricesByYear[7]));

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();

        //Scene scene = new Scene(new Group());
        //stage.setTitle("Imported Fruits");
        //stage.setWidth(500);
        // stage.setHeight(500);

        //Scene scene = new Scene(new Group());
        //stage.setTitle("Imported Fruits");
        //stage.setWidth(500);
        //stage.setHeight(500);

        //ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                        new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                        new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                        new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                        new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]));
        //final PieChart chart = new PieChart(pieChartData);
        //chart.setTitle("Imported Fruits");

        //((Group) scene.getRoot()).getChildren().add(chart);
        //stage.setScene(scene);
        //stage.show();
    }


}
