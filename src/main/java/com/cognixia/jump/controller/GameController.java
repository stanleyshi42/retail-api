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
import com.cognixia.jump.model.Game;
import com.cognixia.jump.service.GameService;

@RestController
@RequestMapping("/api")
public class GameController {
	@Autowired
	GameService service;

	// CRUD operations

	@PostMapping("/game")
	public ResponseEntity<?> createGame(@RequestBody Game game) {
		game.setId(null);
		Game created = service.createGame(game);

		return ResponseEntity.status(201).body(created);
	}

	@GetMapping("/game")
	public List<Game> findAllGames() {
		return service.findAllGames();
	}

	@GetMapping("/game/{id}")
	public ResponseEntity<?> findGameById(@PathVariable String id) throws ResourceNotFoundException {
		Game found = service.findGameById(id);
		return ResponseEntity.status(200).body(found);
	}

	@PutMapping("/game")
	public ResponseEntity<?> updateGame(@RequestBody Game game) throws ResourceNotFoundException {
		Game updated = service.updateGame(game);
		return ResponseEntity.status(200).body(updated);
	}

	@DeleteMapping("/game/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable String id) throws ResourceNotFoundException {
		Game deleted = service.deleteGame(id);
		return ResponseEntity.status(200).body(deleted);
	}

	@GetMapping("/game/genre/{genre}")
	public List<Game> findByGenreContaining(@PathVariable String genre) {
		List<Game> found = service.findByGenreContaining(genre);
		return found;
	}

	@GetMapping("/game/platform/{platform}")
	public List<Game> findByPlatformContaining(@PathVariable String platform) {
		List<Game> found = service.findByPlatformContaining(platform);
		return found;
	}

	@GetMapping("/game/price/under/{price}")
	public List<Game> findByPriceLessThan(@PathVariable double price) {
		List<Game> found = service.findByPriceLessThan(price);
		return found;
	}

	@GetMapping("/game/year/{year}")
	public List<Game> findByReleaseYear(@PathVariable int year) {
		List<Game> found = service.findByReleaseYear(year);
		return found;
	}
}
