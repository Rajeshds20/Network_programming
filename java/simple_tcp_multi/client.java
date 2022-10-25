package simple_tcp_multi;

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
		
		String msg = in_socket.readLine();
		System.out.println("Server says : "+msg);
		
		msg = inp.nextLine();
		out_socket.println(msg);
		
		socket.close();
		System.out.println("Socket Connection Closed");
		inp.close();
		
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