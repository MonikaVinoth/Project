package com.app.basicfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adactin {

	//Excel Read
	private static CharSequence excelRead(int r, int c) {
		String value = null;
		try {
			File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\"
					+ "src\\test\\resources\\TestData\\Adactin_Excel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			// excel row size
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			// System.out.println(cell);
			// to identify the testdata type
			int cellType = cell.getCellType();
			if (cellType == 1) {
				 value = cell.getStringCellValue();
				System.out.println(value);
				// date and number seprate
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sc = new SimpleDateFormat("dd-MM-yyyy");
					 value = sc.format(dateCellValue);
					System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
				 value = String.valueOf(l);
					System.out.println(value);

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	//Prop Read
		public static String readProp(String value) {
			String data = null;
			try {
				File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\\"\r\n" + 
						"					+ \"src\\test\\resources\\TestData\\Test.properties");
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
		
		//Excel Write
		public static String excelwrite(int m,int n ,String num) {

			try {
				File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\\"\r\n" + 
						"					+ \"src\\test\\resources\\TestData\\Adactin_Excel.xlsx");
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet cs = wb.createSheet("Order_No");
				Row cr = cs.createRow(m);
				Cell cc = cr.createCell(n);
				cc.setCellValue(num);
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
				wb.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\Driver\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get(readProp("url"));
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.id("username")).sendKeys(readProp("username"));    // UserName
	    //driver.findElement(By.id("password")).sendKeys(readProp("password")); 
		driver.findElement(By.id("username")).sendKeys(excelRead(1,0));
		driver.findElement(By.id("password")).sendKeys(excelRead(1, 1));
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("location")).sendKeys(excelRead(1, 2));
		driver.findElement(By.id("hotels")).sendKeys(excelRead(1, 3));
		driver.findElement(By.id("room_type")).sendKeys(excelRead(1, 4));
		driver.findElement(By.id("room_nos")).sendKeys(excelRead(1, 5));
		driver.findElement(By.id("datepick_in")).sendKeys(excelRead(1, 6));
		driver.findElement(By.id("datepick_out")).sendKeys(excelRead(1, 7));
		driver.findElement(By.id("adult_room")).sendKeys(excelRead(1, 8));
		driver.findElement(By.id("child_room")).sendKeys(excelRead(1, 9));
		driver.findElement(By.id("Submit")).click();
		
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys(excelRead(1, 10));
		driver.findElement(By.id("last_name")).sendKeys(excelRead(1, 11));
		driver.findElement(By.id("address")).sendKeys(excelRead(1, 12));
		driver.findElement(By.id("cc_num")).sendKeys(excelRead(1, 13));
		driver.findElement(By.id("cc_type")).sendKeys(excelRead(1, 14));
		driver.findElement(By.id("cc_exp_month")).sendKeys(excelRead(1, 15));
		driver.findElement(By.id("cc_exp_year")).sendKeys(excelRead(1, 16));
		driver.findElement(By.id("cc_cvv")).sendKeys(excelRead(1,17));                                
	    driver.findElement(By.id("book_now")).click();
	}

	

}
