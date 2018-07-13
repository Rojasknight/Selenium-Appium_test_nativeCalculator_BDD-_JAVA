package com.accenture.TestCalculatorF;

public class Dato {

	
	private Integer number1;
	private String operator;
	private Integer number2;

	
	
	public Dato(Integer number1, String operator, Integer number2) {
		super();
		this.number1 = number1;
		this.operator = operator;
		this.number2 = number2;
	}



	public Dato() {
		super();
	}

	


	public Integer getNumber1() {
		return number1;
	}



	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}



	public String getOperator() {
		return operator;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}



	public Integer getNumber2() {
		return number2;
	}



	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}



	public String toString() {
		return number1 + " " + operator + " " + number2;
	}
}
