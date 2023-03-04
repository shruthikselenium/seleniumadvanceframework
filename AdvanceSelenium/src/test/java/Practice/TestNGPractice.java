package Practice;

import org.testng.annotations.Test;


public class TestNGPractice {
   
	@Test(priority=1)
	public void create()
	{
		System.out.println("Created ");
		//int[] arr = {1,2,3};
		//System.out.println(arr[5]);
	}
	
	@Test(invocationCount=3)
	public void modify() {
		System.out.println("Modify");
	}
	@Test(dependsOnMethods="create")
	public void delete()
	{
		System.out.println("Delete");
	}
}
