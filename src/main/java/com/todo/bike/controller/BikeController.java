package com.todo.bike.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.bike.dto.BikeDto;
import com.todo.bike.dto.BookingHistoryDto;
import com.todo.bike.model.BikeEntity;
import com.todo.bike.model.BookingHistoryEntity;
import com.todo.bike.service.BikeService;

@Controller
public class BikeController {
	
	@Autowired
	@Qualifier("bikeServiceImpl")
	BikeService bikeService; 
	
	@RequestMapping("/getLoginPage")
	public String getLoginPage() {
		System.out.println("GetLoginPage");
		return "loginPage";
	}
	
	@RequestMapping(value = "/doLogin")
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName.equals("suresh") && password.equals("suresh")) {
			return new ModelAndView("bikeHome","bikeDto",new BikeDto());
		}
		else {
			return new ModelAndView("errorPage","message","Sorry! UserName or Password are Incorrect!");
		}
	}
	
	/*@RequestMapping("getBikesbyDate")
	public ModelAndView getBikesbyDate(@ModelAttribute("bikeDto") BikeDto bikeDto) {
		Date date = bikeDto.getDate();
		System.out.println(date);
		List<BikeEntity> bikes = bikeService.getBikesbyDate(date);
		ModelAndView mv = new ModelAndView("dispalyBikeList");
		mv.addObject("bikesList",bikes);
		return mv;
	}*/
	
/*	@RequestMapping("getBikes")
	public @ResponseBody List<BikeEntity> getBikes(@ModelAttribute("bikeDto") BikeDto bikeDto) throws IOException {
		Date date = bikeDto.getDate();
		//System.out.println(date);
		List<BikeEntity> bikes = bikeService.getBikesbyDate(date);
		ModelAndView mv = new ModelAndView();
		mv.addObject("bikeList", bikes);
		return bikes;
	}*/
	
	@RequestMapping("bookBike")
	public ModelAndView bookBike(@ModelAttribute("bikeDto") BikeDto bikeDto,@ModelAttribute("bookingHistoryDto") BookingHistoryDto bookingHistoryDto,HttpServletRequest request) {
		String bikeId = request.getParameter("bikeId");
		
		bikeDto = bikeService.getBikebyBikeId(bikeId);
		
		long time = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(time);
		
		bookingHistoryDto.setBikeId(bikeDto.getId()); 
		bookingHistoryDto.setBikeName(bikeDto.getName());
		bookingHistoryDto.setBikeModel(bikeDto.getModel());
		bookingHistoryDto.setPrice(bikeDto.getPrice());
		bookingHistoryDto.setDeliveryDate(bikeDto.getDate());
		
		bookingHistoryDto.setBookingDate(currentDate); 
		
		HttpSession session = request.getSession();
		session.setAttribute("bikeDto", bikeDto);
		System.out.println("Session value : "+session.getAttribute("bikeDto"));
		
		ModelAndView mv = new ModelAndView("bikeBookingPage");
		mv.addObject("bookingHistoryDto", bookingHistoryDto);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("bookingHistoryDto", bookingHistoryDto);
		
		return mv;
	}
	
	@RequestMapping("bookingSuccess")
	public ModelAndView bookingSuccess(@ModelAttribute("bookingHistoryDto") BookingHistoryDto bookingHistoryDto,HttpServletRequest request) {
	/*
		HttpSession session = request.getSession();
		bookingHistoryDto = (BookingHistoryDto) session.getAttribute("bookingHistoryDto"); 
		session.invalidate();
		System.out.println(bookingHistoryDto);
    */
		HttpSession session = request.getSession();
		BikeDto bikeDto = (BikeDto) session.getAttribute("bikeDto");
		
		System.out.println(bikeDto);
		
		bikeService.insertBookingHistory(bookingHistoryDto);
		bikeService.deleteBookeBike(bikeDto);
		
		session.invalidate();
		
		System.out.println("after session.invalidate() : "+bikeDto);
		ModelAndView mv = new ModelAndView("bookingSuccessPage");
		mv.addObject("bookingHistoryDto", bookingHistoryDto);
		return mv;
	}
	
	@RequestMapping("bookingHistory")
	public ModelAndView bookingHistory() {
		List<BookingHistoryEntity> list = bikeService.bookingHistory();
		ModelAndView mv = new ModelAndView("bookingHistory");
		mv.addObject("bookingHistoryList", list);
		return mv;
	}
	
	@RequestMapping(value = "getBikesbyDate", method = RequestMethod.GET)
	//@ResponseBody
	public ModelAndView getBikesbyDate(@RequestParam("searchDate") String searchDate) {
		//System.out.println("BikeController.getBikesbyDate()");
		//System.out.println(searchDate);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {

			 date = formatter.parse(searchDate);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(date.getTime());
		List<BikeEntity> bikes = bikeService.getBikesbyDate(sql);
		System.out.println("bikes::"+bikes);
		ModelAndView mv = new ModelAndView("dispalyBikeList");
		if(bikes != null && bikes.size() >0){
			mv.addObject("bikesList",bikes);
		}
		
		return mv;
	}
	
	@RequestMapping("totalBikes")
	public ModelAndView totalBikes() {
		List<BikeEntity> totalBikes= bikeService.totalBikes();
		ModelAndView mv = new ModelAndView("totalBikes");
		mv.addObject("totalBikes", totalBikes);
		return mv;
	}
	
}
