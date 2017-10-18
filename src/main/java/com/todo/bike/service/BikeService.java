package com.todo.bike.service;

import java.sql.Date;
import java.util.List;

import com.todo.bike.dto.BikeDto;
import com.todo.bike.dto.BookingHistoryDto;
import com.todo.bike.model.BikeEntity;
import com.todo.bike.model.BookingHistoryEntity;

public interface BikeService {

	List<BikeEntity> getBikesbyDate(Date date);

	BikeDto getBikebyBikeId(String bikeId);

	void deleteBookeBike(BikeDto bikeDto);

	void insertBookingHistory(BookingHistoryDto bookingHistoryDto);

	List<BookingHistoryEntity> bookingHistory();

	List<BikeEntity> totalBikes(); 

}
