package com.app.pageexecution;

import com.app.baseclass.BaseClass;
import com.app.locators.SearchHotelPageLocator;

public class SearchHotelPageExecution extends LoginPageExecution{
	public static void location() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.location), excelRead(1, 2));
	}
	public static void hotels() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.hotels), excelRead(1, 3));
	}
	public static void roomType() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.roomType), excelRead(1, 4));
	}
	public static void numberOfRooms() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.numberOfRooms), excelRead(1, 5));
	}
	public static void checkInDate() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.checkInDate), excelRead(1, 6));
	}
	public static void checkOutDate() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.checkOutDate), excelRead(1, 7));
	}
	public static void adults() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.adultsPerRoom), excelRead(1, 8));
	}
	public static void children() {
		BaseClass.typeData(BaseClass.findElementById(SearchHotelPageLocator.childrenPerRoom), excelRead(1, 9));
	}
	public static void search() {
		BaseClass.press(BaseClass.findElementById(SearchHotelPageLocator.searchbtn));
	}
	public static void radiobtn() {
		BaseClass.press(BaseClass.findElementById(SearchHotelPageLocator.radiofieldselect));
	}
	public static void continuebtn() {
		BaseClass.press(BaseClass.findElementById(SearchHotelPageLocator.continuebtn));
	}
}
