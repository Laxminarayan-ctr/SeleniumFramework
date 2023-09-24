package Hapana.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Hapana.PageObjects.CheckoutPage;
import Hapana.PageObjects.ConfirmationPage;
import Hapana.PageObjects.LandingPage;
import Hapana.PageObjects.OrderPage;
import Hapana.PageObjects.cartPage;
import Hapana.PageObjects.productcatalauge;
import Hapana.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import Hapana.PageObjects.productcatalauge;

public class SubmitOrderTest extends BaseTest {

	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getdata", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// String productName = "ADIDAS ORIGINAL";

		landingpage.loginApplication(input.get("email"), input.get("password"));

		productcatalauge product = new productcatalauge(driver);
		List<WebElement> products = product.getProductList();
		product.addproductToCart(input.get("productName"));
		product.gotoCartPage();

		cartPage cp = new cartPage(driver);

		// driver.findElement(By.cssSelector(".totalRow button")).click();

		CheckoutPage checkoutpage = cp.gotoCheckOut();
		checkoutpage.SelectCountry("india");
		ConfirmationPage Con = checkoutpage.submitOrder();
		String ordered = Con.getConfirmationMessage();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", ordered);
		// driver.quit();

	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrdersHistory() throws IOException {
		productcatalauge ProductCatalogue = landingpage.loginApplication("laxmiauto@test.com", "Admin@123");
		OrderPage ordersPage = ProductCatalogue.goToOrdersPage();
		ordersPage.VerifyOrderDispalying(productName);

	}

	@DataProvider
	public Object[][] getdata() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Hapana//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) } };
	}

//	@DataProvider
//	  public Object[][] getData()
//	  {
//	    return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
//	    
//	  }

	/*
	 * HashMap<String,String> map = new HashMap<String,String>();
	 * map.put("email","laxmiauto@test.com"); map.put("password","Admin@123");
	 * map.put("productName","ADIDAS ORIGINAL");
	 * 
	 * HashMap<String,String> map1 = new HashMap<String,String>();
	 * map1.put("email","laxmiauto1@test.com"); map1.put("password","Admin@123");
	 * map1.put("productName","ADIDAS ORIGINAL");
	 */

}
