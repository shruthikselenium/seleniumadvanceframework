package Generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property_Utility {
	/**
	 * this method is used to login to application
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getKeyvalue(String key) throws IOException {
		
		FileInputStream fis= new FileInputStream("./src/test/resources/commdata.properties.txt");
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		
		return value;
		
	}
	


}
