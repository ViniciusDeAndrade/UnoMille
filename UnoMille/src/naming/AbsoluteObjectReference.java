package naming;

import java.io.IOException;
import java.net.UnknownHostException;

import excepion.NumeroInvalidoException;
import services.ClientProxy;
import services.ObjetoRemoto;

public class AbsoluteObjectReference {


	private void setDados(){
		ClientProxy clientProxy = new ClientProxy();
		clientProxy.setHost("localhost");
		clientProxy.setPort(1313);
		clientProxy.setObjectId(0);
					
	}
	
	public long identificador(String nomeDoMetodo, int numero) throws UnknownHostException, IOException, NumeroInvalidoException, Throwable{
		ObjetoRemoto objeto = new ObjetoRemoto();
		if(nomeDoMetodo.equalsIgnoreCase("fatorial"))
			return objeto.fatorial(numero);
		else
			return objeto.Fibonacci(numero);
	}


}
