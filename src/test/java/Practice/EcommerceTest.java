package Practice;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class EcommerceTest extends basic {
@Test()
public void totalValidation() throws IOException, InterruptedException {
	service=startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("Generalstoreapk");
     	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     	FormPage formPage=new FormPage(driver);
     	formPage.getNameField().sendKeys("Hello");
     	formPage.femaleOption.click();
     	formPage.countrySelection.click();  
     	
     	Utilities utilities=new Utilities(driver);
     	utilities.scrollToText("Argentina");
     	formPage.argentina.click(); 
     	formPage.btnletsshop.click();
     	
     	driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
     	driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
     	driver.findElementsByClassName("android.widget.ImageButton").get(1).click(); 
    	Thread.sleep(4000);
    	CheckoutPage checkoutpage=new CheckoutPage(driver);
    	String amount1 =checkoutpage.productlist.get(0).getText();
    	amount1=amount1.substring(1);
    	double amount1value=Double.parseDouble(amount1);
    	System.out.println(amount1value);
    	String amount2 =checkoutpage.productlist.get(1).getText();
    	amount2=amount2.substring(1);
    	double amount2value=Double.parseDouble(amount2); 
    	System.out.println(amount2value);
    	double total=amount1value+amount2value;
    	System.out.println(total);
    	String totalAmount=checkoutpage.totalAmount.getText();
    	totalAmount = totalAmount.substring(1);
    	double  totalAmountvalue=Double.parseDouble( totalAmount);
    	System.out.println(totalAmountvalue);
    	Assert.assertEquals(total, totalAmountvalue);
    	
    	service.stop();

}


/*@BeforeTest
public void killAllNodes() throws IOException {
	Runtime.getRuntime().exec("killall node");
	
	
}*/

}



