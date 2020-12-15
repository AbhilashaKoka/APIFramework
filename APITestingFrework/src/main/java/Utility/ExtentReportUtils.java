package Utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class ExtentReportUtils {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest  test;
	public static  File reportOutputDirectory = new File("target");
	public static String projectName = "testng-cucumber";
	
	
	public ExtentReportUtils() {
		
	}

	
	
	public static void reportsetup() {		
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		}	
	
	public static void createTestCase(String testnumber,String description)
	{
		test=extent.createTest(testnumber ,description);
		test.log(Status.INFO, description);
	}
	
	
	
	public  static void reportteardowm() {		
		extent.flush();
	}
	
	public static  void generateReport() {
		    ArrayList<String> jsonFiles = new ArrayList<String>();
	        jsonFiles.add("target/cucumber.json");      
            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
	        configuration.addClassifications("Platform", System.getProperty("os.name"));
	        configuration.addClassifications("Browser", "Chrome");
	        configuration.addClassifications("Branch", "release/1.0");
            List<String> classificationFiles = new ArrayList<String>();
	        classificationFiles.add("C:\\Users\\10655479\\eclipse-workspace\\CucumberFramework\\Configs\\configuration.properties");
	        configuration.addClassificationFiles(classificationFiles);
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	        reportBuilder.generateReports();
	    }

	}


