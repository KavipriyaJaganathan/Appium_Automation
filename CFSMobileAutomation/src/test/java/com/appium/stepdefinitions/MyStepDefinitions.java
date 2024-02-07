package com.appium.stepdefinitions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepDefinitions{

	private AppiumDriver<MobileElement> driver;

    @Given("The path of the apk file to be  installed")
    	
	
		public void app_Instalation() throws MalformedURLException {
    	File f=new File("src");
    	File fs=new File(f,"APKPure_v3.19.78_apkpure.com.apk");
    	
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        

        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appiumServerURL, capabilities);
    }
    

    
 
    
    @Then("I should be on the dashboard screen")
    public void i_should_be_on_the_dashboard_screen() {
        
        boolean isDashboardDisplayed = driver.findElement(By.id("")).isDisplayed();
        assert(isDashboardDisplayed); 
    }
}
