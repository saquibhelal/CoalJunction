package com.qa.testcase;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String path){
		try{
			File src=new File(path);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			sheet1=wb.getSheetAt(0);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetName, int row,int col){
		String data=sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
