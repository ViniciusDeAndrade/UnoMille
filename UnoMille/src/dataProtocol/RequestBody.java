package dataProtocol;

import java.util.ArrayList;
import java.util.List;

public class RequestBody {

	private List<Object> parameters = new ArrayList<Object>();

	public RequestBody(List<Object> parameters) {
		this.parameters.add(parameters);
	}

	public List<Object> getParameters() {
		return parameters;
	}

	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}
	
	
	
	
}
