package simple_tcp_multi_singlenum;

import java.net.ServerSocket;
import java.net.Socket;

public class serverMain {
	
	@SuppressWarnings("resource")
	public serverMain() throws Exception {
		
		ServerSocket server_socket = new ServerSocket(2020);
		System.out.println("Port 2020 is open now...");
		
		while(true){
			
			Socket socket = server_socket.accept();
			serverThread server_thread = new serverThread(socket,this);
			Thread thread = new Thread(server_thread);
			thread.start();
			
		}
	}
	
	private int secret_number = (int)(Math.random()*20+1);
	public int client_num = 1;
	private String user;
	private boolean guessed = false;
	
	public void setguessed() {
		guessed = true;
	}
	
	public boolean getguessed() {
		return guessed;
	}
	
	public int getsecret_number() {
		return secret_number;
	}
	
	public int getclientnum() {
		return client_num++;
	}
	
	public void setwhoguessedit(String user) {
		this.user = user;
	}
	
	public String getwhoguessedit() {
		return user;
	}
	
	public static void main(String[] args) {
		
		try {
			new serverMain();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
