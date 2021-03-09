/**
 * Lab 6 Demo: Controller
 *
 * %Warning%: This is NOT an actual Lab 06 solution and should not be treated as
 * such.
 *
 * @author Michael Valdron
 * created on 2021/03/03
 */
package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3
    };

    @FXML
    private Canvas canvas;

    @FXML
    private GraphicsContext gc;

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double[] data = {1,2,3,4,5,6,7,8};
        double[] data2 = {0,1,2,3,4,5,6,7};

        drawGraph(100,300,avgHousingPricesByYear,Color.RED,0);
        drawGraph(100,300,avgCommercialPricesByYear,Color.BLUE,100/avgCommercialPricesByYear.length);

        gc.setFill(Color.INDIANRED);
        //drawPieChart(gc);
    }

    private void drawGraph(int w, int h, double[] data, Color colour,int startX) {
        gc.setFill(colour);
        double xInc = (data.length);

        double maxVal = Double.NEGATIVE_INFINITY;
        double minVal = Double.MAX_VALUE;

        for(double val: data){
            if(val > maxVal){
                maxVal = val;
            } if(val < minVal){
                minVal = val;
            }
        }
//        System.out.println(maxVal);
//        System.out.println(minVal);
        double x = startX;
        for(double val: data){
            double height = ((val-minVal) / (maxVal - minVal)) * h;
            gc.fillRect(x,(h-height),xInc,height);
            x += 2 * xInc;
        }
    }
}
