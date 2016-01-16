package test_framework;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class Datap {
	
	@DataProvider(name="dp")
	public static  Iterator<String[]> getData() throws Exception{
	
		ExcelRW ex = new ExcelRW();
		ex.WorkbookInitialize("E:\\Calcsum.xlsx");
		XSSFSheet sheet1= ex.setSheet("Sheet1");
		int xRow=ex.rowCount(sheet1);
		
		List<String[]> l1 = new ArrayList<String[]>();
		for(int iRow = 1 ; iRow <= xRow ;iRow++){
			
			String[] arr = new String[3];
			arr[0] = ex.readCell(sheet1, iRow, 0);
			arr[1] = ex.readCell(sheet1, iRow, 1);
			arr[2] = ex.readCell(sheet1, iRow, 2);
			
			l1.add(arr);
			
		}
		
		return l1.iterator();
		
		
	}

}
