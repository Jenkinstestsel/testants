package test_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestScript {

	
	@Test(dataProvider = "dp" , dataProviderClass = test_framework.Datap.class)
	public void sum(String a,String b,String c){
		
		SoftAssert s1 = new SoftAssert();
		double sum = Double.parseDouble(a) + Double.parseDouble(b);
		s1.assertEquals(sum,Double.parseDouble(c) );		
		
		System.out.println("hi");
		s1.assertAll();
		
	}
	
	
	
	
	
}
