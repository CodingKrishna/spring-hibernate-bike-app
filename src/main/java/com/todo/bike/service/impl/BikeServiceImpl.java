package com.todo.bike.service.impl;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.todo.bike.dao.BikeDao;
import com.todo.bike.dto.BikeDto;
import com.todo.bike.dto.BookingHistoryDto;
import com.todo.bike.model.BikeEntity;
import com.todo.bike.model.BookingHistoryEntity;
import com.todo.bike.service.BikeService;

@Service("bikeServiceImpl")
public class BikeServiceImpl implements BikeService {

	@Autowired
	@Qualifier("bikeDaoImpl")
	BikeDao bikeDao;
	
	public List<BikeEntity> getBikesbyDate(Date date) {
		// TODO Auto-generated method stub
		List<BikeEntity> bikes = (List<BikeEntity>) bikeDao.getBikesbyDate(date);
		//System.out.println(bikes);
		return bikes;
	}

	public BikeDto getBikebyBikeId(String bikeId) {
		// TODO Auto-generated method stub
		BikeEntity bikeEntity = bikeDao.getBikebyBikeId(bikeId);
		BikeDto bikeDto = new BikeDto();
		bikeDto.setId(bikeEntity.getId());
		bikeDto.setName(bikeEntity.getName());
		bikeDto.setModel(bikeEntity.getModel());
		bikeDto.setPrice(bikeEntity.getPrice());
		bikeDto.setDate(bikeEntity.getDate());
		return bikeDto;
	}

	public void deleteBookeBike(BikeDto bikeDto) {
		// TODO Auto-generated method stub
		BikeEntity bikeEntity = new BikeEntity(bikeDto.getId(), bikeDto.getName(), bikeDto.getModel(), bikeDto.getPrice(), bikeDto.getDate());
		bikeDao.deleteBookeBike(bikeEntity);
	}

	public void insertBookingHistory(BookingHistoryDto bookingHistoryDto) {
		// TODO Auto-generated method stub
		BookingHistoryEntity bookingHistoryEntity = new BookingHistoryEntity();
		
		bookingHistoryEntity.setBikeId(bookingHistoryDto.getBikeId());
		bookingHistoryEntity.setBikeName(bookingHistoryDto.getBikeName());
		bookingHistoryEntity.setBikeModel(bookingHistoryDto.getBikeModel());
		bookingHistoryEntity.setPrice(bookingHistoryDto.getPrice());
		bookingHistoryEntity.setBuyerName(bookingHistoryDto.getBuyerName());
		bookingHistoryEntity.setPhoneNumber(bookingHistoryDto.getPhoneNumber());
		bookingHistoryEntity.setAddress(bookingHistoryDto.getAddress());
		bookingHistoryEntity.setBookingDate(bookingHistoryDto.getBookingDate());
		bookingHistoryEntity.setDeliveryDate(bookingHistoryDto.getDeliveryDate());
		
		bikeDao.insertBookingHistory(bookingHistoryEntity);
	}

	public List<BookingHistoryEntity> bookingHistory() {
		// TODO Auto-generated method stub
		List<BookingHistoryEntity> list = bikeDao.bookingHistory();
		return list;
	}

	public List<BikeEntity> totalBikes() {
		// TODO Auto-generated method stub
		List<BikeEntity> toatlBikes = bikeDao.totalBikes();
		return toatlBikes;
	}
}
