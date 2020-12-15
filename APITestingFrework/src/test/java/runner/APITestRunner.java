package runner;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
features = "C:\\Users\\10655479\\eclipse-workspace\\APITestingFramework\\APITestingFramework\\src\\test\\resource\\feature\\api",
glue={"stepDefinitions.apisteps"}, 
dryRun = false,
monochrome = true,
plugin = {"pretty", "html:target/cucumber-reports/report.html", "json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","rerun:target/rerun.txt"}
)


public class APITestRunner extends AbstractTestNGCucumberTests{
	 @Override
	  @DataProvider(parallel = true)
	  public Object[][] scenarios() {
	    return super.scenarios();
	  }	
}
