package SunBasket.Utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DriverScript_Device {

	public AppiumDriver<MobileElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	
	public AppiumDriver<MobileElement> initializeDevice(String device) throws MalformedURLException{
		if(device.equals("ios")) {
			iosSetUp();
		}else if(device.equals("android")){
			androidSetUp();
		}
		return driver;
	}
	

	private AppiumDriver<MobileElement> androidSetUp() throws MalformedURLException {
		File appDir = new File("resources_app");	   
		File app = new File(appDir, "app-release-1.3.2.apk");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap );	
		return driver;
	}

	private AppiumDriver<MobileElement> iosSetUp() throws MalformedURLException {
		File appDir = new File("resources_app");		   
		File app = new File(appDir, "SunBasket.app");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//		cap.setCapability("automationName", "XCUITEST");
//		cap.setCapability("useNewWDA", true);
		cap.setCapability("showXcodeLog", true);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);	
		return driver;
	}
	

}
