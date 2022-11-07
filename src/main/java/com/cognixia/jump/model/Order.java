package com.cognixia.jump.model;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id
	private String id;

	@NotBlank
	private String userId;

	@NotBlank
	private Purchase[] purchases;

	public Order() {

	}

	public Order(String id, @NotBlank String userId, @NotBlank Purchase[] purchases) {
		super();
		this.id = id;
		this.userId = userId;
		this.purchases = purchases;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Purchase[] getPurchases() {
		return purchases;
	}

	public void setPurchases(Purchase[] purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", purchases=" + Arrays.toString(purchases) + "]";
	}

}
