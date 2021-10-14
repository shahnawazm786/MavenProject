package core;

import java.io.File;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsExample {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static File file;
	static String filePath;
	String workbookName;
	String sheetName;
	public void ExcelUtilExample(String workbookname,String sheetname) {
		this.workbookName=workbookname;
		this.sheetName=sheetname;
	}
	public XSSFWorkbook getWorkbook() {
		filePath="src/test/resources/"+this.workbookName+".xlsx";
		try {
		file=new File(filePath);
		if(file.exists()) {
			System.out.println(filePath);
			workbook=new XSSFWorkbook(file);
			return workbook;
		}// END OF IF BLOCK
		}// END OF TRY BLOCK
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			System.out.println();
			ex.getStackTrace();
		}// END OF CATCH BLOCK
		return workbook;
	}
	public XSSFSheet getSheet() {
		try {
		sheet=getWorkbook().getSheet(this.sheetName);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			System.out.println();
			ex.getStackTrace();
		}
		return sheet;
	}
	public int getRowCount() {
		return getSheet().getPhysicalNumberOfRows();
	}
	public int getColumnCount() {
		return getSheet().getRow(0).getPhysicalNumberOfCells();
	}
	public List<String> getDatByColumns(int columns) {
		return null;
	}
}
