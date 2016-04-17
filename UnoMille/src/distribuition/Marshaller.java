package distribuition;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Message;

public class Marshaller {

	public byte [] marshall (Message msgToBeMarshelled) throws IOException, InterruptedException{
		
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
		objectStream.writeObject(msgToBeMarshelled);
		
		return byteStream.toByteArray();
		
	}
	
	public Message unmarshall (byte [] messageToBeUnmarshalled) throws IOException, InterruptedException, 
	ClassNotFoundException{
		
		ByteArrayInputStream byteStream = new ByteArrayInputStream(messageToBeUnmarshalled);
		ObjectInputStream objectStream = new ObjectInputStream(byteStream);
		
		return (Message) objectStream.readObject();
	}
	
}
