package com.Locators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class ExcelFileUtil 
{
	
Workbook wb;
	public  ExcelFileUtil(String excelpath) throws EncryptedDocumentException, IOException 
	{

		FileInputStream fi=new FileInputStream(excelpath);
		wb=WorkbookFactory.create(fi);
	}
	public int rowCount(String Sheetname) 
	{
	return wb.getSheet(Sheetname).getLastRowNum();
	}
	public int colCount(String Sheetname) 
	{
	return wb.getSheet(Sheetname).getRow(0).getLastCellNum();
	}
	public String getCellData(String Sheetname,int row ,int column) 
	{
		String data=" ";
		if(wb.getSheet(Sheetname).getRow(row).getCell(column).getCellType()==CellType.NUMERIC) 
		{
			int celldata=(int)wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		else 
		{
			data=wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
		
	}
	
		public void setCellData(String sheetname, int row, int column, String status, String excelresult) throws Throwable
		{
			Sheet ws=wb.getSheet(sheetname);
			Row rownum =ws.getRow(row);
			Cell cell=rownum.createCell(column);
			cell.setCellValue(status);
            if (status.equalsIgnoreCase("Pass"))
            {
            	CellStyle Style=wb.createCellStyle();
            	Font font=wb.createFont();
            	font.setColor(IndexedColors.GREEN.getIndex());
            	font.setBold(true);
            	Style.setFont(font);
            	rownum.getCell(column).setCellStyle(Style);
            }else if(status.equalsIgnoreCase("Fail"))
            {
            	CellStyle style=wb.createCellStyle();
            	Font font=wb.createFont();
            	font.setColor(IndexedColors.RED.getIndex());
            	font.setBold(true);
            	style.setFont(font);
            	rownum.getCell(column).setCellStyle(style);
            }
  
            FileOutputStream fo=new FileOutputStream(excelresult);
            wb.write(fo);
            }
	}




			

