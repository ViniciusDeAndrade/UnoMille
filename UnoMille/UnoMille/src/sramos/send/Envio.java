package sramos.send;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.swing.JOptionPane;

import data.Message;
import sramos.receiver.Recebedor;

/**
 * Execcutar a classe {@link Envio} e depois executar a {@link Recebedor}
 * 
 * @author Adriano
 *
 */
public class Envio {

	public static void main(String[] args) throws IOException {
		System.out.println("Envio INICIO");

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(true);
		int port = 1313;
		serverSocketChannel.socket().bind(new InetSocketAddress(port));

		String value = (String) JOptionPane.showInputDialog(null, "digite um texto", "Envio", JOptionPane.PLAIN_MESSAGE, null, null, "");
		Message message = new Message(value);

		while (true) {
			SocketChannel socketChannel = serverSocketChannel.accept();

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
			objectOutputStream.writeObject(message);
			objectOutputStream.close();

			System.out.println("Conexao encerrada");
		}
	}
}
