package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generics.Excel_Utility;

public class DataProviderExcel {
	@Test(dataProvider="getData")
	public void readData(String from,String to)
	{
		System.out.println(from+"-------------"+to);
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Excel_Utility elib1= new Excel_Utility();
		Object[][] value = elib1.readMultipleData("getdata");
		return value;
		
	}

}
