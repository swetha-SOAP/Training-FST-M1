package activity1;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity3_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        // Use your own device's messaging app
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void smsTest() throws Throwable {
        // Locate the button to write a new message and click it
    	
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
        Thread.sleep(5000);
        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
        Thread.sleep(5000);
        // Enter your own phone number
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9449238547");
        Thread.sleep(5000);
        // Focus on the message text box
        String messageBoxLocator = "text(\"Start group conversation\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
        Thread.sleep(5000);
        // Type in a message
        String confirm = "resourceId(\"com.google.android.apps.messaging:id/action_confirm_participants\")";
        driver.findElement(MobileBy.AndroidUIAutomator(confirm)).click();
        Thread.sleep(5000);
        messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        composeMessageInput.sendKeys("Hello from Appium");
        Thread.sleep(5000);
        // Send the message
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();
        Thread.sleep(10000);
        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));

        // Assertion
        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}