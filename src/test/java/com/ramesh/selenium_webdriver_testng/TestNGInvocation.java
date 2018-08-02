import org.testng.annotations.Test;

public class TestNGInvocation {
  @Test(threadPoolSize=3,invocationCount=6,timeOut=1000)
  public void f() {
	  Long id = Thread.currentThread().getId();
	  System.out.println("Thread id is -"+id);
	  
  }
}
