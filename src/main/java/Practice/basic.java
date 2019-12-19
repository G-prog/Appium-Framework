package Practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class basic {
	
	//public static AppiumDriverLocalService service;
	public static AndroidDriver <AndroidElement>driver;
	
	/*public AppiumDriverLocalService startServer() {
		
		
	
		boolean flag=checkIfServerIsRunnning(4723);
		if(!flag)
		{
			service=AppiumDriverLocalService.buildDefaultService();
			
			service.start();
		}
		
		
		return service;
	}
	
	
	 public static boolean checkIfServerIsRunnning(int port) {
			
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				
				serverSocket.close();
			} catch (IOException e) {
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}*/
	 
	 
	 public static void startEmulator() throws IOException {
		 
		 Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/java/resources/startEmulator.sh");
		 
		 
	 }

 
	 public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException
    {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		    //prop.get(appName);
    	File f=new File("src");
    	File fs=new File(f,	(String) prop.get(appName));
    	DesiredCapabilities cap=new DesiredCapabilities();
    	String device=(String) prop.get("device");
    	cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);
    	startEmulator();
     // cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
    	cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
    	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
    	driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    	return driver;
      
    }
	 
	 public static void getScreenshot(String name) throws IOException {
		 
		 
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir")+"//"+name+".png"));
		 
		 
		 
	 }


	
}
