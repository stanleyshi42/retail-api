package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {

	List<Game> findByGenreContaining(String genre);

	List<Game> findByPlatformContaining(String platform);

	List<Game> findByPriceLessThan(double price);

}
