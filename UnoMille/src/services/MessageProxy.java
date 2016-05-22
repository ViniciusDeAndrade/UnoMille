package services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import apoio.Invocation;

public class MessageProxy extends ClientProxy implements IMensager{

	@Override
	public void setMessage(String mensagem) {
		Invocation inv = new Invocation();
		class Local {};
		String methodName;
		List<Object> parameters = new ArrayList<Object>();
		
		//recebe informações do cliente
		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(mensagem);
		
		//informação para o requestor
		inv.setIpAdress(this.getHost());
		inv.setObjectId(this.getObjectId());
		inv.setPortNumber(this.getPort());
		inv.setParameters(parameters);
		inv.setOperationName(methodName);
		
		//invoke requestor
		
	}

	@Override
	public String getMessage() {
		
		
		return null;
	}
	
	
	

}
