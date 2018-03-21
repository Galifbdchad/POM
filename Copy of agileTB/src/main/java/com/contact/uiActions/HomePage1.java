package com.contact.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage1 {
	
	
	public static final Logger log= Logger.getLogger(HomePage1.class.getName());
	WebDriver driver;
	
	


	@FindBy(xpath=".//*[@id='name']")
	WebElement name;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement email;
	
	@FindBy(xpath=".//*[@id='mobile']")
	WebElement mobile;
	
	@FindBy(xpath=".//*[@id='office']")
	WebElement office;

	@FindBy(xpath=".//*[@id='subject']")
	WebElement dropdown;
	
	@FindBy(xpath=".//*[@id='message']")
	WebElement message;
	
	@FindBy(xpath=".//*[@id='submit']")
	WebElement submit;

	
	@FindBy(id="nameAlert")
	WebElement nameAlert;
	
	@FindBy(id="emailAlert")
    WebElement emailAlert;
	
	
	@FindBy(id="messageAlert")
    WebElement messageAlert;
	
	@FindBy(id="success-message")
    WebElement success_message;
	
	@FindBy(id="error-message")
	WebElement error_message;
	
	
	
	
	
	public HomePage1(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void fillTheContactForm(String Name,String Email,String Mobile, String Office ){
		
		
		name.sendKeys(Name);
		log.info("write in name"+name.toString());
		email.sendKeys(Email);
		log.info("write in email"+email.toString());
		mobile.sendKeys(Mobile);
		log.info("write in mobile"+mobile.toString());
		office.sendKeys(Office);
		log.info("write in office"+office.toString());
		
		Select slc = new Select(dropdown);
		slc.selectByVisibleText("Agile");
		
		log.info("select from dropdown"+slc.toString());
		
		
		message.sendKeys("Please contact with me");
		log.info("write in message"+message.toString());
		submit.click();
		log.info("click on submit"+submit.toString());
		
	}
		
	

	public void getMessageTest(){
		


		String sm= success_message.getText();
		String em= error_message.getText();
		
		
		
		boolean isDisplayed1= nameAlert.isDisplayed();
		boolean isDisplayed2= emailAlert.isDisplayed();
		boolean isDisplayed3= messageAlert.isDisplayed();
		
		
		if(isDisplayed1)
		{
			System.out.println("Please fill in the required field"+nameAlert.getText());
			System.out.println(em);
		}
		
		if(isDisplayed2){
			System.out.println("Please fill in the required field"+emailAlert.getText());
			System.out.println(em);
		}
		
		if(isDisplayed3){
			System.out.println("Please fill in the required field"+messageAlert.getText());
			System.out.println(em);
		}
		
		else{
			System.out.println(sm);
		}
		
	}
	
	
	
		
		}
	
	
	

	

