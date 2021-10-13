package Utils;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	/*
	 *  Create a Function to get Row Count
	 *  Create a Function to get Column count
	 *  Create a Function to get String cell data
	 *  Create a Function to get number cell data
	 * 
	 */
	XSSFWorkbook workbook;
	static XSSFSheet sheet;
	File excelFile;
	Row row;
	Cell cell;
	public ExcelUtils(String excelWorkBookName,String excelSheetName) {
		String filePath=System.getProperty("user.dir");
		System.out.println("Excel sheet file path"+filePath);
		filePath=filePath+"/src/test/resources"+excelSheetName+".xlsx";
		try {
			workbook=new XSSFWorkbook(filePath);
			sheet=workbook.getSheet(excelSheetName);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}
	public static void getRowCount() {
		try {
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Total rows is "+ rowCount);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}
	public static void getColCount() {
		try {
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total Column is "+colCount);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}
}
