package com.car.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.car.book.Booking;
import com.car.business.Car;
import com.car.business.Customer;
import com.car.util.CarUtil;

public class CarService {

	
public List<Booking> getAllCar(String location, LocalDate custFromDate, LocalDate custToDate ) 
		throws SQLException{
		
		
		List<Booking> availableCars = new ArrayList<>();
		Booking booking;
		try (Connection c = CarUtil.getConnection()) {
		    String sql = "select carId, from_date, to_date from booking where location='"
		    		+location
		    		+"'";
		 
		    try (PreparedStatement stmt = c.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		            booking = new Booking();
		            booking.setCarId(rs.getString("CARID"));
		            booking.setFromDate(rs.getDate("FROM_DATE").toLocalDate());
		            booking.setToDate(rs.getDate("TO_DATE").toLocalDate());
		            if(!CarUtil.isDateOverlapped(booking, custFromDate, custToDate))
		            {
		            	booking.setPrice(CarUtil.calculatePrice());
		            	availableCars.add(booking);
		            }
		        }
		    }
		}
		
		return availableCars;
	}

	
	public String bookMyCar(String carId, LocalDate fromDate, LocalDate toDate) throws SQLException
	{
		Customer customer = CarUtil.getCustomerLogin();
		Car car = CarUtil.getCarDetails(carId);
		Booking booking = new Booking();
		booking.setCarId(carId);
		booking.setCustomerId(customer.getCustId());
		booking.setFromDate(fromDate);
		booking.setToDate(toDate);
		booking.setPrice(car.getPrice());
		
		return CarUtil.save(booking);
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		CarService service = new CarService();
		
		Car car = new Car();
		car.setCarId("1");
		car.setCarName("Mercedes Benz");
		car.setPickUpLocation("Quincy, MA");
		car.setCarType("SUV");
		car.setPrice(100);
		
		Customer customer = new Customer();
		customer.setCustId("91");
		customer.setCustName("RajRajRaj");
		customer.setEmail("abc@gmail.com");
		
		
		List availableCars = service.getAllCar("Quincy, MA", LocalDate.of(2019, Month.JANUARY, 1),
				LocalDate.of(2019, Month.JANUARY, 5));
		
		
		
		
		

	}

}
