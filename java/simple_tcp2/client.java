package simple_tcp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
	public client() throws Exception {
		
		Socket socket = new Socket("localhost",2020);
		System.out.println("The Connection was successfully connected...");
		
		Scanner inp = new Scanner(System.in);
		
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		String msg;
		
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.println("Guess a number in between  to 10 :");
			msg = inp.nextLine();
			out_socket.println(msg);
		}
		
		System.out.println("You Gott Itt!!");
		
		
		socket.close();
		System.out.println("Socket Connection Closed");
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