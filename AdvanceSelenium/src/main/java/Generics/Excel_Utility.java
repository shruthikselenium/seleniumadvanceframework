package Generics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * this method is used to fetch the data from excel
	 * @param sheetname
	 * @param rownum
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExceldata(String sheetname,int rownum, int cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fes= new FileInputStream("./src/test/resources/data.xlsx");
	     Workbook wb=WorkbookFactory.create(fes);
	     Sheet sh= wb.getSheet(sheetname);
	     Row rw = sh.getRow(rownum);
	     Cell cl = rw.getCell(cell);
	     String value = cl.getStringCellValue();
		return value;
	     
	    /* DataFormatter format= new DataFormatter();
	     String data = format.formatCellValue(wb.getSheet(sheetname).getRow(rownum).getCell(cell));
	     return data;*/
		
	}
	/**
	 * fetching the  data from excel using dataformat
	 * @param sheetname
	 * @param rownum
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	 public String getExcelusingdataformat(String sheetname,int rownum, int cell) throws EncryptedDocumentException, IOException {
		 FileInputStream fes1= new FileInputStream("./src/test/resources/data.xlsx");
	     Workbook wb1=WorkbookFactory.create(fes1);
		 
	     DataFormatter format= new DataFormatter();
	     String data = format.formatCellValue(wb1.getSheet(sheetname).getRow(rownum).getCell(cell));
	     return data;
		 
 }
	 public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException
	 {
		 FileInputStream fis1 = new FileInputStream("./src/test/resources/data.xlsx");
		 Workbook book= WorkbookFactory.create(fis1);
		 
		 Sheet sh= book.getSheet(SheetName);
		 int  lastRow = sh.getLastRowNum()+1;
		 int lastCell=sh.getRow(0).getLastCellNum();
		 
		 Object[][] obj= new Object[lastRow][lastCell];
		 for (int i=0; i<lastRow; i++)
		 {
			 for(int j=0; j<lastCell; j++)
			 {
				 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			 }
		 }
		 
		return obj;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}