package com.dave.acalc;

public class Addition implements Operation {

	@Override
	public double calculate(double one, double two) {
		return one + two;
	}

	@Override
	public String getOperator() {
		return "+";
	}

}
