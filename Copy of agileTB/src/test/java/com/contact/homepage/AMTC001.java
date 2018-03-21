package com.contact.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.contact.testBase.TestBase1;
import com.contact.uiActions.HomePage1;

public class AMTC001 extends TestBase1 {
	public static final Logger log= Logger.getLogger(TestBase1.class.getName());
	HomePage1 homepage;

	String Name = "Mr. Jack Robinson";
	String Email = "jackrobinson@email.com";
	String Mobile = "1234567890";
	String Office = "0987654321";
	

	@BeforeClass
	public void setup(){
		init();
		
	}
	
	@Test
	public void testLogIn(){
		log.info("========== Starting Test =========");
		homepage =new HomePage1(driver);
		homepage.fillTheContactForm(Name, Email, Mobile, Office);
		homepage.getMessageTest();
		getScreenShot("testLogIn");
		log.info("========== Finished Test =========");
		
		
		
		
		
	}
	
	
	@AfterClass
	public void endTest(){
		
		driver.quit();
	}
	
	
	

}
