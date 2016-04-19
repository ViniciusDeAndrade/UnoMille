package common_services;

import java.io.IOException;
import java.util.Scanner;

import data.Message;
import distribuition.Marshaller;
import infrastructure.ClientRequestHandler;

//lado cliente
public class Request {
	public static void main(String[] args) {
		
		//leitura da mensagem
		Scanner sc = new Scanner(System.in);
		System.out.println("digite um texto");
		String texto = sc.next();

		//serialização da mensagem e respectivo envio

		Message mensagem = new Message(texto);
		Marshaller m = new Marshaller();
		ClientRequestHandler crh = new ClientRequestHandler("localhost", 1313);

		byte[] mensagemSerializada = null;
		//serialização
		try {
			mensagemSerializada = m.marshall(mensagem);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		//envio
		try {
			crh.send(mensagemSerializada);
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
