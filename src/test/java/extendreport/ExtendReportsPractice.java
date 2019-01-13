package extendreport;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import listenrs.Base;

import org.testng.annotations.Test;

public class ExtendReportsPractice extends Base {

	@Test
	public void test1() {
	System.out.println("this is test1...");	
	}
	
	@Test
	public void test2() {
	System.out.println("this is test2....");	
	}
	@Test
	public void test3() {
	System.out.println("this is test3.....");
	driver.findElement(By.id("namer")).click();
	Assert.assertTrue(false);
	}
}
