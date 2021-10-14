package core;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			File file=new File("F://Excel//Test.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getPhysicalNumberOfRows();
		System.out.println("No of Rows "+row);
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of Columns "+col);
		//LinkedHashMap<String,List<String>> map=new LinkedHashMap<String, List<String>>();
		//List<String> data=new ArrayList<String>();
		XSSFCell cell;
		for(int i=0; i<row;i++) {
			for(int j=0;j<col;j++) {
				//XSSFCell cell=sheet.getRow(1).getCell(j).getCellType();
				cell=sheet.getRow(i).getCell(j);
				CellType type=cell.getCellType();
				switch(type) {
				
				case NUMERIC:
					if(cell.getNumericCellValue()!=0 && DateUtil.isCellDateFormatted(cell))
					{
						DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
						Date dt=cell.getDateCellValue();
						String curDate=df.format(dt);
						System.out.println("Date - "+curDate);
		//				data.add(curDate);
					}
					else
						System.out.println(cell.getNumericCellValue());
			//			data.add(String.valueOf(cell.getNumericCellValue()));
					break;
				case STRING:
					System.out.println("Value is "+cell.getStringCellValue());
		//			data.add(cell.getStringCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
	//				data.add(String.valueOf(cell.getBooleanCellValue()));
					break;
				case _NONE:
	//				data.add("None");
					System.out.println("None");
					break;
				case ERROR:
					System.out.println(cell.getErrorCellString());
	//				data.add(cell.getErrorCellString());
					break;
				case BLANK:
					System.out.println("Blank");
	//				data.add("Blank");
					break;
				case FORMULA:
					System.out.println(cell.getCellFormula());
	//				data.add(cell.getCellFormula());
					break;
				
				} //end of switch case
				
			} // end of inner loops
			
			}//end outer loop
		
		//System.out.println("-----------------Print the data of Map-----------------");
	//	System.out.println(map);
//		System.out.println("----------------- Key ----------------");
//		System.out.println(map.keySet());
//		System.out.println("----------------Value of key set--------------------");
//		System.out.println(map.get("Date"));
		
		}// end of try
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}//end of catch

	}//end of main()


} // end of class
