package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Order;
import com.cognixia.jump.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderService service;

	// CRUD operations
	
	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		order.setId(null);
		Order created = service.createOrder(order);

		return ResponseEntity.status(201).body(created);
	}

	@GetMapping("/order")
	public List<Order> findAllOrders() {
		return service.findAllOrders();
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<?> findOrderById(@PathVariable String id) throws ResourceNotFoundException {
		Order found = service.findOrderById(id);
		return ResponseEntity.status(200).body(found);
	}

	@PutMapping("/order")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) throws ResourceNotFoundException {
		Order updated = service.updateOrder(order);
		return ResponseEntity.status(200).body(updated);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable String id) throws ResourceNotFoundException {
		Order deleted = service.deleteOrder(id);
		return ResponseEntity.status(200).body(deleted);
	}
}
