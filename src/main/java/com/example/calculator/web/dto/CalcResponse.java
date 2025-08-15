package com.example.calculator.web.dto;

public class CalcResponse {
	private final double result;

	public CalcResponse(double result) {
		this.result = result;
	}

	public double getResult() {
		return result;
	}
} 