package simple_tcp_multi_singlenum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class serverThread implements Runnable{
	
	private Socket socket;
	private serverMain server_main;
	public serverThread(Socket socket,serverMain server_main) {
		this.socket = socket;
		this.server_main = server_main;
	}
	
	@Override
	public void run() {
		try {
			
			int client_num = server_main.getclientnum();
			System.out.println("New Client "+client_num+" has connected..");
			
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			int secret_number = server_main.getsecret_number();
			
			out_socket.println("Welcome your number is "+client_num+", Enter your Name :");
			String user = in_socket.readLine();
			String message;
			
			while(true) {
				out_socket.println("Guess a number [1-20]: ");
				message = in_socket.readLine();
				
				if((Integer.parseInt(message)==secret_number)&&(!server_main.getguessed())) {
					server_main.getguessed();
					server_main.setwhoguessedit(user); 
					out_socket.println("User " + server_main.getwhoguessedit() + " has guessed the number!");
					System.out.println("User \" + server_main.getWhoGuessedIt() + \" has guessed the number!"); 
					socket.close();
					System.out.println("Client " + client_num + ". has disconnected.");
					break;
				}
				else if ((Integer.parseInt(message)==secret_number)&&(server_main.getguessed())) {
					out_socket.println("User " + server_main.getwhoguessedit() + " has already guessed the number!");
					socket.close();
					System.out.println("Client " + client_num + ". has disconnected.");
					break;
				}
				else if (server_main.getguessed()) {
					out_socket.println("User " + server_main.getwhoguessedit() + " has already guessed the number!");
					socket.close();
					System.out.println("Client " + client_num + ". has disconnected.");
					break;
				}
			}
			
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
