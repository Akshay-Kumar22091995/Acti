package co.actitime.genricLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataSuppier {
	
	public String getDataFromProperty(String key) throws  IOException {
		
		FileInputStream fis = new FileInputStream(IAutoConstant.PROPERTY_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	
	public String getDataFromExcel(String sheetname, int rowno, int colno) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IAutoConstant.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
		return value;
	}
	
	
	public void insertDataInExcel(String sheetname, int rowno, int colno, String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IAutoConstant.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetname).getRow(rowno).createCell(colno).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IAutoConstant.EXCEL_PATH);
		book.write(fos);
		fos.flush();
		fos.close();
	}
	
}
