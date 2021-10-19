package core;

import java.util.LinkedHashMap;
import java.util.List;

public class ExceUtilDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelUtilsExample eue=new ExcelUtilsExample("UserPassword","Sheet1");
		LinkedHashMap<String,List<String>> data=eue.getColumnData(0);
		System.out.println(data);
		LinkedHashMap<String,List<String>> data1=eue.getColumnData(1);
		System.out.println(data1);
		LinkedHashMap<String,List<String>> data2=eue.getColumnData(1);
		System.out.println(data2);
		
	}

}
