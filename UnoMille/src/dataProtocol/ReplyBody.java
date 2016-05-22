package dataProtocol;

import java.io.Serializable;

public class ReplyBody implements Serializable{

	private Object operationResult;
	
	public ReplyBody(Object operationResult){
		this.operationResult = operationResult;
	}
}
