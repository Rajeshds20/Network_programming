package simple_tcp_multi_singlenum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
	@SuppressWarnings("resource")
	public client() throws Exception {
		
		Socket socket = new Socket("localhost",2020);
		System.out.println("The Connection was successfully connected...");
		
		Scanner inp = new Scanner(System.in);
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		String message;
		String user;
		String user_number;
		
		message = in_socket.readLine();
		System.out.println("Server: " + message);
		user = inp.nextLine();
		out_socket.println(user);
		
		String winning_message = "User " + user;
		
		while(true) {
			message = in_socket.readLine();
			
			if(message.startsWith("Guess")) {
				System.out.println("Server: Guess a number [1-20]: ");
				user_number = inp.nextLine();
				out_socket.println(user_number);
			}
			else if (message.startsWith(winning_message)) {
				System.out.println("You got it!!!");
				socket.close();
				System.out.println("Socket closed.");
				break;
			}
			else {
				System.out.println(message);
				socket.close();
				System.out.println("Socket closed.");
				break;
			}
		}
	}
		
	public static void main(String[] args) {
		try {
			new client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}