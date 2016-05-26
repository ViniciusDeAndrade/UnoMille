package services;

import java.io.IOException;
import java.net.UnknownHostException;

import excepion.NumeroInvalidoException;

public class ObjetoRemoto implements ICalculadora {

	@Override
	public long Fibonacci(int numero) throws UnknownHostException, IOException, Throwable, NumeroInvalidoException{

		if (numero < 0)
			throw new NumeroInvalidoException("não se calcula Fibonacci com números negativos");
		if((numero == 0) || (numero == 1))
			return 1;
		else
			return Fibonacci(numero*(numero-1));
	}

	@Override
	public long fatorial(int numero) throws UnknownHostException, IOException, Throwable, NumeroInvalidoException {
		if(numero < 0)
			throw new NumeroInvalidoException("não se calcula fatorial de números negativos");
		if ((numero == 0) || (numero == 1))
				return 1;
		else
			return fatorial(numero*(numero-1));
	}


}
