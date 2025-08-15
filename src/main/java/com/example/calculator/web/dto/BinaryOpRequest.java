package com.example.calculator.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BinaryOpRequest {
	@NotBlank(message = "Operation is required")
	private String op;
	@NotNull(message = "x is required")
	private Double x;
	@NotNull(message = "y is required")
	private Double y;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
} 