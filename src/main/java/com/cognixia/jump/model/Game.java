package com.cognixia.jump.model;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game {
	@Id
	private String id;

	@NotBlank
	private String name;

	@NotBlank
	private double price;

	@NotBlank
	private int stock;

	@NotBlank
	private String platform;

	@NotBlank
	private String[] genre;

	@NotBlank
	private int releaseYear;

	@NotBlank
	private String developer;

	public Game() {

	}

	public Game(String id, @NotBlank String name, @NotBlank double price, @NotBlank int stock,
			@NotBlank String platform, @NotBlank String[] genres, @NotBlank int releaseYear,
			@NotBlank String developer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.platform = platform;
		this.genre = genres;
		this.releaseYear = releaseYear;
		this.developer = developer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatforms(String platform) {
		this.platform = platform;
	}

	public String[] getGenres() {
		return genre;
	}

	public void setGenres(String[] genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", platform=" + platform
				+ ", genres=" + Arrays.toString(genre) + ", releaseYear=" + releaseYear + ", developer=" + developer
				+ "]";
	}

}
