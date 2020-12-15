import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class E2E_Test {
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\10655479\\git\\repository\\CucumberFramework\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement username= driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
		WebElement password=driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
		WebElement login=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		login.click();		
		driver.close();	
			
		}

	}

