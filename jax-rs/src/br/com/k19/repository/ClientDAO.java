package br.com.k19.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.k19.entities.Cliente;

public class ClientDAO implements ClientRepository {

	private final Map<Integer, Cliente> clients = new HashMap<Integer, Cliente>();

	public static void main(String[] args) {
		ArrayList<Cliente> arrayList = new ArrayList<Cliente>(new HashMap<Integer, Cliente>().values());
		System.out.println(arrayList.size());
	}

	@Override
	public List<Cliente> getAll() {
		return new ArrayList<Cliente>(clients.values());
	}

	@Override
	public void create(final Cliente client) {
		clients.put(client.getId(), client);
	}

	@Override
	public void update(final Cliente client) {
		clients.put(client.getId(), client);
	}

	@Override
	public Cliente findById(final Integer id) {
		return clients.get(id);
	}

	@Override
	public void delete(final Cliente cliente) {
		this.clients.remove(cliente.getId());
	}

}
