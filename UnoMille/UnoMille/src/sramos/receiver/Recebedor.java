package sramos.receiver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import data.Message;

/**
 * Execcutar a classe {@link Recebedor} somente apos ter executado a classe a {@link Envio}
 * 
 * @author Adriano
 *
 */
public class Recebedor {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Recebedor Inicio");

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(true);
		if (socketChannel.connect(new InetSocketAddress("localhost", 1313))) {

			ObjectInputStream objectInputStream = new ObjectInputStream(socketChannel.socket().getInputStream());

			Message message = (Message) objectInputStream.readObject();
			System.out.println(message);
		}
		System.out.println("Final Recebedor");
	}
}
