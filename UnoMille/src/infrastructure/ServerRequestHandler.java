package infrastructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// teste de commit
public class ServerRequestHandler {

	private int port;
	private ServerSocket welcomeSocket;
	private Socket connectionSocket;
	
	private int sendMessageSize;
	private int receiveMessageSize;
	private DataOutputStream outToClient;
	private DataInputStream inFromClient;
	
	public ServerRequestHandler(int port){
		this.port = port;
	}
	
	public void send (byte [] message) throws IOException, InterruptedException{
		
		this.sendMessageSize = message.length;
		this.outToClient.writeInt(this.sendMessageSize);
		this.outToClient.write(message);
		this.outToClient.flush();
		
		this.connectionSocket.close();
		this.welcomeSocket.close();
		this.outToClient.close();
		this.inFromClient.close();
		
		return;
	}
	
	public byte[] receive () throws IOException, InterruptedException{
		byte [] receiveMessage ;
		
		this.welcomeSocket = new ServerSocket(this.port);
		this.connectionSocket = this.welcomeSocket.accept();
		
		this.outToClient = new DataOutputStream(this.connectionSocket.getOutputStream());
		this.inFromClient = new DataInputStream(this.connectionSocket.getInputStream());
		
		this.receiveMessageSize = this.inFromClient.readInt();
		receiveMessage = new byte [this.receiveMessageSize];
		
		this.inFromClient.read(receiveMessage,0,this.receiveMessageSize);
		
		return receiveMessage;		
		
	}
}
