package com.car.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.Schema;

import com.car.book.Booking;
import com.car.book.CarPrice;
import com.car.business.Customer;
import com.car.business.Car;

public class CarUtil {
	
	
	
	public static boolean isDateOverlapped(Booking booking, LocalDate custFromDate, LocalDate custToDate)
	{
	    final LocalDate fromDate = booking.getFromDate();
	    final LocalDate toDate = booking.getToDate();
	    
	    if(!(custFromDate.isAfter(booking.getToDate()) || 
	    		custToDate.isBefore(booking.getFromDate())))
	    {
	    	return true;
	    }
	    return false;
	}

	
	
	public static double calculatePrice() {
		// TODO Auto-generated method stub
		CarPrice price = new CarPrice(false,false,true);
		return price.getFinalPrice();
	}
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}



	public static Customer getCustomerLogin() {
		// TODO Auto-generated method stub
		return null;
	}



	public static Car getCarDetails(String carId) {
		// TODO Auto-generated method stub
		return null;
	}



	public static String save(Booking booking) throws SQLException {
		
		boolean newBooking=false;
		List<Booking> bookingList = new ArrayList<>();
		
		try (Connection c = CarUtil.getConnection()) {
		    String sql = "insert into booking where location='";
		    		
		    PreparedStatement stmt = c.prepareStatement(sql);
		    		 newBooking = stmt.execute();
		    		 
		    

		
	}
		
		if(newBooking)
		{
			return "Booking success";
		}
		return "Booking failed...";
	}
	
}
