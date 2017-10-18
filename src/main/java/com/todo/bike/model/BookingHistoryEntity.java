package com.todo.bike.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookingHistory")
public class BookingHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "BIKE_ID")
	private long bikeId;
	
	@Column(name = "BIKE_NAME")
	private String bikeName;
	
	@Column(name = "BIKE_MODEL")
	private String bikeModel;
	
	@Column(name = "PRICE")
	private long price;
	
	@Column(name = "BUYER_NAME")
	private String buyerName;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "BOOKING_DATE")
	private Date bookingDate;
	
	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;

	public BookingHistoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingHistoryEntity(long id, long bikeId, String bikeName,
			String bikeModel, long price, String buyerName, String phoneNumber,
			String address, Date bookingDate, Date deliveryDate) {
		super();
		this.id = id;
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.bikeModel = bikeModel;
		this.price = price;
		this.buyerName = buyerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.bookingDate = bookingDate;
		this.deliveryDate = deliveryDate;
	}

	public long getId() {
		return id;
	}

	public long getBikeId() {
		return bikeId;
	}

	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "BookingHistoryEntity [id=" + id + ", bikeId=" + bikeId
				+ ", bikeName=" + bikeName + ", bikeModel=" + bikeModel
				+ ", price=" + price + ", buyerName=" + buyerName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", bookingDate=" + bookingDate + ", deliveryDate="
				+ deliveryDate + "]";
	}
	
}
