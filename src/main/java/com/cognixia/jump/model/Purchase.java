package com.cognixia.jump.model;

import javax.validation.constraints.NotBlank;

public class Purchase {
	@NotBlank
	private String gameId;

	@NotBlank
	private int qty;

	public Purchase() {

	}

	public Purchase(@NotBlank String gameId, @NotBlank int qty) {
		super();
		this.gameId = gameId;
		this.qty = qty;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Purchase [gameId=" + gameId + ", qty=" + qty + "]";
	}

}
