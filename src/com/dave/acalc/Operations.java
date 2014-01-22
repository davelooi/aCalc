package com.dave.acalc;

import java.util.HashMap;

public class Operations {
	public HashMap<String, Operation> operations;

	public Operations() {
		operations = new HashMap<String, Operation>();
		assignOperations();
	}
	
	public Operation getOperation(String operator)
	{
		return operations.get(operator);
	}

	private void assignOperations() {
		operations.put("+", new Addition());
		operations.put("-", new Subtraction());
		operations.put("*", new Multiplication());
		operations.put("/", new Division());
	}
}