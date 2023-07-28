package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testComponents.BaseTest;

public class StandnaloneTest extends BaseTest{

	public void OrderFlowEndToEnd() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		

		List<WebElement> productsName = driver.findElements(By.cssSelector("div[class='product'] h4"));
		List<WebElement> addToCartButton = driver.findElements(By.xpath("//div[@class='product-action']/button"));

		String product = "Cucumber";

		for (int i = 0; i < productsName.size(); i++) {
			String name = productsName.get(i).getText().split("-")[0];
			if (product.equalsIgnoreCase(name.trim())) {
				addToCartButton.get(i).click();
				break;
			}
		}
		
		

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		
		String cartProductName = driver.findElement(By.className("product-name")).getText().split("-")[0].trim();
		Assert.assertEquals(cartProductName, product);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select")));
		select.selectByValue("India");
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		System.out.println(driver.findElement(By.className("wrapperTwo")).getText());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*='blinkingText']")));
		
		
		String blinkMessage = "Free Access to InterviewQues/ResumeAssistance/Material";
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("a[class*='blinkingText']")).getText(), blinkMessage);
		System.out.println("Completed");
		
	}

}
