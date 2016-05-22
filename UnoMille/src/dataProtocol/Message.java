package dataProtocol;

import java.io.Serializable;

public class Message implements Serializable{
	
	private MessageHeader header;
	private MessageBody body;
	
	public Message(){
		
	}
	public Message(MessageHeader header, MessageBody body) {
		
		this.header = header;
		this.body = body;
	}
	
	

}
