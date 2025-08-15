package com.example.calculator.service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpressionService {
	public double evaluateExpression(String expression, Map<String, Double> variables) {
		if (expression == null || expression.isBlank()) {
			throw new IllegalArgumentException("Expression must not be empty");
		}
		ExpressionBuilder builder = new ExpressionBuilder(expression);
		if (variables != null) {
			builder = builder.variables(variables.keySet());
		}
		Expression exp = builder.build();
		if (variables != null) {
			variables.forEach(exp::setVariable);
		}
		double result = exp.evaluate();
		if (Double.isNaN(result) || Double.isInfinite(result)) {
			throw new ArithmeticException("Expression evaluated to a non-finite number");
		}
		return result;
	}

	public double applyBinaryOperation(String op, double x, double y) {
		switch (op.toLowerCase()) {
			case "add":
				return x + y;
			case "subtract":
				return x - y;
			case "multiply":
				return x * y;
			case "divide":
				if (y == 0.0) {
					throw new ArithmeticException("Division by zero");
				}
				return x / y;
			case "pow":
				return Math.pow(x, y);
			case "mod":
				if (y == 0.0) {
					throw new ArithmeticException("Modulo by zero");
				}
				return x % y;
			default:
				throw new IllegalArgumentException("Unsupported binary operation: " + op);
		}
	}

	public double applyUnaryOperation(String op, double x) {
		switch (op.toLowerCase()) {
			case "sqrt":
				if (x < 0) {
					throw new ArithmeticException("Square root of negative number");
				}
				return Math.sqrt(x);
			case "abs":
				return Math.abs(x);
			case "sin":
				return Math.sin(x);
			case "cos":
				return Math.cos(x);
			case "tan":
				return Math.tan(x);
			case "asin":
				return Math.asin(x);
			case "acos":
				return Math.acos(x);
			case "atan":
				return Math.atan(x);
			case "exp":
				return Math.exp(x);
			case "ln":
				if (x <= 0) {
					throw new ArithmeticException("Natural log undefined for non-positive values");
				}
				return Math.log(x);
			case "log10":
				if (x <= 0) {
					throw new ArithmeticException("Log10 undefined for non-positive values");
				}
				return Math.log10(x);
			case "deg2rad":
				return Math.toRadians(x);
			case "rad2deg":
				return Math.toDegrees(x);
			default:
				throw new IllegalArgumentException("Unsupported unary operation: " + op);
		}
	}
} 