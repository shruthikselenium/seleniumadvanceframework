package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	@Test
	public void createcontact()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(false,true);
		System.out.println("Step5");
		System.out.println("Step6");
		soft.assertAll();
	}
	@Test
	public void modifyContact() {
		System.out.println("Step7");
		System.out.println("Step8");
	}
	

}
