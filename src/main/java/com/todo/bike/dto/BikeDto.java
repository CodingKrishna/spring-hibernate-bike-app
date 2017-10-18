package com.todo.bike.dto;

import java.sql.Date;

public class BikeDto {
	private long id;
	private String name;
	private String model;
	private long price;
	private Date date;
	public BikeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BikeDto(long id, String name, String model, long price, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BikeDto [id=" + id + ", name=" + name + ", model=" + model
				+ ", price=" + price + ", date=" + date + "]";
	}
}
