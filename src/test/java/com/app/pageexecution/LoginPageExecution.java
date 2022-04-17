package com.app.pageexecution;

import com.app.baseclass.BaseClass;
import com.app.locators.LoginPageLocators;

public class LoginPageExecution extends LoginPageLocators {
	public static void username() {
		BaseClass.typeData(BaseClass.findElementById(LoginPageLocators.username), BaseClass.propertyFile(username));
	}
	public static void password() {
		BaseClass.typeData(BaseClass.findElementById(LoginPageLocators.password), BaseClass.propertyFile(password));
	}
	public static void login() {
		BaseClass.press(BaseClass.findElementById(LoginPageLocators.login));
	}
}
