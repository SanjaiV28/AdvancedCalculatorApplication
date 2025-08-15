package com.example.calculator;

import com.example.calculator.service.ExpressionService;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionServiceTest {
	ExpressionService svc = new ExpressionService();

	@Test
	void testBinaryAdd() {
		assertEquals(5.0, svc.applyBinaryOperation("add", 2, 3));
	}

	@Test
	void testUnarySqrt() {
		assertEquals(3.0, svc.applyUnaryOperation("sqrt", 9), 1e-9);
	}

	@Test
	void testExpr() {
		double result = svc.evaluateExpression("a^2 + sin(pi/2)", Map.of("a", 3.0));
		assertEquals(10.0, result, 1e-9);
	}
} 