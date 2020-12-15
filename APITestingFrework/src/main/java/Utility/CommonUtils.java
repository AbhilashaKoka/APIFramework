package Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Date;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;


public class CommonUtils{
    public String appPath;
    private static WebDriver driver;       
    private static StringBuilder text=new StringBuilder();
    

  public static String GetAttributeValue(WebElement element)
  {	  
      return element.getAttribute("value");
   }         
        
  public  static void FileUpload(WebElement element, String value)
    {
//        AutoItX.WinActivate("Save As");
//        Thread.Sleep(2000);
//        AutoItX.Send("^a");
//        AutoItX.WinGetText("", "Suspended");
    }

    public static void MouseHover(WebElement element) throws Exception
    {
        try
        {               
           // WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(30));
//            Actions action = new Actions(driver);
//            action.moveToElement(element).perform();
//            Thread.sleep(1000);            

        }
        catch (Exception ex)
        {
            throw new Exception("Error On  Hovering mouse"+ex.getMessage());
        }
    }

    public  static void MoveToConfirmPopup(WebElement element) throws Exception
    {
        try
        {                
          Actions action = new Actions(driver);
           action.moveToElement(element).build().perform();
        }
        catch(Exception ex)
        {
            throw new Exception("Error Moving to Confirmation PopUP" + ex.getMessage());
        }
    }


    public static String EnterText(WebElement element, String value) throws Exception
    {
        try
        {
            if (element.isEnabled() == true)
            {
                element.clear();
                Thread.sleep(1000);
                element.sendKeys(value);                   
            }
            else
            {
                System.out.println(" " + element + " element is disable");
            }
            return element.getAttribute(value);
        }
        catch (Exception ex)
        {
            throw new Exception("Value \"" + value + "\" is not getting selected Properly " + ex.getMessage());
        }
    }

    public static String EnterText(WebElement element, String value1,String value2) throws Exception
    {
        try
        {
            element.clear();
            Thread.sleep(1000);
            element.sendKeys(value1);
            element.sendKeys(Keys.ENTER);
            return element.getAttribute(value1);
        }
        catch (Exception ex)
        {
            throw new Exception("Value \"" + value1 + "\" is not getting selected Properly " + ex.getMessage());
        }
    }

    public  static void Clicks(WebElement element) throws Exception
    {
        try
        {       	
//           WebDriverWait wait = new WebDriverWait(driver, 10);
//           wait.until(ExpectedConditions.elementToBeClickable(element));          
            element.click();
        }
        catch(Exception ex)
        {
            throw new Exception("Error Clicking on the element"+ex.getMessage());
        }
    }
    
    public  static boolean SelectCheckBox(WebElement element, String value) throws Exception
    {
        boolean flag = false;
        try
        {
            if (element.isEnabled() == true)
            {
                if (element.isSelected() == false)
                {
                    if (value == "1")
                    {
                        element.click();
                        element.click();
                        flag = true;
                    }
                }
            }
            else
            {
               System.out.println(""+element+"checkbox is disable");
            }
        }
        catch (Exception ex)
        {
        	System.out.println(ex.getCause());
            throw new Exception("Value \"" + value + "\" is not getting selected Properly " + ex.getMessage());
        }
        return flag;
    }
    public  static boolean SelectCheckBox2(WebElement element) throws Exception
    {
        boolean flag = false;
        try
        {
            if (element.isEnabled() == true)
            {
                if (element.isSelected() == false)
                {
                    
                    {                       
                        element.click();
                        flag = true;
                    }
                }
            }
            else
            {
               System.out.println(""+element+"checkbox is disable");
            }
        }
        catch (Exception ex)
        {
        	System.out.println(ex.getCause());
            throw new Exception("Value \"" + element + "\" is not getting selected Properly " + ex.getMessage());
        }
        return flag;
    }


    public static boolean VerifyCheckboxStatus(WebElement element) throws Exception
    {
        boolean flag = false;
        try
        {   
            if (element.isSelected())
            {
                flag = true;
            }                
            flag = false;                  
            
        }
        catch(Exception ex)
        {
            throw new Exception("Value \"" + element + "\" is not getting selected Properly " + ex.getMessage());
        }
        return flag;
    }
    public static void selectValueFromDropdown(WebElement element, String values) throws Exception
    {
        try
        {
            if (element.isEnabled() == true)
            {
                Select selElement = new Select(element);
                List<WebElement> ele = selElement.getOptions();
                for (WebElement elements : ele)
                {
                    if (elements.getAttribute("text") == values)
                    {
                        elements.click();
                        break;
                    }
                    continue;
                }
            }
        }
        catch (Exception ex)
        {
            throw new Exception("Value \"" + values + "\" is not getting selected Properly " + ex.getMessage());
        }

    }

