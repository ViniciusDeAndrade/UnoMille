package distribuition;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import apoio.Termination;
import dataProtocol.Message;
import dataProtocol.MessageBody;
import dataProtocol.MessageHeader;
import dataProtocol.ReplyBody;
import dataProtocol.ReplyHeader;
import infrastructure.ServerRequestHandler;
import services.ClientProxy;
import services.ObjetoRemoto;

public class CalculatorInvolker {

	public static final String FIBONACCI = "Fibonacci";
	public static final String FATORIAL = "fatorial";
	

	public void involke(ClientProxy clientProxy) throws IOException, Throwable{
	//public void involke(Socket socket, int port) throws IOException, Throwable{	
		ServerRequestHandler serverRequestHandler = new ServerRequestHandler(clientProxy.getPort());
		byte[] messageToBeUnmarshalled = null;
		byte[] messageMarshalled = null;
		Message messageUnmarshalled = new Message();
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination();

		//create remote object 
		ObjetoRemoto objeto = new ObjetoRemoto();

		while(true){

			//receba a mensagem e unmarshall-a
			messageToBeUnmarshalled = serverRequestHandler.receive();
			messageUnmarshalled = marshaller.unmarshall(messageToBeUnmarshalled);

			//invoca o objeto remoto
			if (messageUnmarshalled.getBody().getRequestHeader().getOperation().equalsIgnoreCase(FIBONACCI)){

				//se a operação for Fibonacci
				int numero = (int) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
				long resultado = objeto.Fibonacci(numero);
				termination.setResult(resultado);


			}else{
				//se a operação for fatorial
				int numero = (int) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
				long resultado = objeto.fatorial(numero);
				termination.setResult(resultado);
			}
			//tratamento da resposta

			Message reply = new Message(new MessageHeader("protocolo",0, false, 0, 0),
					new MessageBody(null, null, new ReplyHeader("",0,0), new ReplyBody(termination.getResult())));

			//marshall reply
			messageMarshalled = marshaller.marshall(reply);

			//reply
			serverRequestHandler.send(messageMarshalled);

		}


	}

}


