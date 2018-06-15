package com.mycompany.crudmem.repository;

import static com.mycompany.crudmem.Astat.counter;
import static com.mycompany.crudmem.Astat.dataList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.mycompany.crudmem.LongProcess;
import com.mycompany.crudmem.model.Client;

/**
 *
 * @author Leonid Ivanov
 */
@Repository
public class ClientDao_Impl implements ClientDao {

	@Override
	public void createClients() {
		dataList = new CopyOnWriteArrayList<>();
		System.out.println("CREATE List clients ...");
	}

	@Override
	public Client getClient(int x) {
		for (Client client : dataList) {
			if (client.id_client == x) {
				return client;
			}
		}

		return new Client();
	}

	@Override
	public List<Client> getClients() {
		return dataList;
	}

	@Override
	public List<Client> getClientsForSnils(String snils) {
		List<Client> newList = new ArrayList<>();
		for (Client client : dataList) {
			if (client.snils.contains(snils)) {
				newList.add(client);
			}
		}
		return newList;
	}

	@Override
	public List<Client> getClientsForUniqSnils(String snils) {
		List<Client> newList = new ArrayList<>();
		for (Client client : dataList) {
			if (client.snils.equals(snils)) {
				newList.add(client);
			}
		}
		return newList;
	}

	@Override
	public List<Client> addClient(Client client) {
		client.id_client = getNewId();
		dataList.add(client);
		appendCounter();

		System.out.println("client inserted.");
		return dataList;
	}

	private int getNewId() {
		if (dataList.isEmpty())
			return 1;

		Collections.sort(dataList, new Comparator<Client>() {
			@Override
			public int compare(Client c1, Client c2) {
				if (c1.id_client > c2.id_client) {
					return 1;
				}
				if (c1.id_client < c2.id_client) {
					return -1;
				}
				return 0;
			}
		});

		return dataList.get(dataList.size() - 1).id_client + 1;
	}

	@Override
	public List<Client> editClient(Client clientX) {
		System.out.println("new client =" + clientX);
		for (Client client : dataList) {
			if (client.id_client == clientX.id_client) {
				client.snils = clientX.snils;
				client.fio = clientX.fio;
				client.birthday = clientX.birthday;
				appendCounter();
				System.out.println("client updated." + client);
			}
		}

		return dataList;
	}

	@Override
	public List<Client> deleteClient(int x) {
		for (Client client : dataList) {
			if (client.id_client == x) {
				dataList.remove(client);
				appendCounter();
				System.out.println("client deleted.");
				break;
			}
		}

		return dataList;
	}

	private void appendCounter() {
		counter = counter + 1;
		LongProcess.checkLongProcess();
	}
}
