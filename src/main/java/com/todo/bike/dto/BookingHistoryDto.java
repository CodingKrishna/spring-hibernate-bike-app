package com.todo.bike.dto;

import java.sql.Date;

public class BookingHistoryDto {
	private long bikeId;
	private String bikeName;
	private String bikeModel;
	private long price;
	private Date deliveryDate;

	private String buyerName;
	private String phoneNumber;
	private String address;
	private Date bookingDate;

	public BookingHistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingHistoryDto(long bikeId, String bikeName, String bikeModel,
			long price, Date deliveryDate, String buyerName,
			String phoneNumber, String address, Date bookingDate) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.bikeModel = bikeModel;
		this.price = price;
		this.deliveryDate = deliveryDate;
		this.buyerName = buyerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.bookingDate = bookingDate;
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	@Override
	public String toString() {
		return "BookingHistoryDto [bikeId=" + bikeId + ", bikeName=" + bikeName
				+ ", bikeModel=" + bikeModel + ", price=" + price
				+ ", deliveryDate=" + deliveryDate + ", buyerName=" + buyerName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", bookingDate= " + bookingDate + "]";
	}

}
