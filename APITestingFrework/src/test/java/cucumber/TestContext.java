package cucumber;
import managers.WebDriverManager;


public class TestContext {
	private WebDriverManager webDriverManager;
	
	public ScenarioContext scenarioContext;
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	
	
	//List<RegisterDetails> registerdetails = FileReaderManager.getInstance().getJsonReader().getRegisterDetailsData();
	//Include ScenarioContext in TextContext, 
	//so that it can be shared across all the Cucumber Steps using Pico-Container library.
	//Also, to make sure to add a getter method as getScenarioContext() to get the scenarioContext object.
	
	public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
}