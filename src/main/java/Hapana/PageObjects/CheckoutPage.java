package Hapana.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Hapana.AbstractComponent.AbstractComponent;

import org.openqa.selenium.interactions.Actions;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver  driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath ="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectIndia;
	
	By results = By.cssSelector(".ta-results");
	
	
	
	public void SelectCountry(String countryname )
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		waitForElementToApper(By.cssSelector(".ta-results"));
		selectIndia.click();
		
	}
	
	public ConfirmationPage submitOrder()
	{
		javaExecute(submit);
		return new ConfirmationPage(driver);
		
	}

			
	
	
	
	
	

}
