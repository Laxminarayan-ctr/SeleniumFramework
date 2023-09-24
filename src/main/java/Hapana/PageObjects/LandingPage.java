package Hapana.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hapana.AbstractComponent.AbstractComponent;
import Hapana.PageObjects.productcatalauge;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement UseEmail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement UserEmail;

	@FindBy(id = "userPassword")
	WebElement UserPassword;

	@FindBy(id = "login")
	WebElement Submit;

	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;

	public productcatalauge loginApplication(String email, String password) {
		UserEmail.sendKeys(email);
		UserPassword.sendKeys(password);
		Submit.click();
		productcatalauge ProductCatalogue = new productcatalauge(driver);
		return ProductCatalogue;

	}

	public String getErrorMessage()
	{
		waitForWebElement(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
