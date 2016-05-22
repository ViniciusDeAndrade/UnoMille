package distribuition;

import java.io.IOException;

import apoio.Termination;
import dataProtocol.Message;
import infrastructure.ServerRequestHandler;
import services.ClientProxy;

public class MessageInvolker {

	public void involke(ClientProxy clientProxy) throws IOException, Throwable{
		
		ServerRequestHandler serverRequestHandler = new ServerRequestHandler(clientProxy.getPort());
		byte[] messageToBeUnmarshalled = null;
		byte[] messageMarshalled = null;
		Message messageUnmarshalled = new Message();
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination();
		
		//create remote object OBS.: FALTA FAZER ISSO AQUI AINDA
		
		//loop
		
		while(true){
			
			//receba a mensagem e unmarshall-a
			messageToBeUnmarshalled = serverRequestHandler.receive();
			messageUnmarshalled = marshaller.unmarshall(messageToBeUnmarshalled);
			
			
		}
		
	}
	
}
