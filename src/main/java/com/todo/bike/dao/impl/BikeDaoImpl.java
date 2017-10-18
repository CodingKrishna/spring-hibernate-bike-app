package com.todo.bike.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.bike.dao.BikeDao;
import com.todo.bike.model.BikeEntity;
import com.todo.bike.model.BookingHistoryEntity;

@Repository("bikeDaoImpl")
public class BikeDaoImpl implements BikeDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<BikeEntity> getBikesbyDate(Date date) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String q = "from BikeEntity where DELIVERY_DATE <= :date";
		Query query = session.createQuery(q);
		query.setParameter("date", date);
		List<?> list = (List<?>) query.list();
		BikeEntity bikeEntity;
		List<BikeEntity> listofBikesByDelveryDate = new ArrayList<BikeEntity>();
		for (int i = 0; i < list.size(); i++) {
			bikeEntity = (BikeEntity) list.get(i);
			listofBikesByDelveryDate.add(bikeEntity);
		}
		session.close();
		return listofBikesByDelveryDate;
	}

	public BikeEntity getBikebyBikeId(String bikeId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String q = "from BikeEntity where ID=:id";
		Query query = session.createQuery(q);
		query.setParameter("id", bikeId);
		BikeEntity bikeEntity = (BikeEntity) query.uniqueResult();
		session.close();
		return bikeEntity;
	}

	public void deleteBookeBike(BikeEntity bikeEntity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		trx.begin();
		session.delete(bikeEntity);
		trx.commit();
		session.close();
	}

	public void insertBookingHistory(BookingHistoryEntity bookingHistoryEntity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		trx.begin();
		session.save(bookingHistoryEntity);
		trx.commit();
		session.close();
	}

	public List<BookingHistoryEntity> bookingHistory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String q = "from BookingHistoryEntity";
		List<BookingHistoryEntity> list = session.createQuery(q).list();
		//System.out.println("List of Booking History : "+list);
		session.close();
		return list; 
	}

	public List<BikeEntity> totalBikes() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String q = "from BikeEntity";
		List<BikeEntity> totalBikes = session.createQuery(q).list();
		session.close();
		return totalBikes;
	}
}
