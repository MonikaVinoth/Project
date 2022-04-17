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

public class ExcelRead {
	
	public static void excelRead() {
			
			try {
				File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\"
						+ "src\\test\\resources\\TestData\\Test_Excel.xlsx");
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet sheet = wb.getSheet("Sheet1");
				Row row = sheet.getRow(2);
				Cell cell = row.getCell(0);
				System.out.println(cell);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	
	public static void excelReadAlldatas() {
		
		try {
			File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\\"\r\n" + 
					"						+ \"src\\test\\resources\\TestData\\Test_Excel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			// excel row size
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < physicalNumberOfRows; i++) {
				Row row = sheet.getRow(i);
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				for (int j = 0; j < physicalNumberOfCells; j++) {
					Cell cell = row.getCell(j);
					System.out.println(cell);
				}
				
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
}
	
public static void excelReadCellType() {
		
		try {
			File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\\"\r\n" + 
					"						+ \"src\\test\\resources\\TestData\\Test_Excel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			// excel row size
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < physicalNumberOfRows; i++) {
				Row row = sheet.getRow(i);
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				for (int j = 0; j < physicalNumberOfCells; j++) {
					Cell cell = row.getCell(j);
					//System.out.println(cell);
					// to identify the testdata type
					int cellType = cell.getCellType();
					if(cellType==1) {
						String value = cell.getStringCellValue();
						System.out.println(value);
						// date and number seprate 
					}else if(cellType==0) {
						if(DateUtil.isCellDateFormatted(cell)) {
							Date dateCellValue = cell.getDateCellValue();
							SimpleDateFormat sc = new SimpleDateFormat("dd-MM-yyyy");
							String value = sc.format(dateCellValue);
							System.out.println(value);
						}else {
							double numericCellValue = cell.getNumericCellValue();
							long l = (long)numericCellValue;
							String value = String.valueOf(l);
							System.out.println(value);
							
						}
					}
					
					
				}
				
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
}
	
	public static void main(String[] args) {
		excelReadCellType();
	}

}
