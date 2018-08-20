package com.mycompany.crudmem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.crudmem.LongProcess;
import com.mycompany.crudmem.model.Client;

/**
 *
 * @author Leonid Ivanov
 */
@Service
public class ClientServ {

	@Autowired
	StatData stat;

	@Autowired
	LongProcess longProcess;

	public Client getClient(int x) {
		for (Client client : stat.dataList) {
			if (client.id_client == x) {
				return client;
			}
		}

		return new Client();
	}

	public List<Client> getClients() {
		return stat.dataList;
	}

	public List<Client> getClientsForSnils(String snils) {
		List<Client> newList = new ArrayList<>();
		for (Client client : stat.dataList) {
			if (client.snils.contains(snils)) {
				newList.add(client);
			}
		}
		return newList;
	}

	public List<Client> getClientsForUniqSnils(String snils) {
		List<Client> newList = new ArrayList<>();
		for (Client client : stat.dataList) {
			if (client.snils.equals(snils)) {
				newList.add(client);
			}
		}
		return newList;
	}

	public List<Client> addClient(Client client) {
		client.id_client = getNewId();
		stat.dataList.add(client);
		appendCounter();

		System.out.println("client inserted.");
		return stat.dataList;
	}

	private int getNewId() {
		if (stat.dataList.isEmpty())
			return 1;

		Collections.sort(stat.dataList, new Comparator<Client>() {
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

		return stat.dataList.get(stat.dataList.size() - 1).id_client + 1;
	}

	public List<Client> editClient(Client clientX) {
		System.out.println("new client =" + clientX);
		for (Client client : stat.dataList) {
			if (client.id_client == clientX.id_client) {
				client.snils = clientX.snils;
				client.fio = clientX.fio;
				client.birthday = clientX.birthday;
				appendCounter();
				System.out.println("client updated." + client);
			}
		}

		return stat.dataList;
	}

	public List<Client> deleteClient(int x) {
		for (Client client : stat.dataList) {
			if (client.id_client == x) {
				stat.dataList.remove(client);
				appendCounter();
				System.out.println("client deleted.");
				break;
			}
		}

		return stat.dataList;
	}

	private void appendCounter() {
		stat.counter = stat.counter + 1;
		longProcess.checkLongProcess();
	}

}
