package com.app.basicfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reusable {

	public static String excelRead(int r, int c) {
		String value = null;
		try {
			File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\"
					+ "src\\test\\resources\\TestData\\Test_Excel.xlsx");
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

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yuvaraj\\eclipse-workspace\\Proect_Class_Apr\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys(excelRead(1,0));
	}
}
