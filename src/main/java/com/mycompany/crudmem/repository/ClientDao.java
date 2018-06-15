package com.mycompany.crudmem.repository;

import java.util.List;

import com.mycompany.crudmem.model.Client;

/**
 *
 * @author Leonid Ivanov
 */
public interface ClientDao {
	Client getClient(int i);

	void createClients();

	List<Client> getClients();

	List<Client> getClientsForSnils(String snils);

	List<Client> getClientsForUniqSnils(String snils);

	List<Client> addClient(Client client);

	List<Client> editClient(Client client);

	List<Client> deleteClient(int i);
}
