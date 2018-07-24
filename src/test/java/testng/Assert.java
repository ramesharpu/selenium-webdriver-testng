package testng;

import static org.testng.Assert.assertTrue;

//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import org.testng.asserts.*;

public class Assert {

	@Test
	public void softAssert(){
		SoftAssert softAssertion= new SoftAssert();
		System.out.println("softAssert Method Was Started");
		softAssertion.assertTrue(false);
		System.out.println("softAssert Assert True Method Was Executed");
		softAssertion.assertFalse(true);
		System.out.println("softAssert Assert False Method Was Executed");
		System.out.println("Calling the assert all method");
		softAssertion.assertAll();
		System.out.println("Done");
	}
	
	@Test
	public void hardAssert(){
		System.out.println("hardAssert Method Was Started");
		assertTrue(false);
		System.out.println("hardAssert Method Was Executed");
	}
}