package simple_tcp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public server() throws Exception{
		
		@SuppressWarnings("resource")
		ServerSocket server_socket = new ServerSocket(2020);
		System.out.println("The server port is open to connect...");
		
		Socket socket = server_socket.accept();
		System.out.println("The Client "+socket.getInetAddress()+" has connected.");
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		
		int secret_number = (int)(Math.random()*10+1);
		
		String guess;
		do {
			out_socket.println("Guess a number between 1 to 10 :");
			guess = in_socket.readLine();
		} while(secret_number!=Integer.parseInt(guess));
		
		out_socket.println("You Got Itt!!");
		System.out.println("Secret number is Out...");
		
		socket.close();
		System.out.println("Socket closed!");
	}
	public static void main(String[] args) {
		try {
			new server();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

}