package com.app.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static void browserlaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VINOTH\\AIITE-workspace\\Project_Task1_Adactin\\Driver\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void url(String url) {
		driver.get(url);
	}

	public static WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement findElementByname(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement findElementByxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// abstract method
	public static WebElement findElementBy(By by) {
		return driver.findElement(by);
	}

	public static void typeData(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void press(WebElement element) {
		element.click();
	}
	//To get Text --- this method returns the innerText of an element
			public static String getText(By by) {
				return driver.findElement(by).getText();
			}
	
	public static void dropDownindex(WebElement element, int values) {
		Select s = new Select(element);
		s.selectByIndex(values);
	}

	public static void dropDownvalue(WebElement element, String values) {
		Select s = new Select(element);
		s.selectByValue(values);
	}

	public static void movetoElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static String getAttribute(WebElement element, String... attribute) {
		String text = attribute.length < 1 ? "value" : attribute[0];
		String attributevalue = null;
		try {
			attributevalue = text;
		} catch (NullPointerException e) {
			throw new RuntimeException("Warning : Failure detected when requesting the element property:value");
		}
		return attributevalue;
	}

	public static void screenShot() {

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,
					new File("location" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void impwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void expwait(WebElement element) {
		WebDriverWait exp = new WebDriverWait(driver, 10);
		exp.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void exetime() {
		Date date = new Date();
		System.out.println(date);
	}

	public void afterreport() {

	}

	public static String excelRead(int r, int c) {
		String value = null;
		try {
			File f = new File("C:\\Users\\VINOTH\\AIITE-workspace\\Project_Task1_Adactin\\src\\test\\resources\\TestData\\Adactin_Excel.xlsx");
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
	
	public static void excelwrite(int r, int c, String num) {

		try {
			File f = new File("C:\\Users\\VINOTH\\AIITE-workspace\\Project_Task1_Adactin\\src\\test\\resources\\TestData\\Test_Excel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet cs = wb.createSheet("Order_No");
			Row cr = cs.createRow(r);
			Cell cc = cr.createCell(c);
			cc.setCellValue(num);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String propertyFile(String value) {
		String data = null;
		try {
			File f = new File(
					"C:\\Users\\VINOTH\\AIITE-workspace\\Project_Task1_Adactin\\src\\test\\resources\\TestData\\Test.properties");
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

	public static void robotClearText() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);	
		r.keyPress(KeyEvent.VK_A);		
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_X);
	}
	public static void getChildWindow(int index) {
		Set<String> childwindow = driver.getWindowHandles();
		List<String> li = new ArrayList<String>(childwindow);
		driver.switchTo().window(li.get(index));
	}
	public static void doubleClick(WebElement target) {
		Actions action = new Actions(driver);
		action.doubleClick(target).build().perform();
	}

	public static String getText1(By findElementByxpath) {
		// TODO Auto-generated method stub
		return driver.findElement(findElementByxpath).getText();
	}

}
