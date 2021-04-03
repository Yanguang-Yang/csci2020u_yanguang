import java.io.*;
import java.net.*;
import java.util.Vector;

public class SharingServer {
	protected Socket clientSocket           = null;
	protected ServerSocket serverSocket     = null;
	protected SharingServerThread[] threads    = null;
	protected int numClients                = 0;
	protected Vector messages               = new Vector();

	public static int SERVER_PORT = 8080;
	public static int MAX_CLIENTS = 25;

	public SharingServer() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("---------------------------");
			System.out.println("Sharing Server Application is running");
			System.out.println("---------------------------");
			System.out.println("Listening to port: "+SERVER_PORT);
			threads = new SharingServerThread[MAX_CLIENTS];
			while(true) {
				clientSocket = serverSocket.accept();
				System.out.println("Client #"+(numClients+1)+" connected.");
				threads[numClients] = new SharingServerThread(clientSocket, messages);
				threads[numClients].start();
				numClients++;
			}
		} catch (IOException e) {
			System.err.println("IOException while creating server connection");
		}
	}

	public static void main(String[] args) {
		SharingServer app = new SharingServer();
	}
}