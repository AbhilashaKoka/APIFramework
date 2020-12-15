package Utility;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import managers.FileReaderManager;


public class Wait {
	
	public static void untilJqueryIsDone(WebDriver driver){
		untilJqueryIsDone(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->
			{
			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
			}, timeoutInSeconds);
	}
	
	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}
	
	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
		until(driver, waitCondition, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	
	
//	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//	 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
//	 wait.withTimeout(2, TimeUnit.MINUTES);
//	 wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
//	 Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
//	 {
//	 public WebElement apply(WebDriver arg0) {
//	 System.out.println("Checking for the element!!");
//	 WebElement element = arg0.findElement(By.id("target"));
//	 if(element != null)
//	 {
//	 System.out.println("Target element found");
//	 }
//	 return element;
//	 }
//	 };
//	 
//	 wait.until(function);
//	 }
	 
//	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//	wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
//	wait.withTimeout(2, TimeUnit.SECONDS);
//
//	Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
//			{
//				public Boolean apply(WebDriver arg0) {
//					WebElement element = arg0.findElement(By.id("colorVar"));
//					String color = element.getAttribute("color");
//					System.out.println("The color if the button is " + color);
//					if(color.equals("red"))
//					{
//						return true;
//					}
//					return false;
//				}
//			};
//
//	wait.until(function);
//}
	
	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
		try{
			webDriverWait.until(waitCondition);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}          
	}
	
	
	
	
}