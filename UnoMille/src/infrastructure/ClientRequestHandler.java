package infrastructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRequestHandler {
	

	private String host;
	private int port;
	private int sendMessageSize;
	private int receiveMenssageSize;
	
	private Socket clientSocket = null;
	private DataOutputStream outToServer = null;
	private DataInputStream inFromServer = null;
	
	public ClientRequestHandler(String host, int port){
		
		this.port = port;
		this.host = host;		
	}
	
	public void send(byte[]message)throws IOException, InterruptedException, 
	ClassNotFoundException{
	
		this.clientSocket = new Socket(this.host, this.port);
		this.outToServer = new DataOutputStream(this.clientSocket.getOutputStream());
		this.inFromServer = new DataInputStream(this.clientSocket.getInputStream());
		
		this.sendMessageSize = message.length;
		this.outToServer.writeInt(this.sendMessageSize);
		this.outToServer.write(message,0,this.sendMessageSize);
		this.outToServer.flush();
	}
	
	public byte [] receive() throws IOException, InterruptedException{
		byte [] message = null;
		this.receiveMenssageSize = this.inFromServer.readInt();
		message = new byte[this.receiveMenssageSize];
		this.inFromServer.read(message,0,this.receiveMenssageSize);
		
		this.clientSocket.close();
		this.outToServer.close();
		this.inFromServer.close();
		
		return message;
	}
	
	
}
