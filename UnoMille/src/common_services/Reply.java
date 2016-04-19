package common_services;

import java.io.IOException;

import data.Message;
import distribuition.Marshaller;
import infrastructure.ServerRequestHandler;

public class Reply {
	public static void main(String[] args) {


		//pegando a mensagem
		ServerRequestHandler srh = new ServerRequestHandler(1313);
		byte [] mensagemSerializada = null;
		try {
			mensagemSerializada = srh.receive();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Deserizalizando
		Message mensagem = null;
		Marshaller marshaller = new Marshaller();
		try {
			mensagem = (Message) marshaller.unmarshall(mensagemSerializada);
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//processamento da mensagem
		String texto = "A mensagem que chegou no servidor é : " +  mensagem.getMessage();
		mensagem.setMessage(texto);
		byte [] reply = null;
		try {
			reply = marshaller.marshall(mensagem);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//reply mensagem
		try {
			srh.send(reply);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}