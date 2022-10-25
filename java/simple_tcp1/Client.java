package simple_tcp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public Client() throws Exception {
		
		Socket socket = new Socket("localhost",2020);
		System.out.println("The Connection was successfully connected...");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		String msg = in_socket.readLine();
		
		out_socket.println("Hello!!!");
		
		System.out.println("Server says :"+msg);
		
		
		socket.close();
		System.out.println("Socket Connection Closed");
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
