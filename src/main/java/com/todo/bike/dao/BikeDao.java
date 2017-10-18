package com.todo.bike.dao;

import java.sql.Date;
import java.util.List;

import com.todo.bike.model.BikeEntity;
import com.todo.bike.model.BookingHistoryEntity;

public interface BikeDao {

	List<BikeEntity> getBikesbyDate(Date date);

	BikeEntity getBikebyBikeId(String bikeId);

	void deleteBookeBike(BikeEntity bikeEntity);

	void insertBookingHistory(BookingHistoryEntity bookingHistoryEntity);

	List<BookingHistoryEntity> bookingHistory();

	List<BikeEntity> totalBikes();

}
