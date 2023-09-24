package Hapana.Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.sun.net.httpserver.Authenticator.Retry;

import Hapana.PageObjects.productcatalauge;
import Hapana.TestComponent.BaseTest;
import Hapana.TestComponent.Retry;

public class ErrorValidations extends BaseTest {

	@Test(groups = { "ErrorHandling" })
	public void loginErrorValidation() {

		landingpage.loginApplication("laxmiauto@test.com", "Admin@12");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());

	}

	@Test(retryAnalyzer = Retry.class)
	public void ProductErrorValidation() {
		String productName = "ADIDAS ORIGINAL";
		productcatalauge product = new productcatalauge(driver);
		List<WebElement> products = product.getProductList();
		product.addproductToCart(productName);
		product.gotoCartPage();
	}

}
