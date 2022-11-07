package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Order;
import com.cognixia.jump.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository repo;

	// CRUD operations
	public Order createOrder(Order order) {
		order.setId(null);
		Order created = repo.insert(order);
		return created;
	}

	public List<Order> findAllOrders() {
		return repo.findAll();
	}

	public Order findOrderById(String id) throws ResourceNotFoundException {
		Optional<Order> found = repo.findById(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new ResourceNotFoundException("Order", id);
	}
	
	public Order findOrderByUserId(String id) throws ResourceNotFoundException {
		Optional<Order> found = repo.findByUserId(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new ResourceNotFoundException("Order", id);
	}

	public Order updateOrder(Order order) throws ResourceNotFoundException {
		if (repo.existsById(order.getId())) {
			Order updated = repo.save(order);
			return updated;
		}

		throw new ResourceNotFoundException("Order", order.getId());
	}

	public Order deleteOrder(String id) throws ResourceNotFoundException {
		Order toDelete = findOrderById(id);
		repo.deleteById(id);
		return toDelete;
	}
	
	
}
