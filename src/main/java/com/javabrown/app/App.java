package com.javabrown.app;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import com.javabrown.app.utils.StringUtils;

public class App {
    public static void main(String[] args) throws Exception {
		String browser = KeysI.BROWSER_FF;
		

       for(int i=0; i< args.length; i++){
		    LaunchOption opt = LaunchOption.find(args[i]);
 
			switch(opt){
               case BROWSER:
			        if(opt.isSuppliedParamValid(args[i])){
					   browser = opt.getSuppliedOptionParams(args[i]);
					   System.out.printf("Browser %s Selected!!\n", browser);
					}
					else{
						System.out.printf("Invalid Option for -b, valid browser options are [%s]\n", 
						     StringUtils.stringify(opt.getValidOptions())); 
						System.exit(1);
					}
					break;
					
               case TESTCASE_LOCATION: 
					System.out.println("TESTCASE_LOCATION = " + opt.getSuppliedOptionParams(args[i]) ); 
					break;
					
			   default: System.out.printf("Invalid Parameter!! Valid Browser Options are: %s\nHere is a sample: %s.\n", 
			              opt.getAllOptions(), "$ retest.jar -bFF -lc:\\test\\"); 
			}
	   }
	   
	   TestMain test = new TestMain(browser);
	   test.execute();
    }
}