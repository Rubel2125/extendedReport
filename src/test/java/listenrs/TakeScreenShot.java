package listenrs;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

public class TakeScreenShot {
	
	public static Base base;
	
	
	
	public static File takescreenshot() {
		base = new Base();
		
		TakesScreenshot ts = (TakesScreenshot) base.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		return source;
	}
	
	
	

}
