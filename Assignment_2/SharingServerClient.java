import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXMLLoader;
import javafx.beans.property.SimpleStringProperty;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;

public class SharingServerClient extends Frame {
	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter networkOut = null;
	private BufferedReader networkIn = null;
	
	//we can read this from the user too
	public  static String SERVER_ADDRESS = "localhost";
	public  static int    SERVER_PORT = 8080;
	
	@Override
    public void start(Stage primaryStage) throws Exception{
        Parent origin = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Assignment 2");

        TableView TV1 = new TableView();

        TV1.setPrefHeight(800);
        TV1.setPrefWidth(1000);
        TV1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableView TV2 = new TableView();


        TV2.setPrefHeight(800);
        TV2.setPrefWidth(1000);
        TV2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        HBox hb2 = new HBox();													//hbox of tables
		hb2.setSpacing(3);
        hb2.getChildren().addAll(TV1, TV2);
        
        VBox vb = new VBox(0);

        HBox hb1 = new HBox();													//hbox of Buttons
        Button button1 = new Button("Download");
        Button button2 = new Button("Upload");
		button1.setOnAction((ActionEvent e) -> {
			download();
		});
		button2.setOnAction((ActionEvent e) -> {
			upload();
		});

        hb1.getChildren().addAll(button1, button2);

        vb.getChildren().addAll(hb1, hb2);
        vb.setPadding(new Insets(35, 35, 35, 35));;
        Scene table = new Scene(vb, 550, 657);
        primaryStage.setScene(table);
        primaryStage.show();
    }																			//UI


	public SharingServerClient() {
		try {
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
		} catch (UnknownHostException e) {
			System.err.println("Unknown host: "+SERVER_ADDRESS);
		} catch (IOException e) {
			System.err.println("IOEXception while connecting to server: "+SERVER_ADDRESS);
		}
		if (socket == null) {
			System.err.println("socket is null");
		}
		try {
			networkOut = new PrintWriter(socket.getOutputStream(), true);
			networkIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("IOEXception while opening a read/write connection");
		}
		
		in = new BufferedReader(new InputStreamReader(System.in));




	}
	
	// Logcin function
	protected void download() {
		String input = null;
		String message = null;
		int errorCode = 0;

		try {
			message = networkIn.readLine(); //Welcome to chat
			System.out.println(message);
			message = networkIn.readLine(); //200 Message serves is ready
			System.out.println(message);			
		} catch (IOException e) {
			System.err.println("Error reading initial greeting from socket.");
		}

		
		while(errorCode != 200) {
		    try {
				input = in.readLine();
		    } catch (IOException e) {
				e.printStackTrace();
		    }
		    if (input.equalsIgnoreCase("quit")) {
		    	return false;
		    }
			String filename = input;
			filename = UUID.randomUUID().toString()+"_"+filename;
			String webpath="/upload/";
			String filepath = getServletContext().getRealPath(webpath+filename);
			File file = new File(filepath);
			file.getParentFile().mkdirs();
			file.createNewFile();
			InputStream in = fileItem.getInputStream();
			FileOutputStream out = new FileOutputStream(file);
			byte[] bytes = new byte[1024];
			int len;
			while((len = in.read(bytes))>0){
				out.write(bytes, 0, len);
			}
			in.close();
			out.close();
			fileItem.delete();
		}
	}

	protected void download() {
		String input = null;
		String message = null;
		int errorCode = 0;

		try {
			message = networkIn.readLine(); //Welcome to chat
			System.out.println(message);
			message = networkIn.readLine(); //200 Message serves is ready
			System.out.println(message);			
		} catch (IOException e) {
			System.err.println("Error reading initial greeting from socket.");
		}

		
		while(errorCode != 200) {
		    try {
				input = in.readLine();
		    } catch (IOException e) {
				e.printStackTrace();
		    }
		    if (input.equalsIgnoreCase("quit")) {
		    	return false;
		    }
			String filename = input;
			String folder = "d:/download/";
			InputStream in = getServletContext().getResourceAsStream(folder+filename);
			OutputStream out = response.getOutputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = in.read(bytes))!=-1){
				out.write(bytes, 0, len);
			}

		}
	}
	

	public static void main(String[] args) {
		SharingServerClient client = new SharingServerClient();
		launch(args);
	}
}