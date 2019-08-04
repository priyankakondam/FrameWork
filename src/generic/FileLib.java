package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains Methods to handle Excel and Property Files
 * @author Raghav
 *
 */
public class FileLib implements AutoConst {

	/**
	 * This Method is used to read the data from the WorkBook
	 * @param sheet
	 * @param r
	 * @param c
	 * @return excelValue
	 * @throws Throwable
	 */
	public String getCellData(String sheet, int r, int c) throws Throwable
	{
		FileInputStream readExcel=new FileInputStream(EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(readExcel);
String excelValue = workbook.getSheet(sheet).getRow(r).getCell(c).toString();
		return excelValue;
		
	}
	
	
	public int getRowCount(String sheet) throws Throwable
	{
		FileInputStream readExcel=new FileInputStream(EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(readExcel);
		int rowCount = workbook.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	
	
	/**
	 * This method is used to write the data into the workbook
	 * @param sheet
	 * @param r
	 * @param c
	 * @param data
	 * @throws Throwable
	 */
	public void setCellData(String sheet,int r, int c, String data) 
			throws Throwable
	{
		FileInputStream readExcel=new FileInputStream(EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(readExcel);
		Cell cell = workbook.getSheet(sheet).getRow(r).createCell(c);
		cell.setCellValue(data);
		FileOutputStream writeExcel=new FileOutputStream(EXCEL_PATH);
		workbook.write(writeExcel);
	}
	
	
	/**
	 * This method is used to get the value for a key from property File
	 * @param key
	 * @return propValue
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream readProp=new FileInputStream(PROPERTY_PATH);
		Properties prop=new Properties();
		prop.load(readProp);
		String propValue = prop.getProperty(key);
		return propValue;
	}
	
	
	
	
	
	
}
