package testng;

import org.testng.annotations.Test;

public class TestNGTimeOut {
	//Test case fails after 10 the timeout
	@Test(timeOut = 10000)
	public void infinity() {
		while (true);
	}
}
