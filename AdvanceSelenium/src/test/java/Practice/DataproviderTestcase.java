package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTestcase {
  @Test(dataProvider="dataprovider_test")
	public void booking(String src, String dest) {
		
	  System.out.println("Book ticket from  "+src+" to "+dest+" ");
		
	}
	@DataProvider
	public Object[][] dataprovider_test()
	{
		Object[][] objArr = new Object[5][2];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="Delhi";
		
		objArr[3][0]="Bangalore";
		objArr[3][1]="Mumbai";
		
		objArr[4][0]="Bangalore";
		objArr[4][1]="Manali";
		
		return objArr;
		//pushed
		
	}


}
