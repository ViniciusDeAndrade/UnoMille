package services;

import java.io.IOException;
import java.net.UnknownHostException;

import excepion.NumeroInvalidoException;

public interface ICalculadora {
	
	public long Fibonacci(int numero) throws UnknownHostException, IOException, Throwable, NumeroInvalidoException;
	public long fatorial(int numero) throws UnknownHostException, IOException, Throwable, NumeroInvalidoException;
	
}
