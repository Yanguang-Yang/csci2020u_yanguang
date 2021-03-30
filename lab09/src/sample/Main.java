package sample;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Main{

    public static void main(String[] args) {
        try{
            String sURL = "https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
            URL netURL = new URL(sURL);

            URLConnection conn = netURL.openConnection();
            conn.setDoOutput(false);
            conn.setDoInput(true);

            InputStream inStream = conn.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

            System.out.println(reader.readLine());
            String csvData = " ";
            String[] rows = csvData.split("\n");
            for (int i = 0; i < rows.length; i++) {
                String[] cells = rows.split();
            }

            inStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private static int height = 50;
    private static int width = 50;

    public static void drawLinePlot(Graphics graphics, double[] list1, double[] list2){

        Graphics2D graph = (Graphics2D) graphics;

        graph.draw(new Line2D.Double(50, height - 50, width-50, height-50));

        graph.draw(new Line2D.Double(50, height - 50, 50, 50));

    }

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawPieChart(gc);
    }

}