package core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook("F://Excel//Test.xlsx");
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getPhysicalNumberOfRows();
		System.out.println("No of Rows "+row);
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of Columns "+col);
		for(int i=0; i<row;i++) {
			for(int j=0;j<col;j++) {
				//XSSFCell cell=sheet.getRow(1).getCell(j).getCellType();
				XSSFCell cell=sheet.getRow(i).getCell(j);
				CellType type=cell.getCellType();
				switch(type) {
				
				case NUMERIC:
					if(cell.getNumericCellValue()!=0 && DateUtil.isCellDateFormatted(cell))
					{
						DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
						Date dt=cell.getDateCellValue();
						String curDate=df.format(dt);
						System.out.println("Date - "+curDate);
					}
					else
						System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println("Value is "+cell.getStringCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case _NONE:
					System.out.println("None");
					break;
				case ERROR:
					System.out.println(cell.getErrorCellString());
					break;
				case BLANK:
					System.out.println("Blank");
					break;
				case FORMULA:
					System.out.println(cell.getCellFormula());
					break;
				
				}
			}
		}
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}

	}

}
