import java.io.*;
import java.net.*;
import java.util.*;

public class SharingServerThread extends Thread {
	protected Socket socket       = null;
	protected PrintWriter out     = null;
	protected BufferedReader in   = null;
	
	protected String strPasswords = "fileshare";
	
	protected boolean bLoggedIn   = false;
	protected String strUserID    = null;
	protected String strPassword  = null;
	
	protected Vector messages     = null;

	public SharingServerThread(Socket socket, Vector messages) {
		super();
		this.socket = socket;
		this.messages = messages;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("IOEXception while opening a read/write connection");
		}
	}

	public void run() {
		// initialize interaction
		out.println("Connected to Chat Server");	
		out.println("200 Ready For Chat");	
		
		boolean endOfSession = false;
		try {
			socket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}