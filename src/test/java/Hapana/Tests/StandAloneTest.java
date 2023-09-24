package Hapana.Tests;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("laxmiauto@test.com");
		driver.findElement(By.id("userPassword")).sendKeys("Admin@123");
		driver.findElement(By.id("login")).click();
		// String[] name = { "ADIDAS ORIGINAL"};
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement pro = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		/*
		 * List<WebElement> cartsections =
		 * driver.findElements(By.xpath("//div[@class='cartSection'] /h3")); boolean
		 * match = cartsections.stream() .anyMatch(cartsection ->
		 * cartsection.getText().equalsIgnoreCase(productName));
		 * Assert.assertTrue(match);
		 */
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		
		
		
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Place Order ']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		String k =  driver.findElement(By.cssSelector("tbody h1")).getText();
		Assert.assertTrue(k.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*
		 * Actions action = new Actions(driver);
		 * 
		 * action.sendKeys(driver.findElement(By.
		 * cssSelector("[placeholder ='Select Country']")), "India").build() .perform();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * ".ta-results")));
		 * 
		 * driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
		 * 
		 * driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		 * 
		 * WebElement element = driver.findElement(By.cssSelector(".action__submit"));
		 * 
		 * action.moveToElement(element).click().build().perform();
		 */
		// driver.findElement(By.cssSelector(".action__submit")).click();

		/*
		 * for (int i = 0; i < products.size(); i++) { String[] pro =
		 * products.get(i).getText().split(" "); String formatted = pro[0]; List<String>
		 * item = Arrays.asList(name); if (item.contains(formatted)) {
		 * driver.findElements(By.cssSelector(".card-body button:last-of-type")).get(i).
		 * click();
		 * 
		 * }
		 * 
		 * }
		 */

	}

}
