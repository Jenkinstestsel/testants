package test_framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	FileInputStream fis;
	XSSFWorkbook wb;
	void WorkbookInitialize(String xpath) throws IOException{		
		
//		FILEINputStream
		fis = new FileInputStream(xpath);
//		Workbook
		wb = new XSSFWorkbook(fis);
				
	}
	
	XSSFSheet setSheet(String sName){
		
		XSSFSheet sheet = wb.getSheet(sName);
		return sheet;
		
	}
	
	int rowCount(XSSFSheet tsheet){
		int lastRowNum = tsheet.getLastRowNum();
		return lastRowNum;
	}
	
	int columnCount(XSSFSheet tsheet){
		int lastCellNum = tsheet.getRow(0).getLastCellNum();
		return lastCellNum;
		
	}
	
	String readCell(XSSFSheet tsheet,int row , int column){
		XSSFCell cell = tsheet.getRow(row).getCell(column);
		String celltext = "";
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING){
//			System.out.println("string");
			celltext = cell.getStringCellValue();
			
		}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
//			System.out.println("number");
			celltext = String.valueOf(cell.getNumericCellValue());
		}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
			celltext = "";
		}
			
		return celltext;
				
	}
	
	void writeCell(XSSFSheet tsheet,int row , int column,String writeVal){
		XSSFCell cellwrite = tsheet.getRow(row).getCell(column);
		cellwrite.setCellValue(writeVal);
	}
	
	void saveFile(String xPath) throws IOException{
		fis.close();
		
//		Save the file
		FileOutputStream fos = new FileOutputStream(xPath);
		wb.write(fos);
		fos.close();
	}	

}
