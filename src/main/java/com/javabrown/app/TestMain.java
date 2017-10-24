package com.javabrown.app;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.junit.runner.JUnitCore;
import java.util.Arrays;

import com.javabrown.app.utils.StringUtils;

import static com.javabrown.app.KeysI.*;

public class TestMain {
	private WebDriver _driver;
	private com.javabrown.app.CLI _cli;
	
	public TestMain(com.javabrown.app.CLI cli){
		_driver = createDriver(cli.getBrowserName());
		_cli = cli;
	}
	
	private WebDriver createDriver(String browserName){
		WebDriver driver = null;
		
        if(browserName.equalsIgnoreCase(BROWSER_IE)) {
           System.setProperty("webdriver.ie.driver","./resources/drivers/IEDriverServer.exe");
           driver = new InternetExplorerDriver();
        }
        else if(browserName.equalsIgnoreCase(BROWSER_FF)){
           System.setProperty("webdriver.gecko.driver","./resources/drivers/geckodriver.exe");
           driver = new FirefoxDriver();
        }
        else{
           System.setProperty("webdriver.chrome.driver","./resources/drivers/chromedriver.exe");
           driver = new ChromeDriver();
        }	
		
		return driver;
	}
	
    public void execute() throws Exception {
        String tagName = "";
        String baseUrl = String.format("http://%s.mytraintravel.com/?lang=%s", 
            _cli.getDomain(), _cli.getLanguage());
        System.out.printf("Loading URL: [%s]\n", baseUrl);
        
        _driver.get(baseUrl);
        
        
        tagName = _driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        
        JUnitCore.runClasses(com.javabrown.app.RkTest.class);
        
        _driver.close();
		
	  
        System.exit(0);
    }
    
    public void execute0() throws Exception {
      String baseUrl = "http://www.facebook.com";
      String tagName = "";
      
      _driver.get(baseUrl);
      tagName = _driver.findElement(By.id("email")).getTagName();
      System.out.println(tagName);
      _driver.close();
      
      String content = new java.util.Scanner(new java.io.File("./resources/drivers/notes.txt")).useDelimiter("\\Z").next();
      System.out.println(content);

      System.out.println("Done");
      System.exit(0);
  }
}