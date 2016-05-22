package distribuition;

import java.io.IOException;
import java.net.UnknownHostException;

import apoio.Invocation;
import apoio.Termination;
import dataProtocol.MessageBody;
import dataProtocol.Message;
import dataProtocol.MessageHeader;
import dataProtocol.RequestBody;
import dataProtocol.RequestHeader;
import infrastructure.ClientRequestHandler;

public class Requestor {

	public Termination invoke (Invocation inv) throws UnknownHostException, IOException, Throwable{
		Termination termination= new Termination();
		// tem que ver essa classe invocation e termination direito. Elas tem coisas demais
		ClientRequestHandler clientRequestHandler = 
				new ClientRequestHandler(inv.getIPAdress(), inv.getPortNumber());
		Marshaller marshaller = new Marshaller();
		
		byte [] messageMarshelled;
		byte [] messageToBeUnmarshelled;
		Message messageUnmarshalled = new Message();
		
		
		//map
		RequestHeader requestHeader = new RequestHeader("", 0, true, 0, inv.getOperationName());
		RequestBody requestBody = new RequestBody(inv.getParameters());
		MessageHeader messageHeader = new MessageHeader("contexto",0,false,0,0);
		MessageBody messageBody = new MessageBody(requestHeader, requestBody, null, null);
		
		Message messageToBeMarshelled = new Message(messageHeader, messageBody);
		
		//marshall
		messageMarshelled = marshaller.marshall(messageToBeMarshelled);
		
		//send to server
		clientRequestHandler.send(messageMarshelled);
		
		//receive reply
		messageToBeUnmarshelled = clientRequestHandler.receive();
		
		//unmarshall reply
		messageUnmarshalled = marshaller.unmarshall(messageToBeUnmarshelled);
		
		//return result to ClientProxy
		
		
		
		return termination;
	}
}
