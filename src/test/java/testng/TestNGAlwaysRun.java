package testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestNGAlwaysRun {
  @Test
  public void test1() {
	  assertEquals(true, false);
	  System.out.println("Check for post assertion");
  }
  
  @Test(dependsOnMethods = {"test1"}, alwaysRun=true)
  public void test2() {
	  System.out.println("Runs despite test1 fails");
  }
}
