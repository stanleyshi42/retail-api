package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Game;
import com.cognixia.jump.repository.GameRepository;

@Service
public class GameService {
	@Autowired
	GameRepository repo;

	// CRUD operations
	public Game createGame(Game game) {
		game.setId(null);
		Game created = repo.insert(game);
		return created;
	}

	public List<Game> findAllGames() {
		return repo.findAll();
	}

	public Game findGameById(String id) throws ResourceNotFoundException {
		Optional<Game> found = repo.findById(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new ResourceNotFoundException("Game", id);
	}

	public Game updateGame(Game game) throws ResourceNotFoundException {
		if (repo.existsById(game.getId())) {
			Game updated = repo.save(game);
			return updated;
		}

		throw new ResourceNotFoundException("Game", game.getId());
	}

	public Game deleteGame(String id) throws ResourceNotFoundException {
		Game toDelete = findGameById(id);
		repo.deleteById(id);
		return toDelete;
	}
	
	public List<Game> findByGenreContaining(String genre){
		return repo.findByGenreContaining(genre);
	}
	
	public List<Game> findByPlatformContaining(String platform){
		return repo.findByPlatformContaining(platform);
	}
	
	public List<Game> findByPriceLessThan(double price){
		return repo.findByPriceLessThan(price);
	}

	public List<Game> findByReleaseYear(int year) {
		return repo.findByReleaseYear(year);
	}
}
