package com.qa.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestApplication {

	public static void main(String[] args) throws IOException{
		File src=new File("D:\\CoalAutomationWorkspace\\TestApp\\src\\main\\java\\com\\qa\\testdata\\CoalTestData2.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
	    XSSFSheet sheet1= wb.getSheetAt(0);
	    int rowCount=sheet1.getLastRowNum();
	    System.out.println(rowCount);
	    
	    for(int i=0;i<=rowCount;i++){
	    	String data1=sheet1.getRow(i).getCell(0).getStringCellValue();
	    	System.out.println(""+i+""+data1);
	    	
	    }
	  // String data= sheet1.getRow(0).getCell(0).getStringCellValue();
	  // System.out.println(data);
	}
	
	public String getData(String sheetname,int row,int col){
		sheet1.
	}

}
