package com.qa.utility;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
  public static FileInputStream fileloc;
  public static XSSFWorkbook wBook;
  public static XSSFSheet wsheet;
  public static XSSFRow row;
  public static XSSFCell cell;
  
  // for getting row count
  public static int getRowCount(String xFile,String xSheet) throws IOException
  {
	  fileloc=new FileInputStream(xFile);
	  wBook=new XSSFWorkbook(fileloc);
	  wsheet=wBook.getSheet(xSheet);
	  int rowCount=wsheet.getLastRowNum();
	  return rowCount;
  }
  //for getting cell count
  public static int getCellCount(String xFile,String xSheet,int rowNum) throws IOException
  {
	  fileloc=new FileInputStream(xFile);
	  wBook=new XSSFWorkbook(fileloc);
	  wsheet=wBook.getSheet(xSheet);
	  row=wsheet.getRow(rowNum);
	  int cellCount=row.getLastCellNum();
	  return cellCount;
  }
  public static String getCellData(String xFile,String xSheet,int rowNum,int colNum) throws IOException
  {
	  fileloc=new FileInputStream(xFile);
	  wBook=new XSSFWorkbook(fileloc);
	  wsheet=wBook.getSheet(xSheet);
	  row=wsheet.getRow(rowNum);
	  cell=row.getCell(colNum);
	  DataFormatter formatter=new DataFormatter();
	  String cellData=formatter.formatCellValue(cell);
	  
	  
	  wBook.close();
	  fileloc.close();
	  return cellData;
  }
  
}
