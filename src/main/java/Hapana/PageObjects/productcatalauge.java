package Hapana.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hapana.AbstractComponent.AbstractComponent;

public class productcatalauge extends AbstractComponent {

	// private static final String String = null;

	WebDriver driver;

	public productcatalauge(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement sppiner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToApper(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {

		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		//System.out.print(productName);
		//System.out.print(prod);
		return prod;

	}

	public void addproductToCart(String productname) {
		WebElement prod = getProductByName(productname);
		prod.findElement(addToCart).click();
		waitForElementToApper(toastMessage);
		waitForElementToDisapper(sppiner);
		//driver.findElement(By.cssSelector(".totalRow button")).click();
	}

}
