package core;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtilsExample {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	 XSSFCell cell;
	static File file;
	static String filePath;
	String workbookName;
	String sheetName;
	LinkedHashMap<String,List<String>> cellData;
	public ExcelUtilsExample(String workbookname,String sheetname) {
		this.workbookName=workbookname;
		this.sheetName=sheetname;
	}
	
	public XSSFWorkbook getWorkbook() {
		filePath="src/test/resources/"+this.workbookName+".xlsx";
		try {
		file=new File(filePath);
		if(file.exists()) {
			//System.out.println(filePath);
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
		finally {
			file=null;
			try {
				workbook.close();
				workbook=null;
			}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
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
	public int getRows() {
		return getSheet().getPhysicalNumberOfRows();
	}
	public int getColumn() {
		return getSheet().getRow(0).getPhysicalNumberOfCells();
	}
	public LinkedHashMap<String,List<String>> getColumnData(int columnNo){
		int rows=getRows();
		cellData=new LinkedHashMap<String,List<String>>();
		List<String> list=new ArrayList<String>();
		for(int i=1;i<rows;i++) {
			cell=getSheet().getRow(i).getCell(columnNo);
			CellType cellType=cell.getCellType();
			switch(cellType) {
			case NUMERIC:
				if(cell.getNumericCellValue()!=0 && DateUtil.isCellDateFormatted(cell))
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					Date dt=cell.getDateCellValue();
					String curDate=df.format(dt);
					list.add(curDate);
				
				}
				else
					list.add(String.valueOf(cell.getNumericCellValue()));
				break;
			case STRING:
				list.add(cell.getStringCellValue());
				break;
			case BOOLEAN:
				list.add(String.valueOf(cell.getBooleanCellValue()));
				break;
			case BLANK:
				break;
			case ERROR:
				break;
			case FORMULA:
				break;
			case _NONE:
				break;
			default:
				break;
			}
			
		}
		cellData.put(sheet.getRow(0).getCell(0).getStringCellValue(), list);
		return cellData;
	}
	public List<String> getRowData(int rowNo){
		return null;
	}
}
