package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.CommonComponents;

public class HomePage extends CommonComponents {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='product'] h4")
	List<WebElement> productsName;

	@FindBy(xpath = "//div[@class='product-action']/button")
	List<WebElement> addToCartButton;

	
	By blinkElement = By.cssSelector("a[class*='blinkingText']");
	
	public String getBlinkingText() {

		waitForElementAppearLocator(blinkElement);
		return driver.findElement(blinkElement).getText();
		
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public void addProductToCart(String item) {

		for (int i = 0; i < productsName.size(); i++) {
			String name = productsName.get(i).getText().split("-")[0].trim();
			if (item.equalsIgnoreCase(name)) {
				addToCartButton.get(i).click();
				break;
			}
		}

	}

}
