package com.xforce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtils {
	FileInputStream eFile;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int sheetCount, rowCount, colCount;
	String excelData[][];
	
	public String[][] readExcelData(String sheetName) throws Exception {
		eFile=new FileInputStream("./\\TestData\\guru.xlsx");
		workbook=new XSSFWorkbook(eFile);
		sheetCount=workbook.getNumberOfSheets();
		for(int s=0;s<sheetCount;s++) {
			if(workbook.getSheetAt(s).getSheetName().equals(sheetName)) {
				sheet=workbook.getSheet(sheetName);
				rowCount=sheet.getLastRowNum();
				System.out.println(rowCount);
				row=sheet.getRow(1);
				colCount=row.getLastCellNum();
				excelData=new String[rowCount][colCount];
				for(int i=1;i<=rowCount;i++) {
					row=sheet.getRow(i);
					colCount=row.getLastCellNum();
					
				for(int j=0;j<colCount;j++) {
				
				if(row.getCell(j).getCellTypeEnum()==CellType.STRING) {
					excelData[i-1][j]=row.getCell(j).getStringCellValue();
				}
				else {
				excelData[i-1][j]=NumberToTextConverter.
						toText(row.getCell(j).getNumericCellValue());
				}
					
					}
				}
			}
		}
		/*for(int m=0;m<excelData.length;m++) {
			for(int n=0;n<excelData[m].length;n++) {
				System.out.print(excelData[m][n]+"::");
			}
			System.out.println("\n");
		}*/
		return excelData;
				
	}

}
