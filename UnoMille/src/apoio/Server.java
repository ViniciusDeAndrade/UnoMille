package apoio;

import java.io.IOException;
import java.net.ServerSocket;

import distribuition.CalculatorInvolker;

public class Server {

	public static void main(String[] args) throws Throwable {
		ServerSocket serverSocket = new ServerSocket(1313);
		//registrar no serviço de nomes
		System.out.println("server rodando");
		CalculatorInvolker calculatorInvolker = new CalculatorInvolker();
		//calculatorInvolker.involke();
	}
}
