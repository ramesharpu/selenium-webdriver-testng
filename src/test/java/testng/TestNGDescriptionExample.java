package testng;

import org.testng.annotations.Test;

public class TestNGDescriptionExample {
  @Test(description = "Sample description for this test method")
  public void f() {
	  //this method is going to do something in test
	  System.out.println("You are awesome");
  }
  
  @Test(description = "EST-134")
  public void f1() {
	  //this method is going to do something in test
	  System.out.println("You are awesome");
  }
}
