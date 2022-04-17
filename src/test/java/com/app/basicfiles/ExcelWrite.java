package com.app.basicfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void excelwrite() {

		try {
			File f = new File("C:\\Users\\VINOTH\\Desktop\\MonikaDocuments\\AIITE\\Project\\Proect_Class_Apr\\"
					+ "src\\test\\resources\\TestData\\Test_Excel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet cs = wb.createSheet("Aiite");
			Row cr = cs.createRow(0);
			Cell cc = cr.createCell(0);
			cc.setCellValue("Java");
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void excelupdate() {

		try {
			File f = new File("C:\\Users\\Yuvaraj\\eclipse-workspace\\Proect_Class_Apr"
					+ "\\src\\test\\resources\\TestData\\Test_Excel.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet cs = wb.getSheet("Aiite");
			Row cr = cs.getRow(0);
			Cell cc = cr.getCell(0);
			String cell = cc.getStringCellValue();
			if(cell.equals("Java")) {
				cc.setCellValue("Phyton");
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			wb.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		excelupdate();
	}

}
