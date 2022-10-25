package simple_udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class reciever {

	public reciever() throws Exception{
		
		@SuppressWarnings("resource")
		DatagramSocket socket = new DatagramSocket(2020);
		System.out.println("Receiver is running.");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		while(true) {
		
			byte[] buffer = new byte[1500]; // MTU = 1500
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			socket.receive(packet); // Retrieving sender's message

			String message = new String(buffer).trim();
			System.out.println("Received: " + message);

			InetAddress senders_address = packet.getAddress();
			int senders_port = packet.getPort();
			
			System.out.println("Enter the message :");
			message = scan.nextLine();
			buffer = message.getBytes();
			packet = new DatagramPacket(buffer, buffer.length, senders_address, senders_port);
			socket.send(packet);

			System.out.println("Sent: " + message);
			
		}
	}
	
	public static void main(String[] args) {
		try {
			new reciever();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
