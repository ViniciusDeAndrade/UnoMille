package principal;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import excepion.NumeroInvalidoException;
import services.CalculadoraProxy;
import services.ClientProxy;

public class Principal {

	public static void main(String[] args) throws UnknownHostException, IOException, NumeroInvalidoException, Throwable {

		CalculadoraProxy cp= new CalculadoraProxy();
		
		System.out.println("digite um número");
		Scanner sc = new Scanner(System.in);
		long resultado  = cp.Fibonacci(sc.nextInt());
		System.out.println("o resultado é " + resultado);
	}
}
