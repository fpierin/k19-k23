package br.com.k19.repository;

import java.util.List;

import br.com.k19.entities.Cliente;

public interface ClientRepository {

	List<Cliente> getAll();

	void create(Cliente client);

	void update(Cliente client);

	void delete(Cliente cliente);
	
	Cliente findById(Integer id);


}
