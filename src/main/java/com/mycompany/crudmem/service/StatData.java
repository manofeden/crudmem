package com.mycompany.crudmem.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mycompany.crudmem.model.Client;

@Component
@Scope("singleton")
public class StatData {
	public AtomicInteger counter = new AtomicInteger(0);
	public int COUNTER_MAX_VALUE = 3;
	List<Client> dataList = new CopyOnWriteArrayList<>();

	public void clearCounter() {
		counter.set(0);
	}

	public int getCount() {
		return counter.get();
	}
}
