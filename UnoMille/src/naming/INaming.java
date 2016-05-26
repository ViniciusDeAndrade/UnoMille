package naming;

import java.util.List;
import java.io.IOException;
import java.net.UnknownHostException;

import services.ClientProxy;

public interface INaming {
	public void bind(String serviceName, ClientProxy clientProxy)throws UnknownHostException, IOException, Throwable;
	
	public ClientProxy lookup(String serviceName)throws UnknownHostException, IOException, Throwable;
	
	public List <String> list() throws UnknownHostException, IOException, Throwable;

}