    public  static void scrollAndDrag(WebElement element) throws Exception
    {
        try {
           Actions actions = new Actions(driver);
           actions.dragAndDropBy(element,334 , 564).release().build().perform();
          element.click();
        }
        catch (Exception ex)
        {
            throw new Exception("Error Scrolling and draging"+ex.getMessage());
        }

    }


    public  static void HandlingSlider(WebElement element, int a, int b) throws Exception
    {
        try
        {               
            Actions action = new Actions(driver);
            action.dragAndDropBy(element, a, b).release().perform();              
            element.click();       
        }

        catch(Exception ex)
        {
            throw new Exception("Error on finding element"+ex.getMessage());

        }
    }

public static  String DisplaytableColoumnfieldName(WebElement element)
    {                                  
           Object[] str2=null;
           List<String> list = new ArrayList<String>();
           String valueofd=null;
           List<WebElement> lstTrElem = new ArrayList<WebElement>(element.findElements(By.tagName("tr")));        
          for (WebElement elemTr : lstTrElem)
           {                    
             List<WebElement> lstTdElem = new ArrayList<WebElement>(elemTr.findElements(By.xpath("td/a")));
             //   int col = lstTdElem.size();            
                 if (lstTdElem.size() > 0)
                 {
                      for (WebElement elemTd :lstTdElem)
                      {
                      String strRowData = "";
                      strRowData = strRowData + elemTd.getText();
                      System.out.println(strRowData);                        
                      list.add(strRowData);
                      System.out.println(list);
                     str2 = list.toArray();                    
                     System.out.println(str2);
                      StringBuilder builder = new StringBuilder();
                      for(Object value : str2)
                      {
                        builder.append(value);
                        builder.append(',');
                      }
                      valueofd = builder.toString();
                      System.out.println(valueofd);
                      }                           
                 }                               
           }                 
      
      return valueofd;          
  }



    

    public  static void Calender(WebElement element) throws Exception{
        try
        {   
            WebElement calButton = driver.findElement(By.xpath("//*[@id='dateOfBirth']/div/div/div/button"));
            Clicks(calButton);
        //    Actions action = new Actions(driver);
            WebElement tb_cal = driver.findElement(By.xpath("//*[@id='dateOfBirth']/div/div[2]/table[2]"));
           // action.moveToElement(tb_cal);                
            element = driver.findElement(By.xpath("//table[@class='header']//td[1]"));
            element = driver.findElement(By.xpath("//*[@id='effectivityDate4']/div/div[2]/table[1]/tr/td[1]/div/div[1]/button"));
            element = driver.findElement(By.xpath("//*[@id='effectivityDate4']/div/div[2]/table[1]/tr/td[1]/div/div[3]/button"));
            element = driver.findElement(By.xpath("//*[@id='effectivityDate4']/div/div[2]/table[1]/tr/td[2]"));
            element = driver.findElement(By.xpath("//*[@id='effectivityDate4']/div/div[2]/table[1]/tr/td[3]"));
            element = driver.findElement(By.xpath("//td[3]//div[1]//div[1]//button[1]"));
            element = driver.findElement(By.xpath(" //td[3]//div[1]//div[3]//button[1]"));
            element = driver.findElement(By.xpath("//*[@id='effectivityDate4']/div/div[2]/table[2]/tbody"));
            List<WebElement> accordions = new ArrayList<WebElement>(driver.findElements(By.xpath("\\a[@data-parent='#accordion1']")));

        }
        catch (Exception ex)
        {
       throw new Exception(ex.getMessage());
        }         
    }



    public  static int DisplayDynamicTable(WebElement element) throws Exception
    {
        int Count = 0;
        try
        {
            String strRowData = "";            
            List<WebElement> lstTrElem = new ArrayList<WebElement>(element.findElements(By.tagName("tr")));
            int rowcount = lstTrElem.size();
            for(WebElement elemTr : lstTrElem)
            {               
              List<WebElement> lstTdElem = new ArrayList<WebElement>(elemTr.findElements(By.tagName("td")));
             int colcount = lstTdElem.size();
              if (lstTdElem.size() > 0)
                {
                    try
                    {
                        int count = 0;
                         for (WebElement elemTd : lstTdElem)
                        {
                            count++;
                            switch(count)
                            {
                                case 1:
                                    strRowData = elemTd.getText();
                                    System.out.println("The Name:" + strRowData + " ");
                                    break;
                                case 2:
                                    strRowData = elemTd.getText();
                                    System.out.println("The Status:" + strRowData + " ");
                                    break;
                                case 3:
                                    strRowData = elemTd.getText();
                                    System.out.println("The  Number of records:" + strRowData + " ");
                                    break;
                                default:
                                	System.out.println("Table is empty");
                                    break;
                            }
                            if (count == 3)
                            break;                                
                        }
                    }
                    catch (Exception ex)
                    {
                     
                        throw new Exception(ex.getMessage());
                    }
                    continue;

                }

                Count++;
            }
        }
        catch (Exception ex)
        {
        throw new Exception(" Error " + ex.getMessage());
        }
        return Count;
    }

    
    public static  int DynamicTable(WebElement element, String value) throws Exception
    {
        int Count = 0;
        try
        {
          String strRowData = "";
           //int Count = 0;                
          List<WebElement> lstTrElem = new ArrayList<WebElement>(element.findElements(By.tagName("tr")));
         // int col = lstTrElem.size();
          for(WebElement elemTr :lstTrElem)
          {                  
                List<WebElement> lstTdElem = new ArrayList<WebElement>(elemTr.findElements(By.tagName("td")));
             //   int row = lstTdElem.size();
                if (lstTdElem.size() > 0)
                {
                    try
                    {
                        for (WebElement elemTd :lstTdElem)
                        {
                            strRowData = elemTd.getText();
                            if (strRowData == value)
                            elemTd.click();
                           Thread.sleep(2000);
                          System.out.println("" + strRowData + " is clickable");
                            break;
                        }

                        continue;
                    }
                    catch (Exception ex)
                    { 
                    
                     throw new Exception(ex.getMessage());
                }
                    

                }

                Count++;
          }
        }
        catch(Exception ex)
        {
        throw new Exception(" Error " + ex.getMessage());
        }
        return Count;
    }

