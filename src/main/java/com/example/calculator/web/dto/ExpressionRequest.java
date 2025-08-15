package com.example.calculator.web.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Map;

public class ExpressionRequest {
	@NotBlank(message = "Expression is required")
	private String expression;
	private Map<String, Double> variables;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Map<String, Double> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Double> variables) {
		this.variables = variables;
	}
} 