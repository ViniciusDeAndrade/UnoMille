package naming;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import services.ClientProxy;

public class NamingImpl implements INaming{


	private Map<String, ClientProxy> mapaServicos = new HashMap<>();
	private List<ClientProxy> listaServicos = new ArrayList<>();

	public void bind(String serviceName, ClientProxy clientProxy) throws UnknownHostException, IOException, Throwable {
		mapaServicos.put(serviceName, clientProxy);
		listaServicos.add(clientProxy);
	}


	public ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable {
		ClientProxy clientProxy = mapaServicos.get(serviceName);
		return clientProxy;
	}


	public List<String> list() throws UnknownHostException, IOException, Throwable {
		List<String> keys = new ArrayList<>();
		Set<String> chaves = mapaServicos.keySet();		
		for(String chave: chaves)
			keys.add(chave);
		return keys;
	}


}
