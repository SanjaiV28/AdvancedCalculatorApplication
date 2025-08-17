package com.example.calculator.web;

import com.example.calculator.service.ExpressionService;
import com.example.calculator.web.dto.BinaryOpRequest;
import com.example.calculator.web.dto.UnaryOpRequest;
import com.example.calculator.web.dto.ExpressionRequest;
import com.example.calculator.web.dto.CalcResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
public class CalculatorController {
	private final ExpressionService expressionService;

	public CalculatorController(ExpressionService expressionService) {
		this.expressionService = expressionService;
	}

	@PostMapping("/binary")
	public ResponseEntity<CalcResponse> binary(@Valid @RequestBody BinaryOpRequest request) {
		double result = expressionService.applyBinaryOperation(request.getOp(), request.getX(), request.getY());
		return ResponseEntity.ok(new CalcResponse(result));
	}

	@PostMapping("/unary")
	public ResponseEntity<CalcResponse> unary(@Valid @RequestBody UnaryOpRequest request) {
		double result = expressionService.applyUnaryOperation(request.getOp(), request.getX());
		return ResponseEntity.ok(new CalcResponse(result));
	}

	@PostMapping("/expr")
	public ResponseEntity<CalcResponse> expr(@Valid @RequestBody ExpressionRequest request) {
		double result = expressionService.evaluateExpression(request.getExpression(), request.getVariables());
		return ResponseEntity.ok(new CalcResponse(result));
	}
} 