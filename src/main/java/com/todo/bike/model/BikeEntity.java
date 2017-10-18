package com.todo.bike.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIKE_DETAILS")
public class BikeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "BIKE_NAME")
	private String name;
	
	@Column(name = "BIKE_MODEL")
	private String model;
	
	@Column(name = "PRICE")
	private long price;
	
	@Column(name = "DELIVERY_DATE")
	private Date date;

	public BikeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BikeEntity(long id, String name, String model, long price, Date date) {
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
		return "BikeEntity [id=" + id + ", name=" + name + ", model=" + model
				+ ", price=" + price + ", date=" + date + "]";
	}
	
	
}
