package com.opencart.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.opencart.utils.ExcelUtility;

public class TestDataProviders {

	
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException{
		
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalRows= xlutil.getRowCount("Sheet1");
		int totalCells= xlutil.getCellCount("Sheet1", 1);
		String logindata [][]= new String [totalRows][totalCells];
		
		for(int r=1; r<totalRows; r++) {
			
			
			for(int c=0; c<totalCells; c++) {
				
				
				logindata[r-1][c]=xlutil.getCellData("Sheet1", r, c);
			}
		}
		return logindata;
	}
	
}
