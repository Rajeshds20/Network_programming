package simple_tcp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() throws Exception{
		
		ServerSocket server_socket = new ServerSocket(2020);
		System.out.println("The server port is open to connect...");
		
		Socket socket = server_socket.accept();
		System.out.println("The Client "+socket.getInetAddress()+"has connected.");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		out_socket.println("Welcome!!");
		
		String msg = in_socket.readLine();
		
		System.out.println("Client Says :"+msg);
		
		socket.close();
		System.out.println("Socket closed!");
		server_socket.close();
	}
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

}