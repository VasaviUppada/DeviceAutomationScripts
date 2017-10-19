package SunBasket.Utility;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest_Device extends DriverScript_Device{

	@Parameters({"device"})
    @BeforeMethod
    public synchronized void setUpDevice(@Optional("ios")String device, Method method) throws MalformedURLException {
		initializeDevice(device);
	}
	
	@AfterMethod
	public synchronized void tearDown() {
		driver.quit();
	}
}
