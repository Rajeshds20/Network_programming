package simple_tcp_reverse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class serverThread implements Runnable{
	
	private Socket socket;
	private int client_num;
	public serverThread(Socket socket,serverMain server_main) {
		this.socket = socket;
		this.client_num = server_main.getclientnum();
	}
	
	@Override
	public void run() {
		try {
			
			
			System.out.println("New Client "+client_num+" has connected..");
			
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			String msg;
			
			do {
				msg = in_socket.readLine();
				StringBuilder sb = new StringBuilder();
				sb.append(msg);
				sb.reverse();
				out_socket.println(sb);
			} while(!(msg.equalsIgnoreCase("EXIT")));
			
			socket.close();
			System.out.println("Client "+client_num+" disconnected");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
