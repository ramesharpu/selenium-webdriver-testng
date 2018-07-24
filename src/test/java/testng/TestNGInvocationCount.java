package testng;

import org.testng.annotations.Test;

public class TestNGInvocationCount {
  @Test(invocationCount=5)
  public void f() {
	  System.out.println("wow");
  }
  
  @Test
  public void test() {
	  System.out.println("test");
	  
  }
}
