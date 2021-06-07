package ProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Project4 {
	
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
    	Thread.sleep(20000);
    	//Scroll and select To do List
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingForward().scrollIntoView(textContains(\"To-Do List\"))")).click();
    	Thread.sleep(20000);
    	
    	//Adding tasks    	
    	String[] collection = {"Add tasks to list", "Get number of tasks", "Clear the list"};
    	
    	for (int i=0; i<= collection.length-1;i++) {
    		Thread.sleep(10000);
    		driver.findElementByClassName("android.widget.EditText").sendKeys(collection[i]);
    		Thread.sleep(5000);
    		driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button").click();
    	}
    	
    	Thread.sleep(5000);
    	int numb = driver.findElementsById("tasksList").size();
    	System.out.println("The number of tasks added:" + numb);
    	
    	for (int j=1; j<=numb; j++) {
    		Thread.sleep(5000);
    		driver.findElementById("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[j]/android.view.View").click();
    	}
    	
    	Thread.sleep(5000);
    	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]").click();
    	System.out.println("All tasks cleared");
    }
    	
    @AfterClass
    public void afterClass() {
    	driver.quit();
    }

}

