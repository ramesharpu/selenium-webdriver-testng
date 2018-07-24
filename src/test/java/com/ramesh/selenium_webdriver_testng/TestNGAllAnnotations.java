package com.ramesh.selenium_webdriver_testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAllAnnotations {
  
  
  public void testMethod1() {
	  System.out.println("This is from test method 1");
  }
  
  @Test
  public void testMethod2() {
	  testMethod1();
	  System.out.println("This is from test method 2");
  }
  
  @Test
  @Parameters({ "username", "password"})
  public void testMethod3(String username, String password) {
	  System.out.println(" This is from Parameters, parameters are ==> username = " + username + " and password = " + password);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is from before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is from after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is from before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is from after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is from before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is from after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is from before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is from after suite");
  }

}
