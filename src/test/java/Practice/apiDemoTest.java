package Practice;
import java.io.IOException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class apiDemoTest extends basic {
	
	

	
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException
	
	{
		//service=startServer();
		AndroidDriver <AndroidElement>driver=Capabilities("apidemo");
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();	
		//service.stop();
		
		//Xpath id,androiduiautomator
		
		/*xpath id
		 * //tagName[@attribute='value']
		 * 
		 * In case there is no unique identifier we use the class name followed by the index of the element to select the element
		 * 
		 * 
		 * */
		
		
		
		
		
	}
	
	
	
}
