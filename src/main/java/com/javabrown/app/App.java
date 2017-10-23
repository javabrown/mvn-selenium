package com.javabrown.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

import com.javabrown.app.KeysI;
import com.javabrown.app.utils.StringUtils;

public class App {
  public static void main(String[] args) throws Exception {
    String browser = KeysI.BROWSER_FF;

    CLI cli = new CLI(args);
    
    if(!cli.hasError()) {
      System.out.printf("Running test in Browser - %s\n", cli.getBrowserName());
      TestMain test = new TestMain(cli.getBrowserName());
      test.execute();
    }
    else{
      System.out.println(cli.getErrorMsg());
    }
    
  }
}

