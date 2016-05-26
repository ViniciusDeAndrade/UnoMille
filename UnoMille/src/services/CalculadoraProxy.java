package services;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import apoio.Invocation;
import apoio.Termination;
import distribuition.Requestor;
import excepion.NumeroInvalidoException;

public class CalculadoraProxy extends ClientProxy implements ICalculadora{

	@Override
	public long Fibonacci(int numero) throws UnknownHostException, IOException, Throwable, NumeroInvalidoException {
		Invocation inv = new Invocation();
		Termination ter = new Termination();
		class Local {};
		String methodName;
		List<Object> parameters = new ArrayList<Object>();
		Requestor requestor = new Requestor();
		
		//recebe informações do cliente
		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(numero);
		
		//informação para o requestor
		inv.setIpAdress(this.getHost());
		inv.setObjectId(this.getObjectId());
		inv.setPortNumber(this.getPort());
		inv.setParameters(parameters);
		inv.setOperationName(methodName);
		
		//invoke requestor
		ter = requestor.invoke(inv);
		
		// return to client
		return ter.getResult();
	}
	
	@Override
	public long fatorial(int numero) throws UnknownHostException, IOException, Throwable, NumeroInvalidoException {
		Invocation inv = new Invocation();
		Termination ter = new Termination();
		class Local {};
		String methodName;
		List<Object> parameters = new ArrayList<Object>();
		Requestor requestor = new Requestor();
		
		//recebe informações do cliente
		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(numero);
		
		//informação para o requestor
		inv.setIpAdress(this.getHost());
		inv.setObjectId(this.getObjectId());
		inv.setPortNumber(this.getPort());
		inv.setParameters(parameters);
		inv.setOperationName(methodName);
		
		//invoke requestor
		ter = requestor.invoke(inv);
		
		// return to client
		return ter.getResult();
	}
	
		
	

}
