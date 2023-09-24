package Hapana.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hapana.AbstractComponent.AbstractComponent;

public class cartPage extends AbstractComponent {

	WebDriver driver;
	@FindBy(css = ".totalRow button")
	WebElement checkEle;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public CheckoutPage gotoCheckOut() throws InterruptedException {
		waitForElement();
		checkEle.click();
		return new CheckoutPage(driver);

	}

}
