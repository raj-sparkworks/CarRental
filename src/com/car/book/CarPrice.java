package com.car.book;

public class CarPrice {
	
	private String carId;
	private double price;
	//
	private boolean isPremiumCustomer=false;
	private boolean isLongWeekEnd=false;
	private boolean isWeekEnd=false;
	
	public CarPrice()
	{
		
	}
	
	public CarPrice(boolean isPremiumCustomer, boolean isLongWeekEnd, boolean isWeekEnd)
	{
		if(isPremiumCustomer)
		{
			//Provide more discount
			double discount=priceDiscount();
			this.price=price-discount;
		}
		if(isLongWeekEnd)
		{
			double charges=getLongWeekEndCharges();
			this.price=price+charges;
					
		}
		if(isWeekEnd)
		{
			double charges=getWeekEndCharges();
			this.price=price+charges;
		}
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public double getPrice() {
		return price;
	}

/*	public void setPrice(double price) {
		this.price = price;
	}
*/
	
	public double priceDiscount()
	{
		//If the customer is premium customer, provide discount
		//Discount calculation has to be done here
		return 0;
	}
	
	private double getWeekEndCharges() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getLongWeekEndCharges() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getFinalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
