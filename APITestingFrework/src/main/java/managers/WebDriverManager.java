package managers;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.common.collect.ImmutableMap;

import Utilities.CommonUtils;
import enums.DriverType;
import enums.EnvironmentType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class WebDriverManager {
	private  static WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static AndroidDriver<MobileElement> mobiledriver;
	private static AppiumDriverLocalService service=null;

	public WebDriverManager()
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	    environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver()  {
		try {
		if(driver == null) driver = createDriver();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return driver;
	}
	


	private WebDriver createDriver() {
	try {
		   switch (environmentType)
		   {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;	        	
	        	        
		   }
	}
	catch(Exception ex)
	{
		ex.getStackTrace();
	}
		   return driver;
	}
	
   private WebDriver createRemoteDriver() 
    {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

   
    
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	public String getTitle( ) {
		 String title=driver.getTitle();
		return title;
	}

	public void closeDriver() {
	//	driver.close();
	driver.quit();
	}
	public AndroidDriver<MobileElement> getMobileDriver()  {
		try {
		if(mobiledriver == null) mobiledriver = createAndroidDriver();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return mobiledriver;
	}
	
	
	private AndroidDriver<MobileElement> createAndroidDriver() 
	{
		DesiredCapabilities capabilities=setCapabilitiesForAndroid();
		try {
			if(service.isRunning()==true)
		    {
		   CommonUtils.execKill(1L);
		   service.start();
		   }
		  mobiledriver = new AndroidDriver<>(service, capabilities);
         	}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
        return mobiledriver;
    }

	
    private DesiredCapabilities setCapabilitiesForAndroid() {
    	service=AppiumDriverLocalService.buildDefaultService();
		DesiredCapabilities cap=new DesiredCapabilities();
    	cap.setCapability("platformName", "Android");
       //cap.setCapability("platformVersion", "10");
       //cap.setCapability("deviceName", "moto g(7)");
       //cap.setCapability("udid", "ZF6224BG9B");
    	
    	cap.setCapability("platformVersion", "5.0");
		cap.setCapability("deviceName", "ASUS_Z00AD");
		cap.setCapability("udid", "F8AZFG017568");		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);	
		cap.setCapability("browserName", "CHROME");	
		cap.setCapability("appium:ChromeOptions", ImmutableMap.of("w3c",false));
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("w3c", false);
		cap.merge(chromeOptions);
        cap.setCapability("nativeWebScreenshot", true);
        cap.setCapability("chromedriverUseSystemExecutable", true);
        cap.setCapability("autoGrantPermissions", true);
        
//        cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/app/xxx.apk");
//        cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//        cap.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
//        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
//        cap.setCapability(AndroidMobileCapabilityType.SUPPORTS_ALERTS,true);
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        
    	return cap;
    }
    
    public void closeAndroidDriver() 
	{
		
		try {
			if(service.isRunning()==true)
		    {
		   CommonUtils.execKill(1L);
		   service.stop();
		    }
         	}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
        
    }

}