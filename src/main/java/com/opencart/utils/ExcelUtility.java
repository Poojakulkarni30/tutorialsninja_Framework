package com.opencart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	public CellStyle style;
	public String path;

	public ExcelUtility(String path) {

		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;

	}

	public int getCellCount(String sheetname, int rowNum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;

	}

	public String getCellData(String sheetname, int rownum, int cellNum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellNum);
		String data;
		DataFormatter formatter = new DataFormatter();

		try {
			data = formatter.formatCellValue(cell);

		}

		catch (Exception e) {

			data = "";
		}

		workbook.close();
		fi.close();
		return data;
	}

	public void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {

		File xlfile = new File(path);
		if (!xlfile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);

		}
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		if (workbook.getSheetIndex(sheetName) == -1)

			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rowNum) == null)

			sheet.createRow(rowNum);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.close();
		fi.close();
		fo.close();

	}

	public void fillGreenColor(String sheetName, int rowNum, int cellNum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();

	}

	public void fillRedColor(String sheetName, int rowNum, int cellNum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}
}
