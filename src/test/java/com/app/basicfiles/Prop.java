package com.app.basicfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Prop {

	public static void readprop() {

		try {
			File f = new File(
					"C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\src\\test\\resources\\TestData\\Test.properties");
			FileReader read = new FileReader(f);
			Properties prop = new Properties();
			prop.load(read);
			prop.getProperty("username");
			System.out.println(prop.getProperty("username"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String reusable(String value) {
		String data = null;
		try {
			File f = new File(
					"C:\\Users\\Yuvaraj\\eclipse-workspace\\Proect_Class_Apr\\src\\test\\resources\\TestData\\Test.properties");
			FileReader read = new FileReader(f);
			Properties prop = new Properties();
			prop.load(read);
			data = (String) prop.getProperty(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {
		reusable("username");
	}
}
