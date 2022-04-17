package com.app.pageexecution;

import com.app.baseclass.BaseClass;
import com.app.locators.BookingPageLocator;
import com.app.locators.SearchHotelPageLocator;

public class BookingPageExecution extends SearchHotelPageExecution{
	public static void firstName() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.firstname), excelRead(1, 10));
	}
	public static void lastName() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.lastname), excelRead(1, 11));
	}
	public static void address() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.billingaddress), excelRead(1, 12));
	}
	public static void creditCardNo() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.creditcardno), excelRead(1, 13));
	}
	public static void cardType() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.creditcardtype), excelRead(1, 14));
	}
	public static void expiryMonth() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.expirydatemonth), excelRead(1, 15));
	}
	public static void expiryYear() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.expirydateyear), excelRead(1, 16));
	}
	public static void cvv() {
		BaseClass.typeData(BaseClass.findElementById(BookingPageLocator.cvvnumber), excelRead(1, 17));
	}
	public static void bookBtn() {
		BaseClass.press(BaseClass.findElementById(BookingPageLocator.bookbtn));
	}
	public static void orderId() {
		BaseClass.excelwrite(1, 0, BaseClass.getAttribute(BaseClass.findElementById(BookingPageLocator.orderid)));
		//String orderid = BaseClass.getAttribute(BaseClass.findElementById(BookingPageLocator.orderid));
		//System.out.println(orderid);
	}
}
