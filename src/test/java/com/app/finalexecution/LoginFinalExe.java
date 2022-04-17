package com.app.finalexecution;

import com.app.baseclass.BaseClass;
import com.app.pageexecution.BookingPageExecution;
import com.app.pageexecution.SearchHotelPageExecution;

public class LoginFinalExe extends BookingPageExecution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseClass.browserlaunch();
		BaseClass.url("https://adactinhotelapp.com/");
		username();
		password();
		login();
		location();
		hotels();
		roomType();
		numberOfRooms();
		checkInDate();
		checkOutDate();
		adults();
		children();
		search();
		radiobtn();
		continuebtn();
		firstName();
		lastName();
		address();
		creditCardNo();
		cardType();
		expiryMonth();
		expiryYear();
		cvv();
		bookBtn();
		orderId();
	}

}
