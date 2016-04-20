package application;

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

		Message mensagem = new Message();
		mensagem.setMessage(texto);
		Marshaller m = new Marshaller();
		ClientRequestHandler clienteRequestHandler = new ClientRequestHandler("localhost", 1313);

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
			clienteRequestHandler.send(mensagemSerializada);
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//recebimento da mensagem
		byte [] reply = null;
		try {
			reply = clienteRequestHandler.receive();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//desearilização 
		Message resposta = new Message();
		try {
			resposta = (Message) m.unmarshall(reply);
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resposta.getMessage());
		
	}

}
