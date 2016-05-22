package apoio;

import java.util.List;

public class Invocation {

	private String IPAdress;
	private int port;
	private int objectId;
	private String operationName;
	private List<Object> parameters;
	
	public List<Object> getParameters() {
		return parameters;
	}

	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

	public void setOperationName(String nameMethod){
		this.operationName = nameMethod;
	}
	
	public String getOperationName(){
		return this.operationName;
	}
	
	public String getIPAdress() {
		return IPAdress;
	}
	public void setIpAdress(String IPAdress) {
		this.IPAdress = IPAdress;
	}
	public int getPortNumber() {
		return port;
	}
	public void setPortNumber(int port) {
		this.port = port;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
}