    public  static String ReadPdfFile(String docname)
    {          
       // String name = docname.replace(" ", (CharSequence) blankOrNullString()) + DateTime.now().toString("r")+".PDF" ;           
       // String fileName = "C:\\Users\\Abhil726\\Downloads" + "\\" + "" + name.replace(":", "_") + "";
//        if (File.Exists(fileName))
//        {
//            try
//            {                 
//
//                PdfReader pdfReader = new PdfReader(fileName);
//                for (int page = 1; page <= pdfReader.NumberOfPages; page++)
//                {
//                    ITextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
//                    string currentText = PdfTextExtractor.GetTextFromPage(pdfReader, page, strategy);
//                    currentText = Encoding.UTF8.GetString(ASCIIEncoding.Convert(Encoding.Default, Encoding.UTF8, Encoding.Default.GetBytes(currentText)));
//                    text.Append(currentText);
//                }
//                pdfReader.Close();
//               
//            }
//            catch (Exception ex)
//            {
//                throw new Exception(ex.getMessage());
//            }
//
//        }
//        else
//        {
//
//           System.out.println("File do not exist!!");
//        }             
     return text.toString();
    }
        


    public static String getUniqueName(String name)
    {
        try
        {
        	SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
        	dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT"));
        	System.out.println(dateTimeInGMT.format(new Date()));
            name = name +dateTimeInGMT.format(new Date());
           
        }
        catch (Exception ex)
        {
           // logger.Log(LogStatus.Fail, ex.Message + logger.AddScreenCapture(driverUtils.CaptureScreen(driver, "Fail_getUniqueName")));
        }

        return name;
    }

    public  static void DeleteTestResults() throws Exception
    {
        try
        {
        	String userDirectory = FileSystems.getDefault()
                    .getPath("")
                    .toAbsolutePath()
                    .toString();
            System.out.println(userDirectory);
          
//
//            List<string> tmpName = appPath.Replace(@"\bin\Debug", "").Split('\\').ToList();
//
//            tmpName.RemoveAt(tmpName.Count - 1);
//
//            appPath = string.Join(@"\", tmpName);
//
//            appPath = appPath + "\\TestResults";
//
//            if (Directory.Exists(appPath))
//            {
//                Directory.Delete(appPath, true);
//            }
        }
        catch (Exception ex)
        {
            throw new Exception("Error Deleting Test Results Deirectory. " + ex.getMessage());
        }
    }
    public  static void switchToIFrameByWebElement(WebElement web_iframe)
    {
        try
        {
            if ((web_iframe.isEnabled()))
            {
                driver.switchTo().frame(web_iframe);
            }
            else
            {
                System.out.println("Unable to navigate to the desired iframe " + web_iframe);
            }
        }
        catch (NoSuchFrameException ex)
        {
        	 System.out.println("Unable to find a iframe matching web element " + web_iframe + ex.getStackTrace());
        }
        catch (StaleElementReferenceException ex)
        {
        	 System.out.println("Web Element with " + web_iframe + "is not bind to the page document" + ex.getStackTrace());
        }
        catch (Exception ex)
        {
        	 System.out.println("Unable to navigate to iframe matching web element " + web_iframe + ex.getStackTrace());
        }
    }
    public static void execKill(long minutes) throws InterruptedException{
		//Thread.sleep(minutes*60L*1000L);
		try{
		Runtime.getRuntime().exec(" cmd /c TASKKILL /F /IM node.exe");
		}
		catch(IOException io)
		{
		io.printStackTrace();
		}
	}
}


