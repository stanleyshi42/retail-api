package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	Optional<Order> findByUserId(String id);

}
