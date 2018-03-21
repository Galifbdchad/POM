package com.contact.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class TestBase1 {

	public static final Logger log= Logger.getLogger(TestBase1.class.getName());
	
	
	public  WebDriver driver;
	String url= "http://mock.agiletrailblazers.com/contact.html";
	String browser= "Chrome";
	
	
	
	public void init(){
	
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath= "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
						
	}

	private void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/drivers/chromedriver.exe");	

			log.info("creating object of "+browser);
			
			driver=new ChromeDriver();
			
		}
			
	}
	
		private void getUrl(String url) {

			log.info("navigating to :-"+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		}

		
		public void getScreenShot(String name){
			Calendar calender= Calendar.getInstance();
			SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try{
// this is report directory, where i want to keep screenshot				
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/contact/screenshot/";
// what name, what format and what format calender time I want to store with png
				File destFile = new File((String)reportDirectory+name+"_"+formater.format(calender.getTime())+".png");
//FileUtils from apache will copy screenshot to destination folder
				FileUtils.copyFile(scrFile, destFile);
// This will link the screenshot in testng report. in reporter class just write the link to attach
				Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"' height='100' width='100'/></a>");
			}catch(IOException e){
				e.printStackTrace();
		}
		}
	
		

	
		
		
		
}		
		
		
		
		
		
	
	
	

