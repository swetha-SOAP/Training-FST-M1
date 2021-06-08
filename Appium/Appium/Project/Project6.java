package ProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project6 {

	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
	public void beforeClass() throws MalformedURLException {
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 100);
	}

    @Test
    public void toDoList() throws Throwable {
    	//Go to the selenium URL
    	driver.get("https://www.training-support.net/selenium");
    	Thread.sleep(10000);
    	//Scroll to find the To-Do List card and click it
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"Popups\"))")).click();
    	Thread.sleep(10000);
    	driver.findElementByClassName("android.widget.Button").click();
    	driver.switchTo().window(driver.getWindowHandle());
    	
    	
    	//Enter valid credentials to login
    	driver.findElementById("username").sendKeys("admin");
    	driver.findElementById("password").sendKeys("password");
    	driver.findElementByClassName("android.widget.Button").click();
    	
    	Thread.sleep(5000);
    	String text = driver.findElementById("action-confirmation").getText();
    	String actual = "Welcome Back, admin";
    	Assert.assertEquals(actual, text);
    	Thread.sleep(5000);
    }	
    
   @Test 
    public void credCheck2() throws Throwable {
	   
	   	driver.findElementByClassName("android.widget.Button").click();
   		driver.switchTo().window(driver.getWindowHandle());
   		
    	//Enter invalid credentials to login
    	driver.findElementById("username").sendKeys("admin");
    	driver.findElementById("password").sendKeys("pass");
    	driver.findElementByClassName("android.widget.Button").click();
    	
    	Thread.sleep(5000);
    	String msg = driver.findElementById("action-confirmation").getText();
    	String conf = "Invalid Credentials";
    	Assert.assertEquals(conf, msg);
    	
    }
    
    @AfterClass
    public void afterClass() {
    	driver.quit();
    }


}
