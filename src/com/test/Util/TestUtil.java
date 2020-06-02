package com.test.Util;

import java.util.ArrayList;

import com.excel.Utility.Xls_Reader;

public class TestUtil {
	public static Xls_Reader r;
	public static ArrayList<Object[]> getDataFromExcel(){
	ArrayList<Object[]> data= new ArrayList<Object[]>();
	try {
		r=new Xls_Reader("C:\\Users\\Mashuda\\eclipse-workspace\\SeleniumProject\\TestNGProject\\src\\com\\TestUtil\\Book1.xlsx");
		
	}
    catch(Exception e) {
    	e.printStackTrace();
    }
	for(int rn=2; rn<=r.getRowCount("Sheet1");rn++) {
		String UserId=r.getCellData("Sheet1", "UserId", rn);
		String Password=r.getCellData("Sheet1", "Password", rn);
		Object ob[]= {UserId,Password};
		data.add(ob);
		
	}
	return data;
}
}
