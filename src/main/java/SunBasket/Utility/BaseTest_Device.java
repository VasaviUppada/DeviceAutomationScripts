package SunBasket.Utility;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest_Device extends DriverScript_Device{

	@Parameters({"browser"})
    @BeforeMethod
    public synchronized void setUp(@Optional("chrome")String browser, Method method) {
	}
}
