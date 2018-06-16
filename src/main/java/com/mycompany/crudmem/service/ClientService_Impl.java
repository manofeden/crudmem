package com.mycompany.crudmem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.crudmem.model.Client;
import com.mycompany.crudmem.repository.ClientDao;

/**
 *
 * @author Leonid Ivanov
 */
@Service
public class ClientService_Impl implements ClientService {

	@Autowired
	ClientDao dao;

	@Override
	public Client getClient(int i) {
		return dao.getClient(i);
	}

	@Override
	public List<Client> getClients() {
		return dao.getClients();
	}

	@Override
	public List<Client> getClientsForSnils(String snils) {
		return dao.getClientsForSnils(snils);
	}

	@Override
	public List<Client> getClientsForUniqSnils(String snils) {
		return dao.getClientsForUniqSnils(snils);
	}

	@Override
	public List<Client> addClient(Client client) {
		return dao.addClient(client);
	}

	@Override
	public List<Client> editClient(Client client) {
		return dao.editClient(client);
	}

	@Override
	public List<Client> deleteClient(int i) {
		return dao.deleteClient(i);
	}

}
