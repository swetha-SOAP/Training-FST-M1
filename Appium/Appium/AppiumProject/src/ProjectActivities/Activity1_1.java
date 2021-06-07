package ProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait; 
    
@BeforeClass
public void beforeClass() throws MalformedURLException {
    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "Pixel 4 API 28");
    caps.setCapability("platformName", "Android");
    caps.setCapability("automationName","UiAutomator2");
    caps.setCapability("appPackage", "com.google.android.apps.tasks");
    caps.setCapability("appActivity", ".ui.TaskListsActivity");
    caps.setCapability("noReset", true);

    // Instantiate Appium Driver
    URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    driver = new AndroidDriver<MobileElement>(appServer, caps);
    wait = new WebDriverWait(driver, 100);
}

@Test
public void createTask() throws InterruptedException {
	String[] tasks = {"Complete Activity with Google Tasks",
			"Complete Activity with Google Keep",
			"Complete the second Activity Google Keep"
			};
	
	// looping creation of tasks
	for (int i=0;i<=tasks.length-1;i++) {
	
	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
    driver.findElementById("tasks_fab").click();
    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
    driver.findElementById("add_task_title").sendKeys(tasks[i]);
    driver.findElementById("add_task_done").click();
    String check = tasks[i];
    
    
  //Assertion
  	wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("task_name")));
  	List<MobileElement> addedTasks = driver.findElementsById("task_name");
  	
  				String task= addedTasks.get(0).getText();
  				
  				Assert.assertEquals(task, check);
  				System.out.println(i+". " + task);
	}
    
    
	
	}

	
@AfterClass
public void afterClass() {
    driver.quit();
}
}
