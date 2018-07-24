package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BasicTestNGExample {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am from before test method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("I am from after test method 'f'");
	}
	
	@Test
	public void z() {
		System.out.println("from z method");
	}
	
	@Test
	public void f() {
		System.out.println("I am from test method 'f'");
	}	
	
	@Test
	public void method1() {
		System.out.println("Advanced for the first step");
	}
	
	@Test
	public void method4() {
		System.out.println("fourth");
	}
	
	@Test
	public void method2() {
		System.out.println("second");
	}
	
	@Test
	public void method3() {
		System.out.println("third");
	}
	
	@Test
	public void method5() {
		System.out.println("fifth");
	}
	
	@Test
	public void method6() {
		System.out.println("sixth");
	}
	
	@Test
	public void method7() {
		System.out.println("seven");
	}
	
	@Test
	public void method8() {
		System.out.println("eight");
	}
	
	@Test
	public void method9() {
		System.out.println("nine");
	}
	
	@Test
	public void method10() {
		System.out.println("ten");
	}


}
