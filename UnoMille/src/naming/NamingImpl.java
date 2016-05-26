package naming;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import services.ClientProxy;

public class NamingImpl implements INaming{

	
	public void bind(String serviceName, ClientProxy clientProxy) throws UnknownHostException, IOException, Throwable {

		
	}

	
	public ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable {
		
		return null;
	}

	
	public List<String> list() throws UnknownHostException, IOException, Throwable {
		
		return null;
	}
	

}
