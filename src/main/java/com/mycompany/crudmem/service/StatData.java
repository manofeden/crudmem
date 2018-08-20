package com.mycompany.crudmem.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mycompany.crudmem.model.Client;

@Component
@Scope("singleton")
public class StatData {
	public int counter;
	public int COUNTER_MAX_VALUE = 100;
	List<Client> dataList = new CopyOnWriteArrayList<>();
}
